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

public class ExchangeOkMultiCraftMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5768;
    private boolean _isInitialized = false;
    private Number initiatorId = 0;
    private Number otherId = 0;
    private int role = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5768;
    }

    public ExchangeOkMultiCraftMessage initExchangeOkMultiCraftMessage(Number param1,Number  param2,int  param3) {
         this.initiatorId = param1;
         this.otherId = param2;
         this.role = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.initiatorId = 0;
         this.otherId = 0;
         this.role = 0;
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
         this.serializeAs_ExchangeOkMultiCraftMessage(param1);
    }

    public void serializeAs_ExchangeOkMultiCraftMessage(ICustomDataOutput param1) {
         if(this.initiatorId < 0 || this.initiatorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.initiatorId + ") on element initiatorId.");
         }
         param1.writeVarLong(this.initiatorId);
         if(this.otherId < 0 || this.otherId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.otherId + ") on element otherId.");
         }
         param1.writeVarLong(this.otherId);
         param1.writeByte(this.role);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeOkMultiCraftMessage(param1);
    }

    public void deserializeAs_ExchangeOkMultiCraftMessage(ICustomDataInput param1) {
         this._initiatorIdFunc(param1);
         this._otherIdFunc(param1);
         this._roleFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeOkMultiCraftMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeOkMultiCraftMessage(FuncTree param1) {
         param1.addChild(this._initiatorIdFunc);
         param1.addChild(this._otherIdFunc);
         param1.addChild(this._roleFunc);
    }

    private void _initiatorIdFunc(ICustomDataInput param1) {
         this.initiatorId = param1.readVarUhLong();
         if(this.initiatorId < 0 || this.initiatorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.initiatorId + ") on element of ExchangeOkMultiCraftMessage.initiatorId.");
         }
    }

    private void _otherIdFunc(ICustomDataInput param1) {
         this.otherId = param1.readVarUhLong();
         if(this.otherId < 0 || this.otherId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.otherId + ") on element of ExchangeOkMultiCraftMessage.otherId.");
         }
    }

    private void _roleFunc(ICustomDataInput param1) {
         this.role = param1.readByte();
    }

}