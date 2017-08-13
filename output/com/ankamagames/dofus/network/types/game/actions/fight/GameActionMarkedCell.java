package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionMarkedCell extends Object implements INetworkType {

    private int protocolId = 85;
    private int cellId = 0;
    private int zoneSize = 0;
    private int cellColor = 0;
    private int cellsType = 0;


    public int getTypeId() {
         return 85;
    }

    public GameActionMarkedCell initGameActionMarkedCell(int param1,int  param2,int  param3,int  param4) {
         this.cellId = param1;
         this.zoneSize = param2;
         this.cellColor = param3;
         this.cellsType = param4;
         return this;
    }

    public void reset() {
         this.cellId = 0;
         this.zoneSize = 0;
         this.cellColor = 0;
         this.cellsType = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameActionMarkedCell(param1);
    }

    public void serializeAs_GameActionMarkedCell(ICustomDataOutput param1) {
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
         param1.writeByte(this.zoneSize);
         param1.writeInt(this.cellColor);
         param1.writeByte(this.cellsType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionMarkedCell(param1);
    }

    public void deserializeAs_GameActionMarkedCell(ICustomDataInput param1) {
         this._cellIdFunc(param1);
         this._zoneSizeFunc(param1);
         this._cellColorFunc(param1);
         this._cellsTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionMarkedCell(param1);
    }

    public void deserializeAsyncAs_GameActionMarkedCell(FuncTree param1) {
         param1.addChild(this._cellIdFunc);
         param1.addChild(this._zoneSizeFunc);
         param1.addChild(this._cellColorFunc);
         param1.addChild(this._cellsTypeFunc);
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of GameActionMarkedCell.cellId.");
         }
    }

    private void _zoneSizeFunc(ICustomDataInput param1) {
         this.zoneSize = param1.readByte();
    }

    private void _cellColorFunc(ICustomDataInput param1) {
         this.cellColor = param1.readInt();
    }

    private void _cellsTypeFunc(ICustomDataInput param1) {
         this.cellsType = param1.readByte();
    }

}