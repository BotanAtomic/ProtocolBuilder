package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.QuestActiveDetailedInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FollowedQuestsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6717;
    private boolean _isInitialized = false;
    private Vector<QuestActiveDetailedInformations> quests;
    private FuncTree _queststree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6717;
    }

    public FollowedQuestsMessage initFollowedQuestsMessage(Vector<QuestActiveDetailedInformations> param1) {
         this.quests = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.quests = new Vector.<QuestActiveDetailedInformations>();
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
         this.serializeAs_FollowedQuestsMessage(param1);
    }

    public void serializeAs_FollowedQuestsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.quests.length);
         int _loc2_ = 0;
         while(_loc2_ < this.quests.length)
         {
            (this.quests[_loc2_] as QuestActiveDetailedInformations).serializeAs_QuestActiveDetailedInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FollowedQuestsMessage(param1);
    }

    public void deserializeAs_FollowedQuestsMessage(ICustomDataInput param1) {
         QuestActiveDetailedInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new QuestActiveDetailedInformations();
            _loc4_.deserialize(param1);
            this.quests.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FollowedQuestsMessage(param1);
    }

    public void deserializeAsyncAs_FollowedQuestsMessage(FuncTree param1) {
         this._queststree = param1.addChild(this._queststreeFunc);
    }

    private void _queststreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._queststree.addChild(this._questsFunc);
            _loc3_++;
         }
    }

    private void _questsFunc(ICustomDataInput param1) {
         QuestActiveDetailedInformations _loc2_ = new QuestActiveDetailedInformations();
         _loc2_.deserialize(param1);
         this.quests.push(_loc2_);
    }

}