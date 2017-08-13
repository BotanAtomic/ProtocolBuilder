package package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapCoordinatesAndId extends MapCoordinates implements INetworkType {

    private int protocolId = 392;
    private int mapId = 0;


    public int getTypeId() {
         return 392;
    }

    public MapCoordinatesAndId initMapCoordinatesAndId(int param1,int  param2,int  param3) {
         super.initMapCoordinates(param1,param2);
         this.mapId = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.mapId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MapCoordinatesAndId(param1);
    }

    public void serializeAs_MapCoordinatesAndId(ICustomDataOutput param1) {
         super.serializeAs_MapCoordinates(param1);
         param1.writeInt(this.mapId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapCoordinatesAndId(param1);
    }

    public void deserializeAs_MapCoordinatesAndId(ICustomDataInput param1) {
         super.deserialize(param1);
         this._mapIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapCoordinatesAndId(param1);
    }

    public void deserializeAsyncAs_MapCoordinatesAndId(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._mapIdFunc);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

}