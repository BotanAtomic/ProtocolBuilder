package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

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

public class PaddockSellBuyDialogMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6018;
    private boolean _isInitialized = false;
    private boolean bsell = false;
    private int ownerId = 0;
    private Number price = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6018;
    }

    public PaddockSellBuyDialogMessage initPaddockSellBuyDialogMessage(boolean param1,int  param2,Number  param3) {
         this.bsell = param1;
         this.ownerId = param2;
         this.price = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.bsell = false;
         this.ownerId = 0;
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
         this.serializeAs_PaddockSellBuyDialogMessage(param1);
    }

    public void serializeAs_PaddockSellBuyDialogMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.bsell);
         if(this.ownerId < 0)
         {
            throw new Exception("Forbidden value (" + this.ownerId + ") on element ownerId.");
         }
         param1.writeVarInt(this.ownerId);
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockSellBuyDialogMessage(param1);
    }

    public void deserializeAs_PaddockSellBuyDialogMessage(ICustomDataInput param1) {
         this._bsellFunc(param1);
         this._ownerIdFunc(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockSellBuyDialogMessage(param1);
    }

    public void deserializeAsyncAs_PaddockSellBuyDialogMessage(FuncTree param1) {
         param1.addChild(this._bsellFunc);
         param1.addChild(this._ownerIdFunc);
         param1.addChild(this._priceFunc);
    }

    private void _bsellFunc(ICustomDataInput param1) {
         this.bsell = param1.readBoolean();
    }

    private void _ownerIdFunc(ICustomDataInput param1) {
         this.ownerId = param1.readVarUhInt();
         if(this.ownerId < 0)
         {
            throw new Exception("Forbidden value (" + this.ownerId + ") on element of PaddockSellBuyDialogMessage.ownerId.");
         }
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of PaddockSellBuyDialogMessage.price.");
         }
    }

}