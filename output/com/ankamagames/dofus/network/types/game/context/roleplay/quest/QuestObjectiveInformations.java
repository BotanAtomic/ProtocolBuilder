package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class QuestObjectiveInformations extends Object implements INetworkType {

    private int protocolId = 385;
    private int objectiveId = 0;
    private boolean objectiveStatus = false;
    private String[] dialogParams;
    private FuncTree _dialogParamstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.objectiveId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectiveId + ") on element objectiveId.");
         }
         param1.writeVarShort(this.objectiveId);
         param1.writeBoolean(this.objectiveStatus);
         param1.writeShort(this.dialogParams.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dialogParams.length)
         {
            param1.writeUTF(this.dialogParams[_loc2_]);
            _loc2_++;
         }
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
    }

}