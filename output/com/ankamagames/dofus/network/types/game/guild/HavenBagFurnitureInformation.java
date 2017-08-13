package package com.ankamagames.dofus.network.types.game.guild;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HavenBagFurnitureInformation extends Object implements INetworkType {

    private int protocolId = 498;
    private int cellId = 0;
    private int funitureId = 0;
    private int orientation = 0;


    public int getTypeId() {
         return 498;
    }

    public HavenBagFurnitureInformation initHavenBagFurnitureInformation(int param1,int  param2,int  param3) {
         this.cellId = param1;
         this.funitureId = param2;
         this.orientation = param3;
         return this;
    }

    public void reset() {
         this.cellId = 0;
         this.funitureId = 0;
         this.orientation = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HavenBagFurnitureInformation(param1);
    }

    public void serializeAs_HavenBagFurnitureInformation(ICustomDataOutput param1) {
         if(this.cellId < 0)
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HavenBagFurnitureInformation(param1);
    }

    public void deserializeAs_HavenBagFurnitureInformation(ICustomDataInput param1) {
         this._cellIdFunc(param1);
         this._funitureIdFunc(param1);
         this._orientationFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HavenBagFurnitureInformation(param1);
    }

    public void deserializeAsyncAs_HavenBagFurnitureInformation(FuncTree param1) {
         param1.addChild(this._cellIdFunc);
         param1.addChild(this._funitureIdFunc);
         param1.addChild(this._orientationFunc);
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0)
            throw new Exception("Forbidden value (" + this.cellId + ") on element of HavenBagFurnitureInformation.cellId.");
    }

    private void _funitureIdFunc(ICustomDataInput param1) {
         this.funitureId = param1.readInt();
    }

    private void _orientationFunc(ICustomDataInput param1) {
         this.orientation = param1.readByte();
         if(this.orientation < 0)
            throw new Exception("Forbidden value (" + this.orientation + ") on element of HavenBagFurnitureInformation.orientation.");
    }

}