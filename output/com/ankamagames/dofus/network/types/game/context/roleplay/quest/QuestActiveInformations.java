package package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class QuestActiveInformations extends Object implements INetworkType {

    private int protocolId = 381;
    private int questId = 0;


    public int getTypeId() {
         return 381;
    }

    public QuestActiveInformations initQuestActiveInformations(int param1) {
         this.questId = param1;
         return this;
    }

    public void reset() {
         this.questId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_QuestActiveInformations(param1);
    }

    public void serializeAs_QuestActiveInformations(ICustomDataOutput param1) {
         if(this.questId < 0)
            throw new Exception("Forbidden value (" + this.questId + ") on element questId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestActiveInformations(param1);
    }

    public void deserializeAs_QuestActiveInformations(ICustomDataInput param1) {
         this._questIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestActiveInformations(param1);
    }

    public void deserializeAsyncAs_QuestActiveInformations(FuncTree param1) {
         param1.addChild(this._questIdFunc);
    }

    private void _questIdFunc(ICustomDataInput param1) {
         this.questId = param1.readVarUhShort();
         if(this.questId < 0)
            throw new Exception("Forbidden value (" + this.questId + ") on element of QuestActiveInformations.questId.");
    }

}