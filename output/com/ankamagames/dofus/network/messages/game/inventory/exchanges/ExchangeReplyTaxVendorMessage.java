package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

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

public class ExchangeReplyTaxVendorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5787;
    private boolean _isInitialized = false;
    private Number objectValue = 0;
    private Number totalTaxValue = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5787;
    }

    public ExchangeReplyTaxVendorMessage initExchangeReplyTaxVendorMessage(Number param1,Number  param2) {
         this.objectValue = param1;
         this.totalTaxValue = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectValue = 0;
         this.totalTaxValue = 0;
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
         this.serializeAs_ExchangeReplyTaxVendorMessage(param1);
    }

    public void serializeAs_ExchangeReplyTaxVendorMessage(ICustomDataOutput param1) {
         if(this.objectValue < 0 || this.objectValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectValue + ") on element objectValue.");
         }
         param1.writeVarLong(this.objectValue);
         if(this.totalTaxValue < 0 || this.totalTaxValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.totalTaxValue + ") on element totalTaxValue.");
         }
         param1.writeVarLong(this.totalTaxValue);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeReplyTaxVendorMessage(param1);
    }

    public void deserializeAs_ExchangeReplyTaxVendorMessage(ICustomDataInput param1) {
         this._objectValueFunc(param1);
         this._totalTaxValueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeReplyTaxVendorMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeReplyTaxVendorMessage(FuncTree param1) {
         param1.addChild(this._objectValueFunc);
         param1.addChild(this._totalTaxValueFunc);
    }

    private void _objectValueFunc(ICustomDataInput param1) {
         this.objectValue = param1.readVarUhLong();
         if(this.objectValue < 0 || this.objectValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectValue + ") on element of ExchangeReplyTaxVendorMessage.objectValue.");
         }
    }

    private void _totalTaxValueFunc(ICustomDataInput param1) {
         this.totalTaxValue = param1.readVarUhLong();
         if(this.totalTaxValue < 0 || this.totalTaxValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.totalTaxValue + ") on element of ExchangeReplyTaxVendorMessage.totalTaxValue.");
         }
    }

}