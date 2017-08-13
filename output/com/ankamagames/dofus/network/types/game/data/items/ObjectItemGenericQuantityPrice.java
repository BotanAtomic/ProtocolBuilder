package package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemGenericQuantityPrice extends ObjectItemGenericQuantity implements INetworkType {

    private int protocolId = 494;
    private Number price = 0;


    public int getTypeId() {
         return 494;
    }

    public ObjectItemGenericQuantityPrice initObjectItemGenericQuantityPrice(int param1,int  param2,Number  param3) {
         super.initObjectItemGenericQuantity(param1,param2);
         this.price = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.price = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemGenericQuantityPrice(param1);
    }

    public void serializeAs_ObjectItemGenericQuantityPrice(ICustomDataOutput param1) {
         super.serializeAs_ObjectItemGenericQuantity(param1);
         if(this.price < 0 || this.price > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemGenericQuantityPrice(param1);
    }

    public void deserializeAs_ObjectItemGenericQuantityPrice(ICustomDataInput param1) {
         super.deserialize(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemGenericQuantityPrice(param1);
    }

    public void deserializeAsyncAs_ObjectItemGenericQuantityPrice(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._priceFunc);
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.price + ") on element of ObjectItemGenericQuantityPrice.price.");
    }

}