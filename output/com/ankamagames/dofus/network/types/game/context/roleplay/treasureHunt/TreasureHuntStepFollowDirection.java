package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntStepFollowDirection extends TreasureHuntStep implements INetworkType {

    private int protocolId = 468;
    private int direction = 1;
    private int mapCount = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.direction);
         if(this.mapCount < 0)
         {
            throw new Exception("Forbidden value (" + this.mapCount + ") on element mapCount.");
         }
         param1.writeVarShort(this.mapCount);
         param1.writeByte(this.direction);
         if(this.mapCount < 0)
         {
            throw new Exception("Forbidden value (" + this.mapCount + ") on element mapCount.");
         }
         param1.writeVarShort(this.mapCount);
         super.serializeAs_TreasureHuntStep(param1);
         param1.writeByte(this.direction);
         if(this.mapCount < 0)
         {
            throw new Exception("Forbidden value (" + this.mapCount + ") on element mapCount.");
         }
         param1.writeVarShort(this.mapCount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of TreasureHuntStepFollowDirection.direction.");
         }
         this.mapCount = param1.readVarUhShort();
         if(this.mapCount < 0)
         {
            throw new Exception("Forbidden value (" + this.mapCount + ") on element of TreasureHuntStepFollowDirection.mapCount.");
         }
    }

}