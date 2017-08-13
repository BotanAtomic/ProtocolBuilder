package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeTypesExchangerDescriptionForUserMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5765;
    private boolean _isInitialized = false;
    private int[] typeDescription;
    private FuncTree _typeDescriptiontree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.typeDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.typeDescription.length)
         {
            if(this.typeDescription[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.typeDescription[_loc2_] + ") on element 1 (starting at 1) of typeDescription.");
            }
            param1.writeVarInt(this.typeDescription[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhInt();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of typeDescription.");
            }
            this.typeDescription.push(_loc4_);
            _loc3_++;
         }
    }

}