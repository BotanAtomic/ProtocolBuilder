package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockBuyRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5951;
    private boolean _isInitialized = false;
    private Number proposedPrice = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5951;
    }

    public PaddockBuyRequestMessage initPaddockBuyRequestMessage(Number param1) {
         this.proposedPrice = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.proposedPrice = 0;
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
         this.serializeAs_PaddockBuyRequestMessage(param1);
    }

    public void serializeAs_PaddockBuyRequestMessage(ICustomDataOutput param1) {
         if(this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.proposedPrice + ") on element proposedPrice.");
         }
         param1.writeVarLong(this.proposedPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockBuyRequestMessage(param1);
    }

    public void deserializeAs_PaddockBuyRequestMessage(ICustomDataInput param1) {
         this._proposedPriceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockBuyRequestMessage(param1);
    }

    public void deserializeAsyncAs_PaddockBuyRequestMessage(FuncTree param1) {
         param1.addChild(this._proposedPriceFunc);
    }

    private void _proposedPriceFunc(ICustomDataInput param1) {
         this.proposedPrice = param1.readVarUhLong();
         if(this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.proposedPrice + ") on element of PaddockBuyRequestMessage.proposedPrice.");
         }
    }

}