package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class QuestStartRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5643;
    private boolean _isInitialized = false;
    private int questId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5643;
    }

    public QuestStartRequestMessage initQuestStartRequestMessage(int param1) {
         this.questId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.questId = 0;
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
         this.serializeAs_QuestStartRequestMessage(param1);
    }

    public void serializeAs_QuestStartRequestMessage(ICustomDataOutput param1) {
         if(this.questId < 0)
         {
            throw new Exception("Forbidden value (" + this.questId + ") on element questId.");
         }
         param1.writeVarShort(this.questId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestStartRequestMessage(param1);
    }

    public void deserializeAs_QuestStartRequestMessage(ICustomDataInput param1) {
         this._questIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestStartRequestMessage(param1);
    }

    public void deserializeAsyncAs_QuestStartRequestMessage(FuncTree param1) {
         param1.addChild(this._questIdFunc);
    }

    private void _questIdFunc(ICustomDataInput param1) {
         this.questId = param1.readVarUhShort();
         if(this.questId < 0)
         {
            throw new Exception("Forbidden value (" + this.questId + ") on element of QuestStartRequestMessage.questId.");
         }
    }

}