package com.ankamagames.dofus.network.types.game.idol;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class Idol extends Object implements INetworkType {

    private int protocolId = 489;
    private int id = 0;
    private int xpBonusPercent = 0;
    private int dropBonusPercent = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarShort(this.id);
         if(this.xpBonusPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBonusPercent + ") on element xpBonusPercent.");
         }
         param1.writeVarShort(this.xpBonusPercent);
         if(this.dropBonusPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBonusPercent + ") on element dropBonusPercent.");
         }
         param1.writeVarShort(this.dropBonusPercent);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of Idol.id.");
         }
         this.xpBonusPercent = param1.readVarUhShort();
         if(this.xpBonusPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBonusPercent + ") on element of Idol.xpBonusPercent.");
         }
         this.dropBonusPercent = param1.readVarUhShort();
         if(this.dropBonusPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBonusPercent + ") on element of Idol.dropBonusPercent.");
         }
    }

}