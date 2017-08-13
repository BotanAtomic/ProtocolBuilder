package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntStepFollowDirectionToPOI extends TreasureHuntStep implements INetworkType {

    private int protocolId = 461;
    private int direction = 1;
    private int poiLabelId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.direction);
         if(this.poiLabelId < 0)
         {
            throw new Exception("Forbidden value (" + this.poiLabelId + ") on element poiLabelId.");
         }
         param1.writeVarShort(this.poiLabelId);
         param1.writeByte(this.direction);
         if(this.poiLabelId < 0)
         {
            throw new Exception("Forbidden value (" + this.poiLabelId + ") on element poiLabelId.");
         }
         param1.writeVarShort(this.poiLabelId);
         super.serializeAs_TreasureHuntStep(param1);
         param1.writeByte(this.direction);
         if(this.poiLabelId < 0)
         {
            throw new Exception("Forbidden value (" + this.poiLabelId + ") on element poiLabelId.");
         }
         param1.writeVarShort(this.poiLabelId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of TreasureHuntStepFollowDirectionToPOI.direction.");
         }
         this.poiLabelId = param1.readVarUhShort();
         if(this.poiLabelId < 0)
         {
            throw new Exception("Forbidden value (" + this.poiLabelId + ") on element of TreasureHuntStepFollowDirectionToPOI.poiLabelId.");
         }
    }

}