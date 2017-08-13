package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class QuestActiveDetailedInformations extends QuestActiveInformations implements INetworkType {

    private int protocolId = 382;
    private int stepId = 0;
    private QuestObjectiveInformations[] objectives;
    private FuncTree _objectivestree;


    public void serialize(ICustomDataOutput param1) {
         if(this.questId < 0)
         {
            throw new Exception("Forbidden value (" + this.questId + ") on element questId.");
         }
         param1.writeVarShort(this.questId);
         if(this.stepId < 0)
         {
            throw new Exception("Forbidden value (" + this.stepId + ") on element stepId.");
         }
         param1.writeVarShort(this.stepId);
         param1.writeShort(this.objectives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectives.length)
         {
            param1.writeShort((this.objectives[_loc2_] as QuestObjectiveInformations).getTypeId());
            (this.objectives[_loc2_] as QuestObjectiveInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         QuestObjectiveInformations _loc5_ = null;
         this.deserializeAs_QuestActiveInformations(param1);
         this.stepId = param1.readVarUhShort();
         if(this.stepId < 0)
         {
            throw new Exception("Forbidden value (" + this.stepId + ") on element of QuestActiveDetailedInformations.stepId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(QuestObjectiveInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.objectives.push(_loc5_);
            _loc3_++;
         }
    }

}