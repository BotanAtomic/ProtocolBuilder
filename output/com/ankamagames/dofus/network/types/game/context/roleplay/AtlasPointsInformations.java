package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.MapCoordinatesExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AtlasPointsInformations extends Object implements INetworkType {

    private int protocolId = 175;
    private int type = 0;
    private MapCoordinatesExtended[] coords;
    private FuncTree _coordstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         param1.writeShort(this.coords.length);
         int _loc2_ = 0;
         while(_loc2_ < this.coords.length)
         {
            (this.coords[_loc2_] as MapCoordinatesExtended).serializeAs_MapCoordinatesExtended(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         MapCoordinatesExtended _loc4_ = null;
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of AtlasPointsInformations.type.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MapCoordinatesExtended();
            _loc4_.deserialize(param1);
            this.coords.push(_loc4_);
            _loc3_++;
         }
    }

}