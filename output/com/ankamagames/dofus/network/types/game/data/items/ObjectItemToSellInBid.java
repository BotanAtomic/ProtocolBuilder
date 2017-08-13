package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectItemToSellInBid extends ObjectItemToSell implements INetworkType {

    private int protocolId = 164;
    private int unsoldDelay = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
         param1.writeShort(this.effects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.effects.length)
         {
            param1.writeShort((this.effects[_loc2_] as ObjectEffect).getTypeId());
            (this.effects[_loc2_] as ObjectEffect).serialize(param1);
            _loc2_++;
         }
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
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectPrice + ") on element objectPrice.");
         }
         param1.writeVarLong(this.objectPrice);
         if(this.unsoldDelay < 0)
         {
            throw new Exception("Forbidden value (" + this.unsoldDelay + ") on element unsoldDelay.");
         }
         param1.writeInt(this.unsoldDelay);
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
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of ObjectItemToSell.objectGID.");
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
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ObjectItemToSell.objectUID.");
         }
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ObjectItemToSell.quantity.");
         }
         this.objectPrice = param1.readVarUhLong();
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectPrice + ") on element of ObjectItemToSell.objectPrice.");
         }
         this.unsoldDelay = param1.readInt();
         if(this.unsoldDelay < 0)
         {
            throw new Exception("Forbidden value (" + this.unsoldDelay + ") on element of ObjectItemToSellInBid.unsoldDelay.");
         }
    }

}