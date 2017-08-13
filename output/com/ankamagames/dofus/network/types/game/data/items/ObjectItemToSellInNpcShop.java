package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemToSellInNpcShop extends ObjectItemMinimalInformation implements INetworkType {

    private int protocolId = 352;
    private Number objectPrice = 0;
    private String buyCriterion = "";


    public int getTypeId() {
         return 352;
    }

    public ObjectItemToSellInNpcShop initObjectItemToSellInNpcShop(int param1,Vector<ObjectEffect>  param2,Number  param3,String  param4) {
         super.initObjectItemMinimalInformation(param1,param2);
         this.objectPrice = param3;
         this.buyCriterion = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.objectPrice = 0;
         this.buyCriterion = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemToSellInNpcShop(param1);
    }

    public void serializeAs_ObjectItemToSellInNpcShop(ICustomDataOutput param1) {
         super.serializeAs_ObjectItemMinimalInformation(param1);
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectPrice + ") on element objectPrice.");
         }
         param1.writeVarLong(this.objectPrice);
         param1.writeUTF(this.buyCriterion);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemToSellInNpcShop(param1);
    }

    public void deserializeAs_ObjectItemToSellInNpcShop(ICustomDataInput param1) {
         super.deserialize(param1);
         this._objectPriceFunc(param1);
         this._buyCriterionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemToSellInNpcShop(param1);
    }

    public void deserializeAsyncAs_ObjectItemToSellInNpcShop(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._objectPriceFunc);
         param1.addChild(this._buyCriterionFunc);
    }

    private void _objectPriceFunc(ICustomDataInput param1) {
         this.objectPrice = param1.readVarUhLong();
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectPrice + ") on element of ObjectItemToSellInNpcShop.objectPrice.");
         }
    }

    private void _buyCriterionFunc(ICustomDataInput param1) {
         this.buyCriterion = param1.readUTF();
    }

}