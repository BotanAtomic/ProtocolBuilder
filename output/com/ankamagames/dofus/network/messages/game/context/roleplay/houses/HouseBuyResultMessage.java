package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

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

public class HouseBuyResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5735;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean secondHand = false;
    private boolean bought = false;
    private Number realPrice = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5735;
    }

    public HouseBuyResultMessage initHouseBuyResultMessage(int param1,int  param2,boolean  param3,boolean  param4,Number  param5) {
         this.houseId = param1;
         this.instanceId = param2;
         this.secondHand = param3;
         this.bought = param4;
         this.realPrice = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.instanceId = 0;
         this.secondHand = false;
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
         this.serializeAs_HouseBuyResultMessage(param1);
    }

    public void serializeAs_HouseBuyResultMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.secondHand);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.bought);
         param1.writeByte(_loc2_);
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element realPrice.");
         }
         param1.writeVarLong(this.realPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseBuyResultMessage(param1);
    }

    public void deserializeAs_HouseBuyResultMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._houseIdFunc(param1);
         this._instanceIdFunc(param1);
         this._realPriceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseBuyResultMessage(param1);
    }

    public void deserializeAsyncAs_HouseBuyResultMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._realPriceFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.secondHand = BooleanByteWrapper.getFlag(_loc2_,0);
         this.bought = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseBuyResultMessage.houseId.");
         }
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseBuyResultMessage.instanceId.");
         }
    }

    private void _realPriceFunc(ICustomDataInput param1) {
         this.realPrice = param1.readVarUhLong();
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element of HouseBuyResultMessage.realPrice.");
         }
    }

}