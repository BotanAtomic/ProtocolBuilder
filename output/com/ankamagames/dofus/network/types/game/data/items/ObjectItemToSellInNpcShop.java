package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectItemToSellInNpcShop extends ObjectItemMinimalInformation implements INetworkType {

    private int protocolId = 352;
    private Number objectPrice = 0;
    private String buyCriterion = "";


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ObjectItemMinimalInformation(param1);
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectPrice + ") on element objectPrice.");
         }
         param1.writeVarLong(this.objectPrice);
         param1.writeUTF(this.buyCriterion);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         ObjectEffect _loc5_ = null;
         this.oldCellId = param1.readVarUhShort();
         if(this.oldCellId < 0 || this.oldCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.oldCellId + ") on element of PaddockMoveItemRequestMessage.oldCellId.");
         }
         this.newCellId = param1.readVarUhShort();
         if(this.newCellId < 0 || this.newCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.newCellId + ") on element of PaddockMoveItemRequestMessage.newCellId.");
         }
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of ObjectItemMinimalInformation.objectGID.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc4_);
            _loc5_.deserialize(param1);
            this.effects.push(_loc5_);
            _loc3_++;
         }
         this.objectPrice = param1.readVarUhLong();
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectPrice + ") on element of ObjectItemToSellInNpcShop.objectPrice.");
         }
         this.buyCriterion = param1.readUTF();
    }

}