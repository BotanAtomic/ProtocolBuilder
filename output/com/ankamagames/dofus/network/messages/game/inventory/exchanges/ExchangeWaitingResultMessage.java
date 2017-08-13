package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeWaitingResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5786;
    private boolean _isInitialized = false;
    private boolean bwait = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5786;
    }

    public ExchangeWaitingResultMessage initExchangeWaitingResultMessage(boolean param1) {
         this.bwait = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.bwait = false;
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
         this.serializeAs_ExchangeWaitingResultMessage(param1);
    }

    public void serializeAs_ExchangeWaitingResultMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.bwait);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeWaitingResultMessage(param1);
    }

    public void deserializeAs_ExchangeWaitingResultMessage(ICustomDataInput param1) {
         this._bwaitFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeWaitingResultMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeWaitingResultMessage(FuncTree param1) {
         param1.addChild(this._bwaitFunc);
    }

    private void _bwaitFunc(ICustomDataInput param1) {
         this.bwait = param1.readBoolean();
    }

}