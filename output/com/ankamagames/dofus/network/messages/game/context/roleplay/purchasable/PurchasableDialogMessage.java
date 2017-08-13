package com.ankamagames.dofus.network.messages.game.context.roleplay.purchasable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PurchasableDialogMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5739;
    private boolean _isInitialized = false;
    private boolean buyOrSell = false;
    private int purchasableId = 0;
    private int purchasableInstanceId = 0;
    private boolean secondHand = false;
    private Number price = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5739;
    }

    public PurchasableDialogMessage initPurchasableDialogMessage(boolean param1,int  param2,int  param3,boolean  param4,Number  param5) {
         this.buyOrSell = param1;
         this.purchasableId = param2;
         this.purchasableInstanceId = param3;
         this.secondHand = param4;
         this.price = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.buyOrSell = false;
         this.purchasableId = 0;
         this.purchasableInstanceId = 0;
         this.secondHand = false;
         this.price = 0;
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
         this.serializeAs_PurchasableDialogMessage(param1);
    }

    public void serializeAs_PurchasableDialogMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.buyOrSell);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.secondHand);
         param1.writeByte(_loc2_);
         if(this.purchasableId < 0)
         {
            throw new Exception("Forbidden value (" + this.purchasableId + ") on element purchasableId.");
         }
         param1.writeVarInt(this.purchasableId);
         if(this.purchasableInstanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.purchasableInstanceId + ") on element purchasableInstanceId.");
         }
         param1.writeInt(this.purchasableInstanceId);
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PurchasableDialogMessage(param1);
    }

    public void deserializeAs_PurchasableDialogMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._purchasableIdFunc(param1);
         this._purchasableInstanceIdFunc(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PurchasableDialogMessage(param1);
    }

    public void deserializeAsyncAs_PurchasableDialogMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._purchasableIdFunc);
         param1.addChild(this._purchasableInstanceIdFunc);
         param1.addChild(this._priceFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.buyOrSell = BooleanByteWrapper.getFlag(_loc2_,0);
         this.secondHand = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _purchasableIdFunc(ICustomDataInput param1) {
         this.purchasableId = param1.readVarUhInt();
         if(this.purchasableId < 0)
         {
            throw new Exception("Forbidden value (" + this.purchasableId + ") on element of PurchasableDialogMessage.purchasableId.");
         }
    }

    private void _purchasableInstanceIdFunc(ICustomDataInput param1) {
         this.purchasableInstanceId = param1.readInt();
         if(this.purchasableInstanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.purchasableInstanceId + ") on element of PurchasableDialogMessage.purchasableInstanceId.");
         }
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of PurchasableDialogMessage.price.");
         }
    }

}