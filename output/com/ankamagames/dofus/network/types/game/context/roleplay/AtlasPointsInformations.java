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
    private Vector<MapCoordinatesExtended> coords;
    private FuncTree _coordstree;


    public int getTypeId() {
         return 175;
    }

    public AtlasPointsInformations initAtlasPointsInformations(int param1,Vector<MapCoordinatesExtended>  param2) {
         this.type = param1;
         this.coords = param2;
         return this;
    }

    public void reset() {
         this.type = 0;
         this.coords = new Vector.<MapCoordinatesExtended>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AtlasPointsInformations(param1);
    }

    public void serializeAs_AtlasPointsInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_AtlasPointsInformations(param1);
    }

    public void deserializeAs_AtlasPointsInformations(ICustomDataInput param1) {
         MapCoordinatesExtended _loc4_ = null;
         this._typeFunc(param1);
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

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AtlasPointsInformations(param1);
    }

    public void deserializeAsyncAs_AtlasPointsInformations(FuncTree param1) {
         param1.addChild(this._typeFunc);
         this._coordstree = param1.addChild(this._coordstreeFunc);
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of AtlasPointsInformations.type.");
         }
    }

    private void _coordstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._coordstree.addChild(this._coordsFunc);
            _loc3_++;
         }
    }

    private void _coordsFunc(ICustomDataInput param1) {
         MapCoordinatesExtended _loc2_ = new MapCoordinatesExtended();
         _loc2_.deserialize(param1);
         this.coords.push(_loc2_);
    }

}