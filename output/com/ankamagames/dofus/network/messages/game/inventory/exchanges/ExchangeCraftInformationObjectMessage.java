package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeCraftInformationObjectMessage extends ExchangeCraftResultWithObjectIdMessage implements INetworkMessage {

    private int protocolId = 5794;
    private boolean _isInitialized = false;
    private Number playerId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5794;
    }

    public ExchangeCraftInformationObjectMessage initExchangeCraftInformationObjectMessage(int param1,int  param2,Number  param3) {
         super.initExchangeCraftResultWithObjectIdMessage(param1,param2);
         this.playerId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.playerId = 0;
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
         this.serializeAs_ExchangeCraftInformationObjectMessage(param1);
    }

    public void serializeAs_ExchangeCraftInformationObjectMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultWithObjectIdMessage(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftInformationObjectMessage(param1);
    }

    public void deserializeAs_ExchangeCraftInformationObjectMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._playerIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCraftInformationObjectMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCraftInformationObjectMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._playerIdFunc);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element of ExchangeCraftInformationObjectMessage.playerId.");
    }

}