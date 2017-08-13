package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInstanceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class HousePropertiesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5734;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int[] doorsOnMap;
    private HouseInstanceInformations properties;
    private FuncTree _doorsOnMaptree;
    private FuncTree _propertiestree;


    public void serialize(ICustomDataOutput param1) {
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         param1.writeShort(this.doorsOnMap.length);
         int _loc2_ = 0;
         while(_loc2_ < this.doorsOnMap.length)
         {
            if(this.doorsOnMap[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.doorsOnMap[_loc2_] + ") on element 2 (starting at 1) of doorsOnMap.");
            }
            param1.writeInt(this.doorsOnMap[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.properties.getTypeId());
         this.properties.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc5_ = 0;
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HousePropertiesMessage.houseId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc5_ = param1.readInt();
            if(_loc5_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc5_ + ") on elements of doorsOnMap.");
            }
            this.doorsOnMap.push(_loc5_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         this.properties = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc4_);
         this.properties.deserialize(param1);
    }

}