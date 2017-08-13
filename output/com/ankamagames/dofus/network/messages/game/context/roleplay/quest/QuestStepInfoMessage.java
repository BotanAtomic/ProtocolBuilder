package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.QuestActiveInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class QuestStepInfoMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5625;
    private boolean _isInitialized = false;
    private QuestActiveInformations infos;
    private FuncTree _infostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5625;
    }

    public QuestStepInfoMessage initQuestStepInfoMessage(QuestActiveInformations param1) {
         this.infos = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.infos = new QuestActiveInformations();
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
         this.serializeAs_QuestStepInfoMessage(param1);
    }

    public void serializeAs_QuestStepInfoMessage(ICustomDataOutput param1) {
         param1.writeShort(this.infos.getTypeId());
         this.infos.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestStepInfoMessage(param1);
    }

    public void deserializeAs_QuestStepInfoMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.infos = ProtocolTypeManager.getInstance(QuestActiveInformations,_loc2_);
         this.infos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestStepInfoMessage(param1);
    }

    public void deserializeAsyncAs_QuestStepInfoMessage(FuncTree param1) {
         this._infostree = param1.addChild(this._infostreeFunc);
    }

    private void _infostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.infos = ProtocolTypeManager.getInstance(QuestActiveInformations,_loc2_);
         this.infos.deserializeAsync(this._infostree);
    }

}