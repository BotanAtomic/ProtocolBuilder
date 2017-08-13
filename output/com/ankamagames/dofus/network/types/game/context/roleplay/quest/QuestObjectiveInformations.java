package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class QuestObjectiveInformations extends Object implements INetworkType {

    private int protocolId = 385;
    private int objectiveId = 0;
    private boolean objectiveStatus = false;
    private Vector<String> dialogParams;
    private FuncTree _dialogParamstree;


    public int getTypeId() {
         return 385;
    }

    public QuestObjectiveInformations initQuestObjectiveInformations(int param1,boolean  param2,Vector<String>  param3) {
         this.objectiveId = param1;
         this.objectiveStatus = param2;
         this.dialogParams = param3;
         return this;
    }

    public void reset() {
         this.objectiveId = 0;
         this.objectiveStatus = false;
         this.dialogParams = new Vector.<String>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_QuestObjectiveInformations(param1);
    }

    public void serializeAs_QuestObjectiveInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_QuestObjectiveInformations(param1);
    }

    public void deserializeAs_QuestObjectiveInformations(ICustomDataInput param1) {
         String _loc4_ = null;
         this._objectiveIdFunc(param1);
         this._objectiveStatusFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUTF();
            this.dialogParams.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestObjectiveInformations(param1);
    }

    public void deserializeAsyncAs_QuestObjectiveInformations(FuncTree param1) {
         param1.addChild(this._objectiveIdFunc);
         param1.addChild(this._objectiveStatusFunc);
         this._dialogParamstree = param1.addChild(this._dialogParamstreeFunc);
    }

    private void _objectiveIdFunc(ICustomDataInput param1) {
         this.objectiveId = param1.readVarUhShort();
         if(this.objectiveId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectiveId + ") on element of QuestObjectiveInformations.objectiveId.");
         }
    }

    private void _objectiveStatusFunc(ICustomDataInput param1) {
         this.objectiveStatus = param1.readBoolean();
    }

    private void _dialogParamstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._dialogParamstree.addChild(this._dialogParamsFunc);
            _loc3_++;
         }
    }

    private void _dialogParamsFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.dialogParams.push(_loc2_);
    }

}