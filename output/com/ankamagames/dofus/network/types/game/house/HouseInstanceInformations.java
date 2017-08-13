package package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HouseInstanceInformations extends Object implements INetworkType {

    private int protocolId = 511;
    private int instanceId = 0;
    private boolean secondHand = false;
    private boolean isLocked = false;
    private String ownerName = "";
    private Number price = 0;
    private boolean isSaleLocked = false;


    public int getTypeId() {
         return 511;
    }

    public HouseInstanceInformations initHouseInstanceInformations(int param1,boolean  param2,boolean  param3,String  param4,Number  param5,boolean  param6) {
         this.instanceId = param1;
         this.secondHand = param2;
         this.isLocked = param3;
         this.ownerName = param4;
         this.price = param5;
         this.isSaleLocked = param6;
         return this;
    }

    public void reset() {
         this.instanceId = 0;
         this.secondHand = false;
         this.isLocked = false;
         this.ownerName = "";
         this.price = 0;
         this.isSaleLocked = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseInstanceInformations(param1);
    }

    public void serializeAs_HouseInstanceInformations(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.secondHand);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isLocked);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isSaleLocked);
         param1.writeByte(_loc2_);
         if(this.instanceId < 0)
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseInstanceInformations(param1);
    }

    public void deserializeAs_HouseInstanceInformations(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._instanceIdFunc(param1);
         this._ownerNameFunc(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseInstanceInformations(param1);
    }

    public void deserializeAsyncAs_HouseInstanceInformations(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._ownerNameFunc);
         param1.addChild(this._priceFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.secondHand = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isLocked = BooleanByteWrapper.getFlag(_loc2_,1);
         this.isSaleLocked = BooleanByteWrapper.getFlag(_loc2_,2);
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseInstanceInformations.instanceId.");
    }

    private void _ownerNameFunc(ICustomDataInput param1) {
         this.ownerName = param1.readUTF();
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarLong();
         if(this.price < -9.007199254740992E15 || this.price > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.price + ") on element of HouseInstanceInformations.price.");
    }

}