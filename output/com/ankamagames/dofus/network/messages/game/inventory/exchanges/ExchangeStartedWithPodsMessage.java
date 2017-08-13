package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeStartedWithPodsMessage extends ExchangeStartedMessage implements INetworkMessage {

    private int protocolId = 6129;
    private boolean _isInitialized = false;
    private Number firstCharacterId = 0;
    private int firstCharacterCurrentWeight = 0;
    private int firstCharacterMaxWeight = 0;
    private Number secondCharacterId = 0;
    private int secondCharacterCurrentWeight = 0;
    private int secondCharacterMaxWeight = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6129;
    }

    public ExchangeStartedWithPodsMessage initExchangeStartedWithPodsMessage(int param1,Number  param2,int  param3,int  param4,Number  param5,int  param6,int  param7) {
         super.initExchangeStartedMessage(param1);
         this.firstCharacterId = param2;
         this.firstCharacterCurrentWeight = param3;
         this.firstCharacterMaxWeight = param4;
         this.secondCharacterId = param5;
         this.secondCharacterCurrentWeight = param6;
         this.secondCharacterMaxWeight = param7;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.firstCharacterId = 0;
         this.firstCharacterCurrentWeight = 0;
         this.firstCharacterMaxWeight = 0;
         this.secondCharacterId = 0;
         this.secondCharacterCurrentWeight = 0;
         this.secondCharacterMaxWeight = 0;
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
         this.serializeAs_ExchangeStartedWithPodsMessage(param1);
    }

    public void serializeAs_ExchangeStartedWithPodsMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeStartedMessage(param1);
         if(this.firstCharacterId < -9.007199254740992E15 || this.firstCharacterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.firstCharacterId + ") on element firstCharacterId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartedWithPodsMessage(param1);
    }

    public void deserializeAs_ExchangeStartedWithPodsMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._firstCharacterIdFunc(param1);
         this._firstCharacterCurrentWeightFunc(param1);
         this._firstCharacterMaxWeightFunc(param1);
         this._secondCharacterIdFunc(param1);
         this._secondCharacterCurrentWeightFunc(param1);
         this._secondCharacterMaxWeightFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartedWithPodsMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartedWithPodsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._firstCharacterIdFunc);
         param1.addChild(this._firstCharacterCurrentWeightFunc);
         param1.addChild(this._firstCharacterMaxWeightFunc);
         param1.addChild(this._secondCharacterIdFunc);
         param1.addChild(this._secondCharacterCurrentWeightFunc);
         param1.addChild(this._secondCharacterMaxWeightFunc);
    }

    private void _firstCharacterIdFunc(ICustomDataInput param1) {
         this.firstCharacterId = param1.readDouble();
         if(this.firstCharacterId < -9.007199254740992E15 || this.firstCharacterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.firstCharacterId + ") on element of ExchangeStartedWithPodsMessage.firstCharacterId.");
    }

    private void _firstCharacterCurrentWeightFunc(ICustomDataInput param1) {
         this.firstCharacterCurrentWeight = param1.readVarUhInt();
         if(this.firstCharacterCurrentWeight < 0)
            throw new Exception("Forbidden value (" + this.firstCharacterCurrentWeight + ") on element of ExchangeStartedWithPodsMessage.firstCharacterCurrentWeight.");
    }

    private void _firstCharacterMaxWeightFunc(ICustomDataInput param1) {
         this.firstCharacterMaxWeight = param1.readVarUhInt();
         if(this.firstCharacterMaxWeight < 0)
            throw new Exception("Forbidden value (" + this.firstCharacterMaxWeight + ") on element of ExchangeStartedWithPodsMessage.firstCharacterMaxWeight.");
    }

    private void _secondCharacterIdFunc(ICustomDataInput param1) {
         this.secondCharacterId = param1.readDouble();
         if(this.secondCharacterId < -9.007199254740992E15 || this.secondCharacterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.secondCharacterId + ") on element of ExchangeStartedWithPodsMessage.secondCharacterId.");
    }

    private void _secondCharacterCurrentWeightFunc(ICustomDataInput param1) {
         this.secondCharacterCurrentWeight = param1.readVarUhInt();
         if(this.secondCharacterCurrentWeight < 0)
            throw new Exception("Forbidden value (" + this.secondCharacterCurrentWeight + ") on element of ExchangeStartedWithPodsMessage.secondCharacterCurrentWeight.");
    }

    private void _secondCharacterMaxWeightFunc(ICustomDataInput param1) {
         this.secondCharacterMaxWeight = param1.readVarUhInt();
         if(this.secondCharacterMaxWeight < 0)
            throw new Exception("Forbidden value (" + this.secondCharacterMaxWeight + ") on element of ExchangeStartedWithPodsMessage.secondCharacterMaxWeight.");
    }

}