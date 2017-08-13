package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftCountRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6597;
    private boolean _isInitialized = false;
    private int count = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6597;
    }

    public ExchangeCraftCountRequestMessage initExchangeCraftCountRequestMessage(int param1) {
         this.count = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.count = 0;
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
         this.serializeAs_ExchangeCraftCountRequestMessage(param1);
    }

    public void serializeAs_ExchangeCraftCountRequestMessage(ICustomDataOutput param1) {
         param1.writeVarInt(this.count);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftCountRequestMessage(param1);
    }

    public void deserializeAs_ExchangeCraftCountRequestMessage(ICustomDataInput param1) {
         this._countFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCraftCountRequestMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCraftCountRequestMessage(FuncTree param1) {
         param1.addChild(this._countFunc);
    }

    private void _countFunc(ICustomDataInput param1) {
         this.count = param1.readVarInt();
    }

}