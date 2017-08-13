package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

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

public class HouseSellRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5697;
    private boolean _isInitialized = false;
    private int instanceId = 0;
    private Number amount = 0;
    private boolean forSale = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5697;
    }

    public HouseSellRequestMessage initHouseSellRequestMessage(int param1,Number  param2,boolean  param3) {
         this.instanceId = param1;
         this.amount = param2;
         this.forSale = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.instanceId = 0;
         this.amount = 0;
         this.forSale = false;
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
         this.serializeAs_HouseSellRequestMessage(param1);
    }

    public void serializeAs_HouseSellRequestMessage(ICustomDataOutput param1) {
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         if(this.amount < 0 || this.amount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.amount + ") on element amount.");
         }
         param1.writeVarLong(this.amount);
         param1.writeBoolean(this.forSale);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseSellRequestMessage(param1);
    }

    public void deserializeAs_HouseSellRequestMessage(ICustomDataInput param1) {
         this._instanceIdFunc(param1);
         this._amountFunc(param1);
         this._forSaleFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseSellRequestMessage(param1);
    }

    public void deserializeAsyncAs_HouseSellRequestMessage(FuncTree param1) {
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._amountFunc);
         param1.addChild(this._forSaleFunc);
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseSellRequestMessage.instanceId.");
         }
    }

    private void _amountFunc(ICustomDataInput param1) {
         this.amount = param1.readVarUhLong();
         if(this.amount < 0 || this.amount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.amount + ") on element of HouseSellRequestMessage.amount.");
         }
    }

    private void _forSaleFunc(ICustomDataInput param1) {
         this.forSale = param1.readBoolean();
    }

}