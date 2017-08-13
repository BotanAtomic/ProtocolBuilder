package package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.achievement.Achievement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementDetailsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6378;
    private boolean _isInitialized = false;
    private Achievement achievement = ;
    private FuncTree _achievementtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6378;
    }

    public AchievementDetailsMessage initAchievementDetailsMessage(Achievement param1) {
         this.achievement = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.achievement = new Achievement();
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
         this.serializeAs_AchievementDetailsMessage(param1);
    }

    public void serializeAs_AchievementDetailsMessage(ICustomDataOutput param1) {
         this.achievement.serializeAs_Achievement(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementDetailsMessage(param1);
    }

    public void deserializeAs_AchievementDetailsMessage(ICustomDataInput param1) {
         this.achievement = new Achievement();
         this.achievement.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementDetailsMessage(param1);
    }

    public void deserializeAsyncAs_AchievementDetailsMessage(FuncTree param1) {
         this._achievementtree = param1.addChild(this._achievementtreeFunc);
    }

    private void _achievementtreeFunc(ICustomDataInput param1) {
         this.achievement = new Achievement();
         this.achievement.deserializeAsync(this._achievementtree);
    }

}