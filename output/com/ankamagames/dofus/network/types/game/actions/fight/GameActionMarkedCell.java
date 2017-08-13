package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionMarkedCell extends Object implements INetworkType {

    private int protocolId = 85;
    private int cellId = 0;
    private int zoneSize = 0;
    private int cellColor = 0;
    private int cellsType = 0;


    public void serialize(ICustomDataOutput param1) {
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
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of GameActionMarkedCell.cellId.");
         }
         this.zoneSize = param1.readByte();
         this.cellColor = param1.readInt();
         this.cellsType = param1.readByte();
    }

}