package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MapCoordinatesExtended extends MapCoordinatesAndId implements INetworkType {

    private int protocolId = 176;
    private int subAreaId = 0;


    public int getTypeId() {
         return 176;
    }

    public MapCoordinatesExtended initMapCoordinatesExtended(int param1,int  param2,int  param3,int  param4) {
         super.initMapCoordinatesAndId(param1,param2,param3);
         this.subAreaId = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.subAreaId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MapCoordinatesExtended(param1);
    }

    public void serializeAs_MapCoordinatesExtended(ICustomDataOutput param1) {
         super.serializeAs_MapCoordinatesAndId(param1);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapCoordinatesExtended(param1);
    }

    public void deserializeAs_MapCoordinatesExtended(ICustomDataInput param1) {
         super.deserialize(param1);
         this._subAreaIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapCoordinatesExtended(param1);
    }

    public void deserializeAsyncAs_MapCoordinatesExtended(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._subAreaIdFunc);
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of MapCoordinatesExtended.subAreaId.");
         }
    }

}