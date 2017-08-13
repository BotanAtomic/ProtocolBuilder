package package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CurrentMapMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 220;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private String mapKey = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 220;
    }

    public CurrentMapMessage initCurrentMapMessage(int param1,String  param2) {
         this.mapId = param1;
         this.mapKey = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mapId = 0;
         this.mapKey = "";
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
         this.serializeAs_CurrentMapMessage(param1);
    }

    public void serializeAs_CurrentMapMessage(ICustomDataOutput param1) {
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CurrentMapMessage(param1);
    }

    public void deserializeAs_CurrentMapMessage(ICustomDataInput param1) {
         this._mapIdFunc(param1);
         this._mapKeyFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CurrentMapMessage(param1);
    }

    public void deserializeAsyncAs_CurrentMapMessage(FuncTree param1) {
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._mapKeyFunc);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element of CurrentMapMessage.mapId.");
    }

    private void _mapKeyFunc(ICustomDataInput param1) {
         this.mapKey = param1.readUTF();
    }

}