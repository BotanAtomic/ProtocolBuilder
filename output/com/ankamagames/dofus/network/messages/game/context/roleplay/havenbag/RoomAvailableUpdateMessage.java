package package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class RoomAvailableUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6630;
    private boolean _isInitialized = false;
    private int nbRoom = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6630;
    }

    public RoomAvailableUpdateMessage initRoomAvailableUpdateMessage(int param1) {
         this.nbRoom = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.nbRoom = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_RoomAvailableUpdateMessage(param1);
    }

    public void serializeAs_RoomAvailableUpdateMessage(ICustomDataOutput param1) {
         if(this.nbRoom < 0 || this.nbRoom > 255)
            throw new Exception("Forbidden value (" + this.nbRoom + ") on element nbRoom.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_RoomAvailableUpdateMessage(param1);
    }

    public void deserializeAs_RoomAvailableUpdateMessage(ICustomDataInput param1) {
         this._nbRoomFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_RoomAvailableUpdateMessage(param1);
    }

    public void deserializeAsyncAs_RoomAvailableUpdateMessage(FuncTree param1) {
         param1.addChild(this._nbRoomFunc);
    }

    private void _nbRoomFunc(ICustomDataInput param1) {
         this.nbRoom = param1.readUnsignedByte();
         if(this.nbRoom < 0 || this.nbRoom > 255)
            throw new Exception("Forbidden value (" + this.nbRoom + ") on element of RoomAvailableUpdateMessage.nbRoom.");
    }

}