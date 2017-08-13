package package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

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

public class HouseSellingUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6727;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean secondHand = false;
    private Number realPrice = 0;
    private String buyerName = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6727;
    }

    public HouseSellingUpdateMessage initHouseSellingUpdateMessage(int param1,int  param2,boolean  param3,Number  param4,String  param5) {
         this.houseId = param1;
         this.instanceId = param2;
         this.secondHand = param3;
         this.realPrice = param4;
         this.buyerName = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.instanceId = 0;
         this.secondHand = false;
         this.realPrice = 0;
         this.buyerName = "";
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
         this.serializeAs_HouseSellingUpdateMessage(param1);
    }

    public void serializeAs_HouseSellingUpdateMessage(ICustomDataOutput param1) {
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseSellingUpdateMessage(param1);
    }

    public void deserializeAs_HouseSellingUpdateMessage(ICustomDataInput param1) {
         this._houseIdFunc(param1);
         this._instanceIdFunc(param1);
         this._secondHandFunc(param1);
         this._realPriceFunc(param1);
         this._buyerNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseSellingUpdateMessage(param1);
    }

    public void deserializeAsyncAs_HouseSellingUpdateMessage(FuncTree param1) {
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._secondHandFunc);
         param1.addChild(this._realPriceFunc);
         param1.addChild(this._buyerNameFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseSellingUpdateMessage.houseId.");
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseSellingUpdateMessage.instanceId.");
    }

    private void _secondHandFunc(ICustomDataInput param1) {
         this.secondHand = param1.readBoolean();
    }

    private void _realPriceFunc(ICustomDataInput param1) {
         this.realPrice = param1.readVarUhLong();
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.realPrice + ") on element of HouseSellingUpdateMessage.realPrice.");
    }

    private void _buyerNameFunc(ICustomDataInput param1) {
         this.buyerName = param1.readUTF();
    }

}