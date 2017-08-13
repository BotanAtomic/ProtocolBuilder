package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemInformationWithQuantity extends ObjectItemMinimalInformation implements INetworkType {

    private int protocolId = 387;
    private int quantity = 0;


    public int getTypeId() {
         return 387;
    }

    public ObjectItemInformationWithQuantity initObjectItemInformationWithQuantity(int param1,Vector<ObjectEffect>  param2,int  param3) {
         super.initObjectItemMinimalInformation(param1,param2);
         this.quantity = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.quantity = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemInformationWithQuantity(param1);
    }

    public void serializeAs_ObjectItemInformationWithQuantity(ICustomDataOutput param1) {
         super.serializeAs_ObjectItemMinimalInformation(param1);
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemInformationWithQuantity(param1);
    }

    public void deserializeAs_ObjectItemInformationWithQuantity(ICustomDataInput param1) {
         super.deserialize(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemInformationWithQuantity(param1);
    }

    public void deserializeAsyncAs_ObjectItemInformationWithQuantity(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._quantityFunc);
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ObjectItemInformationWithQuantity.quantity.");
         }
    }

}