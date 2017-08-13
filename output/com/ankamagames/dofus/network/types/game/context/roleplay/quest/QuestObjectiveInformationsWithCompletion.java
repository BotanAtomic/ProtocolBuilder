package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformations implements INetworkType {

    private int protocolId = 386;
    private int curCompletion = 0;
    private int maxCompletion = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.curCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.curCompletion + ") on element curCompletion.");
         }
         param1.writeVarShort(this.curCompletion);
         if(this.maxCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.maxCompletion + ") on element maxCompletion.");
         }
         param1.writeVarShort(this.maxCompletion);
         if(this.curCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.curCompletion + ") on element curCompletion.");
         }
         param1.writeVarShort(this.curCompletion);
         if(this.maxCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.maxCompletion + ") on element maxCompletion.");
         }
         param1.writeVarShort(this.maxCompletion);
         super.serializeAs_QuestObjectiveInformations(param1);
         if(this.curCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.curCompletion + ") on element curCompletion.");
         }
         param1.writeVarShort(this.curCompletion);
         if(this.maxCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.maxCompletion + ") on element maxCompletion.");
         }
         param1.writeVarShort(this.maxCompletion);
    }

    public void deserialize(ICustomDataInput param1) {
         String _loc4_ = null;
         this.objectiveId = param1.readVarUhShort();
         if(this.objectiveId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectiveId + ") on element of QuestObjectiveInformations.objectiveId.");
         }
         this.objectiveStatus = param1.readBoolean();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUTF();
            this.dialogParams.push(_loc4_);
            _loc3_++;
         }
         this.curCompletion = param1.readVarUhShort();
         if(this.curCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.curCompletion + ") on element of QuestObjectiveInformationsWithCompletion.curCompletion.");
         }
         this.maxCompletion = param1.readVarUhShort();
         if(this.maxCompletion < 0)
         {
            throw new Exception("Forbidden value (" + this.maxCompletion + ") on element of QuestObjectiveInformationsWithCompletion.maxCompletion.");
         }
    }

}