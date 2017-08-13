package package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.achievement.AchievementRewardable;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AchievementListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6205;
    private boolean _isInitialized = false;
    private Vector.<uint> finishedAchievementsIds = ;
    private Vector.<AchievementRewardable> rewardableAchievements = ;
    private FuncTree _finishedAchievementsIdstree = ;
    private FuncTree _rewardableAchievementstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private AchievementRewardable _loc7_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6205;
    }

    public AchievementListMessage initAchievementListMessage(Vector.<uint> param1,Vector.<AchievementRewardable>  param2) {
         this.finishedAchievementsIds = param1;
         this.rewardableAchievements = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.finishedAchievementsIds = new Vector.<uint>();
         this.rewardableAchievements = new Vector.<AchievementRewardable>();
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
         this.serializeAs_AchievementListMessage(param1);
    }

    public void serializeAs_AchievementListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.finishedAchievementsIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.finishedAchievementsIds.length)
            if(this.finishedAchievementsIds[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.finishedAchievementsIds[_loc2_] + ") on element 1 (starting at 1) of finishedAchievementsIds.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementListMessage(param1);
    }

    public void deserializeAs_AchievementListMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         AchievementRewardable _loc7_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of finishedAchievementsIds.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementListMessage(param1);
    }

    public void deserializeAsyncAs_AchievementListMessage(FuncTree param1) {
         this._finishedAchievementsIdstree = param1.addChild(this._finishedAchievementsIdstreeFunc);
         this._rewardableAchievementstree = param1.addChild(this._rewardableAchievementstreeFunc);
    }

    private void _finishedAchievementsIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._finishedAchievementsIdstree.addChild(this._finishedAchievementsIdsFunc);
            _loc3_++;
    }

    private void _finishedAchievementsIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of finishedAchievementsIds.");
    }

    private void _rewardableAchievementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._rewardableAchievementstree.addChild(this._rewardableAchievementsFunc);
            _loc3_++;
    }

    private void _rewardableAchievementsFunc(ICustomDataInput param1) {
         AchievementRewardable _loc2_ = new AchievementRewardable();
         _loc2_.deserialize(param1);
         this.rewardableAchievements.push(_loc2_);
    }

}