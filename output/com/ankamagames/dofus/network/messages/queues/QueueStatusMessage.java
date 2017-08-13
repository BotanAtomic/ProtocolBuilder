package com.ankamagames.dofus.network.messages.queues;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class QueueStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6100;
    private boolean _isInitialized = false;
    private int position = 0;
    private int total = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6100;
    }

    public QueueStatusMessage initQueueStatusMessage(int param1,int  param2) {
         this.position = param1;
         this.total = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.position = 0;
         this.total = 0;
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
         this.serializeAs_QueueStatusMessage(param1);
    }

    public void serializeAs_QueueStatusMessage(ICustomDataOutput param1) {
         if(this.position < 0 || this.position > 65535)
         {
            throw new Exception("Forbidden value (" + this.position + ") on element position.");
         }
         param1.writeShort(this.position);
         if(this.total < 0 || this.total > 65535)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element total.");
         }
         param1.writeShort(this.total);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QueueStatusMessage(param1);
    }

    public void deserializeAs_QueueStatusMessage(ICustomDataInput param1) {
         this._positionFunc(param1);
         this._totalFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QueueStatusMessage(param1);
    }

    public void deserializeAsyncAs_QueueStatusMessage(FuncTree param1) {
         param1.addChild(this._positionFunc);
         param1.addChild(this._totalFunc);
    }

    private void _positionFunc(ICustomDataInput param1) {
         this.position = param1.readUnsignedShort();
         if(this.position < 0 || this.position > 65535)
         {
            throw new Exception("Forbidden value (" + this.position + ") on element of QueueStatusMessage.position.");
         }
    }

    private void _totalFunc(ICustomDataInput param1) {
         this.total = param1.readUnsignedShort();
         if(this.total < 0 || this.total > 65535)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element of QueueStatusMessage.total.");
         }
    }

}