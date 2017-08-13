package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class ExchangeBidHouseInListAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5949;
    private boolean _isInitialized = false;
    private int itemUID = 0;
    private int objGenericId = 0;
    private ObjectEffect[] effects;
    private Number[] prices;
    private FuncTree _effectstree;
    private FuncTree _pricestree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.itemUID);
         param1.writeInt(this.objGenericId);
         param1.writeShort(this.effects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.effects.length)
         {
            param1.writeShort((this.effects[_loc2_] as ObjectEffect).getTypeId());
            (this.effects[_loc2_] as ObjectEffect).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.prices.length);
         int _loc3_ = 0;
         while(_loc3_ < this.prices.length)
         {
            if(this.prices[_loc3_] < 0 || this.prices[_loc3_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.prices[_loc3_] + ") on element 4 (starting at 1) of prices.");
            }
            param1.writeVarLong(this.prices[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         ObjectEffect _loc7_ = null;
         Object _loc8_ = NaN;
         this.itemUID = param1.readInt();
         this.objGenericId = param1.readInt();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc6_);
            _loc7_.deserialize(param1);
            this.effects.push(_loc7_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc8_ = param1.readVarUhLong();
            if(_loc8_ < 0 || _loc8_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc8_ + ") on elements of prices.");
            }
            this.prices.push(_loc8_);
            _loc5_++;
         }
    }

}