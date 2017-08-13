package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HouseOnMapInformations extends HouseInformations implements INetworkType {

    private int protocolId = 510;
    private Vector<uint> doorsOnMap;
    private Vector<HouseInstanceInformations> houseInstances;
    private FuncTree _doorsOnMaptree;
    private FuncTree _houseInstancestree;


    public int getTypeId() {
         return 510;
    }

    public HouseOnMapInformations initHouseOnMapInformations(int param1,int  param2,Vector<uint>  param3,Vector<HouseInstanceInformations>  param4) {
         super.initHouseInformations(param1,param2);
         this.doorsOnMap = param3;
         this.houseInstances = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.doorsOnMap = new Vector.<uint>();
         this.houseInstances = new Vector.<HouseInstanceInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseOnMapInformations(param1);
    }

    public void serializeAs_HouseOnMapInformations(ICustomDataOutput param1) {
         super.serializeAs_HouseInformations(param1);
         param1.writeShort(this.doorsOnMap.length);
         int _loc2_ = 0;
         while(_loc2_ < this.doorsOnMap.length)
         {
            if(this.doorsOnMap[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.doorsOnMap[_loc2_] + ") on element 1 (starting at 1) of doorsOnMap.");
            }
            param1.writeInt(this.doorsOnMap[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.houseInstances.length);
         int _loc3_ = 0;
         while(_loc3_ < this.houseInstances.length)
         {
            (this.houseInstances[_loc3_] as HouseInstanceInformations).serializeAs_HouseInstanceInformations(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseOnMapInformations(param1);
    }

    public void deserializeAs_HouseOnMapInformations(ICustomDataInput param1) {
         int _loc6_ = 0;
         HouseInstanceInformations _loc7_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readInt();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of doorsOnMap.");
            }
            this.doorsOnMap.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new HouseInstanceInformations();
            _loc7_.deserialize(param1);
            this.houseInstances.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseOnMapInformations(param1);
    }

    public void deserializeAsyncAs_HouseOnMapInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._doorsOnMaptree = param1.addChild(this._doorsOnMaptreeFunc);
         this._houseInstancestree = param1.addChild(this._houseInstancestreeFunc);
    }

    private void _doorsOnMaptreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._doorsOnMaptree.addChild(this._doorsOnMapFunc);
            _loc3_++;
         }
    }

    private void _doorsOnMapFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of doorsOnMap.");
         }
         this.doorsOnMap.push(_loc2_);
    }

    private void _houseInstancestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._houseInstancestree.addChild(this._houseInstancesFunc);
            _loc3_++;
         }
    }

    private void _houseInstancesFunc(ICustomDataInput param1) {
         HouseInstanceInformations _loc2_ = new HouseInstanceInformations();
         _loc2_.deserialize(param1);
         this.houseInstances.push(_loc2_);
    }

}