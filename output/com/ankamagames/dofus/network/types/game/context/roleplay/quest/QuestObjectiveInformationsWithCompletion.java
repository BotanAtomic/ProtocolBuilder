package package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformations implements INetworkType {

    private int protocolId = 386;
    private int curCompletion = 0;
    private int maxCompletion = 0;


    public int getTypeId() {
         return 386;
    }

    public QuestObjectiveInformationsWithCompletion initQuestObjectiveInformationsWithCompletion(int param1,boolean  param2,Vector.<String>  param3,int  param4,int  param5) {
         super.initQuestObjectiveInformations(param1,param2,param3);
         this.curCompletion = param4;
         this.maxCompletion = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.curCompletion = 0;
         this.maxCompletion = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_QuestObjectiveInformationsWithCompletion(param1);
    }

    public void serializeAs_QuestObjectiveInformationsWithCompletion(ICustomDataOutput param1) {
         super.serializeAs_QuestObjectiveInformations(param1);
         if(this.curCompletion < 0)
            throw new Exception("Forbidden value (" + this.curCompletion + ") on element curCompletion.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestObjectiveInformationsWithCompletion(param1);
    }

    public void deserializeAs_QuestObjectiveInformationsWithCompletion(ICustomDataInput param1) {
         super.deserialize(param1);
         this._curCompletionFunc(param1);
         this._maxCompletionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestObjectiveInformationsWithCompletion(param1);
    }

    public void deserializeAsyncAs_QuestObjectiveInformationsWithCompletion(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._curCompletionFunc);
         param1.addChild(this._maxCompletionFunc);
    }

    private void _curCompletionFunc(ICustomDataInput param1) {
         this.curCompletion = param1.readVarUhShort();
         if(this.curCompletion < 0)
            throw new Exception("Forbidden value (" + this.curCompletion + ") on element of QuestObjectiveInformationsWithCompletion.curCompletion.");
    }

    private void _maxCompletionFunc(ICustomDataInput param1) {
         this.maxCompletion = param1.readVarUhShort();
         if(this.maxCompletion < 0)
            throw new Exception("Forbidden value (" + this.maxCompletion + ") on element of QuestObjectiveInformationsWithCompletion.maxCompletion.");
    }

}