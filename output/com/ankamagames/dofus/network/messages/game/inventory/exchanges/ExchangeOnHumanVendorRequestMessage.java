package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeOnHumanVendorRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5772;
    private boolean _isInitialized = false;
    private Number humanVendorId = 0;
    private int humanVendorCell = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5772;
    }

    public ExchangeOnHumanVendorRequestMessage initExchangeOnHumanVendorRequestMessage(Number param1,int  param2) {
         this.humanVendorId = param1;
         this.humanVendorCell = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.humanVendorId = 0;
         this.humanVendorCell = 0;
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
         this.serializeAs_ExchangeOnHumanVendorRequestMessage(param1);
    }

    public void serializeAs_ExchangeOnHumanVendorRequestMessage(ICustomDataOutput param1) {
         if(this.humanVendorId < 0 || this.humanVendorId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.humanVendorId + ") on element humanVendorId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeOnHumanVendorRequestMessage(param1);
    }

    public void deserializeAs_ExchangeOnHumanVendorRequestMessage(ICustomDataInput param1) {
         this._humanVendorIdFunc(param1);
         this._humanVendorCellFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeOnHumanVendorRequestMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeOnHumanVendorRequestMessage(FuncTree param1) {
         param1.addChild(this._humanVendorIdFunc);
         param1.addChild(this._humanVendorCellFunc);
    }

    private void _humanVendorIdFunc(ICustomDataInput param1) {
         this.humanVendorId = param1.readVarUhLong();
         if(this.humanVendorId < 0 || this.humanVendorId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.humanVendorId + ") on element of ExchangeOnHumanVendorRequestMessage.humanVendorId.");
    }

    private void _humanVendorCellFunc(ICustomDataInput param1) {
         this.humanVendorCell = param1.readVarUhShort();
         if(this.humanVendorCell < 0 || this.humanVendorCell > 559)
            throw new Exception("Forbidden value (" + this.humanVendorCell + ") on element of ExchangeOnHumanVendorRequestMessage.humanVendorCell.");
    }

}