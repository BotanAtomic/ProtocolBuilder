package package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.QuestActiveInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class QuestListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5626;
    private boolean _isInitialized = false;
    private Vector.<uint> finishedQuestsIds = ;
    private Vector.<uint> finishedQuestsCounts = ;
    private Vector.<QuestActiveInformations> activeQuests = ;
    private Vector.<uint> reinitDoneQuestsIds = ;
    private FuncTree _finishedQuestsIdstree = ;
    private FuncTree _finishedQuestsCountstree = ;
    private FuncTree _activeQueststree = ;
    private FuncTree _reinitDoneQuestsIdstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private int _loc5_ = 0;
    private int _loc11_ = 0;
    private int _loc12_ = 0;
    private QuestActiveInformations _loc13_ = null;
    private int _loc14_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc6_ = param1.readUnsignedShort();
    private int _loc7_ = 0;
    private int _loc8_ = param1.readUnsignedShort();
    private int _loc9_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private QuestActiveInformations _loc3_ = ProtocolTypeManager.getInstance(QuestActiveInformations,_loc2_);
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5626;
    }

    public QuestListMessage initQuestListMessage(Vector.<uint> param1,Vector.<uint>  param2,Vector.<QuestActiveInformations>  param3,Vector.<uint>  param4) {
         this.finishedQuestsIds = param1;
         this.finishedQuestsCounts = param2;
         this.activeQuests = param3;
         this.reinitDoneQuestsIds = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.finishedQuestsIds = new Vector.<uint>();
         this.finishedQuestsCounts = new Vector.<uint>();
         this.activeQuests = new Vector.<QuestActiveInformations>();
         this.reinitDoneQuestsIds = new Vector.<uint>();
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
         this.serializeAs_QuestListMessage(param1);
    }

    public void serializeAs_QuestListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.finishedQuestsIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.finishedQuestsIds.length)
            if(this.finishedQuestsIds[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.finishedQuestsIds[_loc2_] + ") on element 1 (starting at 1) of finishedQuestsIds.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestListMessage(param1);
    }

    public void deserializeAs_QuestListMessage(ICustomDataInput param1) {
         int _loc10_ = 0;
         int _loc11_ = 0;
         int _loc12_ = 0;
         QuestActiveInformations _loc13_ = null;
         int _loc14_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc10_ = param1.readVarUhShort();
            if(_loc10_ < 0)
               throw new Exception("Forbidden value (" + _loc10_ + ") on elements of finishedQuestsIds.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestListMessage(param1);
    }

    public void deserializeAsyncAs_QuestListMessage(FuncTree param1) {
         this._finishedQuestsIdstree = param1.addChild(this._finishedQuestsIdstreeFunc);
         this._finishedQuestsCountstree = param1.addChild(this._finishedQuestsCountstreeFunc);
         this._activeQueststree = param1.addChild(this._activeQueststreeFunc);
         this._reinitDoneQuestsIdstree = param1.addChild(this._reinitDoneQuestsIdstreeFunc);
    }

    private void _finishedQuestsIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._finishedQuestsIdstree.addChild(this._finishedQuestsIdsFunc);
            _loc3_++;
    }

    private void _finishedQuestsIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of finishedQuestsIds.");
    }

    private void _finishedQuestsCountstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._finishedQuestsCountstree.addChild(this._finishedQuestsCountsFunc);
            _loc3_++;
    }

    private void _finishedQuestsCountsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of finishedQuestsCounts.");
    }

    private void _activeQueststreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._activeQueststree.addChild(this._activeQuestsFunc);
            _loc3_++;
    }

    private void _activeQuestsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         QuestActiveInformations _loc3_ = ProtocolTypeManager.getInstance(QuestActiveInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.activeQuests.push(_loc3_);
    }

    private void _reinitDoneQuestsIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._reinitDoneQuestsIdstree.addChild(this._reinitDoneQuestsIdsFunc);
            _loc3_++;
    }

    private void _reinitDoneQuestsIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of reinitDoneQuestsIds.");
    }

}