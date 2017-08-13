package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseInListUpdatedMessage extends ExchangeBidHouseInListAddedMessage implements INetworkMessage {

    private int protocolId = 6337;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeBidHouseInListAddedMessage(param1);
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