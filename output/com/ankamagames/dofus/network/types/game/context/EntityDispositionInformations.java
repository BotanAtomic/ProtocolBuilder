package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class EntityDispositionInformations extends Object implements INetworkType {

    private int protocolId = 60;
    private int cellId = 0;
    private int direction = 1;


    public void serialize(ICustomDataOutput param1) {
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeShort(this.cellId);
         param1.writeByte(this.direction);
    }

    public void deserialize(ICustomDataInput param1) {
         this.cellId = param1.readShort();
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of EntityDispositionInformations.cellId.");
         }
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of EntityDispositionInformations.direction.");
         }
    }

}