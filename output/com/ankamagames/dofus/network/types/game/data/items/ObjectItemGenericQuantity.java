package package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemGenericQuantity extends Item implements INetworkType {

    private int protocolId = 483;
    private int objectGID = 0;
    private int quantity = 0;


    public int getTypeId() {
         return 483;
    }

    public ObjectItemGenericQuantity initObjectItemGenericQuantity(int param1,int  param2) {
         this.objectGID = param1;
         this.quantity = param2;
         return this;
    }

    public void reset() {
         this.objectGID = 0;
         this.quantity = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemGenericQuantity(param1);
    }

    public void serializeAs_ObjectItemGenericQuantity(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         if(this.objectGID < 0)
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemGenericQuantity(param1);
    }

    public void deserializeAs_ObjectItemGenericQuantity(ICustomDataInput param1) {
         super.deserialize(param1);
         this._objectGIDFunc(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemGenericQuantity(param1);
    }

    public void deserializeAsyncAs_ObjectItemGenericQuantity(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._objectGIDFunc);
         param1.addChild(this._quantityFunc);
    }

    private void _objectGIDFunc(ICustomDataInput param1) {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of ObjectItemGenericQuantity.objectGID.");
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ObjectItemGenericQuantity.quantity.");
    }

}