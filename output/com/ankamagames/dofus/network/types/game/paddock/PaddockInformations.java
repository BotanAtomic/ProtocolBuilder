package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PaddockInformations extends Object implements INetworkType {

    private int protocolId = 132;
    private int maxOutdoorMount = 0;
    private int maxItems = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.maxOutdoorMount < 0)
         {
            throw new Exception("Forbidden value (" + this.maxOutdoorMount + ") on element maxOutdoorMount.");
         }
         param1.writeVarShort(this.maxOutdoorMount);
         if(this.maxItems < 0)
         {
            throw new Exception("Forbidden value (" + this.maxItems + ") on element maxItems.");
         }
         param1.writeVarShort(this.maxItems);
    }

    public void deserialize(ICustomDataInput param1) {
         this.maxOutdoorMount = param1.readVarUhShort();
         if(this.maxOutdoorMount < 0)
         {
            throw new Exception("Forbidden value (" + this.maxOutdoorMount + ") on element of PaddockInformations.maxOutdoorMount.");
         }
         this.maxItems = param1.readVarUhShort();
         if(this.maxItems < 0)
         {
            throw new Exception("Forbidden value (" + this.maxItems + ") on element of PaddockInformations.maxItems.");
         }
    }

}