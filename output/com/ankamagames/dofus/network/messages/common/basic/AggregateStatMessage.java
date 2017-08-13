package package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AggregateStatMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6669;
    private boolean _isInitialized = false;
    private int statId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6669;
    }

    public AggregateStatMessage initAggregateStatMessage(int param1) {
         this.statId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.statId = 0;
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
         this.serializeAs_AggregateStatMessage(param1);
    }

    public void serializeAs_AggregateStatMessage(ICustomDataOutput param1) {
         param1.writeVarShort(this.statId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AggregateStatMessage(param1);
    }

    public void deserializeAs_AggregateStatMessage(ICustomDataInput param1) {
         this._statIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AggregateStatMessage(param1);
    }

    public void deserializeAsyncAs_AggregateStatMessage(FuncTree param1) {
         param1.addChild(this._statIdFunc);
    }

    private void _statIdFunc(ICustomDataInput param1) {
         this.statId = param1.readVarUhShort();
         if(this.statId < 0)
            throw new Exception("Forbidden value (" + this.statId + ") on element of AggregateStatMessage.statId.");
    }

}