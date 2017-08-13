package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntStepFollowDirectionToHint extends TreasureHuntStep implements INetworkType {

    private int protocolId = 472;
    private int direction = 1;
    private int npcId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.direction);
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
         }
         param1.writeVarShort(this.npcId);
         param1.writeByte(this.direction);
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
         }
         param1.writeVarShort(this.npcId);
         super.serializeAs_TreasureHuntStep(param1);
         param1.writeByte(this.direction);
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
         }
         param1.writeVarShort(this.npcId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of TreasureHuntStepFollowDirectionToHint.direction.");
         }
         this.npcId = param1.readVarUhShort();
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element of TreasureHuntStepFollowDirectionToHint.npcId.");
         }
    }

}