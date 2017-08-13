package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MapObstacle extends Object implements INetworkType {

    private int protocolId = 200;
    private int obstacleCellId = 0;
    private int state = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.obstacleCellId < 0 || this.obstacleCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.obstacleCellId + ") on element obstacleCellId.");
         }
         param1.writeVarShort(this.obstacleCellId);
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.obstacleCellId = param1.readVarUhShort();
         if(this.obstacleCellId < 0 || this.obstacleCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.obstacleCellId + ") on element of MapObstacle.obstacleCellId.");
         }
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of MapObstacle.state.");
         }
    }

}