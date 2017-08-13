package package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class QuestStepValidatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6099;
    private boolean _isInitialized = false;
    private int questId = 0;
    private int stepId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6099;
    }

    public QuestStepValidatedMessage initQuestStepValidatedMessage(int param1,int  param2) {
         this.questId = param1;
         this.stepId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.questId = 0;
         this.stepId = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_QuestStepValidatedMessage(param1);
    }

    public void serializeAs_QuestStepValidatedMessage(ICustomDataOutput param1) {
         if(this.questId < 0)
            throw new Exception("Forbidden value (" + this.questId + ") on element questId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestStepValidatedMessage(param1);
    }

    public void deserializeAs_QuestStepValidatedMessage(ICustomDataInput param1) {
         this._questIdFunc(param1);
         this._stepIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestStepValidatedMessage(param1);
    }

    public void deserializeAsyncAs_QuestStepValidatedMessage(FuncTree param1) {
         param1.addChild(this._questIdFunc);
         param1.addChild(this._stepIdFunc);
    }

    private void _questIdFunc(ICustomDataInput param1) {
         this.questId = param1.readVarUhShort();
         if(this.questId < 0)
            throw new Exception("Forbidden value (" + this.questId + ") on element of QuestStepValidatedMessage.questId.");
    }

    private void _stepIdFunc(ICustomDataInput param1) {
         this.stepId = param1.readVarUhShort();
         if(this.stepId < 0)
            throw new Exception("Forbidden value (" + this.stepId + ") on element of QuestStepValidatedMessage.stepId.");
    }

}