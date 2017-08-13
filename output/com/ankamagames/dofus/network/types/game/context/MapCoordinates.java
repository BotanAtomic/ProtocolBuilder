package package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class MapCoordinates extends Object implements INetworkType {

    private int protocolId = 174;
    private int worldX = 0;
    private int worldY = 0;


    public int getTypeId() {
         return 174;
    }

    public MapCoordinates initMapCoordinates(int param1,int  param2) {
         this.worldX = param1;
         this.worldY = param2;
         return this;
    }

    public void reset() {
         this.worldX = 0;
         this.worldY = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MapCoordinates(param1);
    }

    public void serializeAs_MapCoordinates(ICustomDataOutput param1) {
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MapCoordinates(param1);
    }

    public void deserializeAs_MapCoordinates(ICustomDataInput param1) {
         this._worldXFunc(param1);
         this._worldYFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MapCoordinates(param1);
    }

    public void deserializeAsyncAs_MapCoordinates(FuncTree param1) {
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of MapCoordinates.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of MapCoordinates.worldY.");
    }

}