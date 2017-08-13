package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ChangeHavenBagRoomRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6638;
    private boolean _isInitialized = false;
    private int roomId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6638;
    }

    public ChangeHavenBagRoomRequestMessage initChangeHavenBagRoomRequestMessage(int param1) {
         this.roomId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.roomId = 0;
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
         this.serializeAs_ChangeHavenBagRoomRequestMessage(param1);
    }

    public void serializeAs_ChangeHavenBagRoomRequestMessage(ICustomDataOutput param1) {
         if(this.roomId < 0)
         {
            throw new Exception("Forbidden value (" + this.roomId + ") on element roomId.");
         }
         param1.writeByte(this.roomId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChangeHavenBagRoomRequestMessage(param1);
    }

    public void deserializeAs_ChangeHavenBagRoomRequestMessage(ICustomDataInput param1) {
         this._roomIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChangeHavenBagRoomRequestMessage(param1);
    }

    public void deserializeAsyncAs_ChangeHavenBagRoomRequestMessage(FuncTree param1) {
         param1.addChild(this._roomIdFunc);
    }

    private void _roomIdFunc(ICustomDataInput param1) {
         this.roomId = param1.readByte();
         if(this.roomId < 0)
         {
            throw new Exception("Forbidden value (" + this.roomId + ") on element of ChangeHavenBagRoomRequestMessage.roomId.");
         }
    }

}