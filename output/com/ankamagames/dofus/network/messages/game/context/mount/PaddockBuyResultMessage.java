package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockBuyResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6516;
    private boolean _isInitialized = false;
    private int paddockId = 0;
    private boolean bought = false;
    private Number realPrice = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6516;
    }

    public PaddockBuyResultMessage initPaddockBuyResultMessage(int param1,boolean  param2,Number  param3) {
         this.paddockId = param1;
         this.bought = param2;
         this.realPrice = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.paddockId = 0;
         this.bought = false;
         this.realPrice = 0;
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
         this.serializeAs_PaddockBuyResultMessage(param1);
    }

    public void serializeAs_PaddockBuyResultMessage(ICustomDataOutput param1) {
         param1.writeInt(this.paddockId);
         param1.writeBoolean(this.bought);
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element realPrice.");
         }
         param1.writeVarLong(this.realPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockBuyResultMessage(param1);
    }

    public void deserializeAs_PaddockBuyResultMessage(ICustomDataInput param1) {
         this._paddockIdFunc(param1);
         this._boughtFunc(param1);
         this._realPriceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockBuyResultMessage(param1);
    }

    public void deserializeAsyncAs_PaddockBuyResultMessage(FuncTree param1) {
         param1.addChild(this._paddockIdFunc);
         param1.addChild(this._boughtFunc);
         param1.addChild(this._realPriceFunc);
    }

    private void _paddockIdFunc(ICustomDataInput param1) {
         this.paddockId = param1.readInt();
    }

    private void _boughtFunc(ICustomDataInput param1) {
         this.bought = param1.readBoolean();
    }

    private void _realPriceFunc(ICustomDataInput param1) {
         this.realPrice = param1.readVarUhLong();
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element of PaddockBuyResultMessage.realPrice.");
         }
    }

}