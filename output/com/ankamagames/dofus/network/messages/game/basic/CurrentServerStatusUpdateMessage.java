package package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CurrentServerStatusUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6525;
    private boolean _isInitialized = false;
    private int status = 1;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6525;
    }

    public CurrentServerStatusUpdateMessage initCurrentServerStatusUpdateMessage(int param1) {
         this.status = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.status = 1;
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
         this.serializeAs_CurrentServerStatusUpdateMessage(param1);
    }

    public void serializeAs_CurrentServerStatusUpdateMessage(ICustomDataOutput param1) {
         param1.writeByte(this.status);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CurrentServerStatusUpdateMessage(param1);
    }

    public void deserializeAs_CurrentServerStatusUpdateMessage(ICustomDataInput param1) {
         this._statusFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CurrentServerStatusUpdateMessage(param1);
    }

    public void deserializeAsyncAs_CurrentServerStatusUpdateMessage(FuncTree param1) {
         param1.addChild(this._statusFunc);
    }

    private void _statusFunc(ICustomDataInput param1) {
         this.status = param1.readByte();
         if(this.status < 0)
            throw new Exception("Forbidden value (" + this.status + ") on element of CurrentServerStatusUpdateMessage.status.");
    }

}