package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.SellerBuyerDescriptor;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartedBidBuyerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5904;
    private boolean _isInitialized = false;
    private SellerBuyerDescriptor buyerDescriptor;
    private FuncTree _buyerDescriptortree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5904;
    }

    public ExchangeStartedBidBuyerMessage initExchangeStartedBidBuyerMessage(SellerBuyerDescriptor param1) {
         this.buyerDescriptor = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.buyerDescriptor = new SellerBuyerDescriptor();
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
         this.serializeAs_ExchangeStartedBidBuyerMessage(param1);
    }

    public void serializeAs_ExchangeStartedBidBuyerMessage(ICustomDataOutput param1) {
         this.buyerDescriptor.serializeAs_SellerBuyerDescriptor(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartedBidBuyerMessage(param1);
    }

    public void deserializeAs_ExchangeStartedBidBuyerMessage(ICustomDataInput param1) {
         this.buyerDescriptor = new SellerBuyerDescriptor();
         this.buyerDescriptor.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartedBidBuyerMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartedBidBuyerMessage(FuncTree param1) {
         this._buyerDescriptortree = param1.addChild(this._buyerDescriptortreeFunc);
    }

    private void _buyerDescriptortreeFunc(ICustomDataInput param1) {
         this.buyerDescriptor = new SellerBuyerDescriptor();
         this.buyerDescriptor.deserializeAsync(this._buyerDescriptortree);
    }

}