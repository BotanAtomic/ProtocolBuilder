package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectJobAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6014;
    private boolean _isInitialized = false;
    private int jobId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6014;
    }

    public ObjectJobAddedMessage initObjectJobAddedMessage(int param1) {
         this.jobId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.jobId = 0;
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
         this.serializeAs_ObjectJobAddedMessage(param1);
    }

    public void serializeAs_ObjectJobAddedMessage(ICustomDataOutput param1) {
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectJobAddedMessage(param1);
    }

    public void deserializeAs_ObjectJobAddedMessage(ICustomDataInput param1) {
         this._jobIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectJobAddedMessage(param1);
    }

    public void deserializeAsyncAs_ObjectJobAddedMessage(FuncTree param1) {
         param1.addChild(this._jobIdFunc);
    }

    private void _jobIdFunc(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element of ObjectJobAddedMessage.jobId.");
    }

}