package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemQuantity extends Item implements INetworkType {

    private int protocolId = 119;
    private int objectUID = 0;
    private int quantity = 0;


    public int getTypeId() {
         return 119;
    }

    public ObjectItemQuantity initObjectItemQuantity(int param1,int  param2) {
         this.objectUID = param1;
         this.quantity = param2;
         return this;
    }

    public void reset() {
         this.objectUID = 0;
         this.quantity = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemQuantity(param1);
    }

    public void serializeAs_ObjectItemQuantity(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemQuantity(param1);
    }

    public void deserializeAs_ObjectItemQuantity(ICustomDataInput param1) {
         super.deserialize(param1);
         this._objectUIDFunc(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemQuantity(param1);
    }

    public void deserializeAsyncAs_ObjectItemQuantity(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._quantityFunc);
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ObjectItemQuantity.objectUID.");
         }
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ObjectItemQuantity.quantity.");
         }
    }

}