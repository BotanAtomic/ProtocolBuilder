package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.achievement.Achievement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementDetailedListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6358;
    private boolean _isInitialized = false;
    private Vector<Achievement> startedAchievements;
    private Vector<Achievement> finishedAchievements;
    private FuncTree _startedAchievementstree;
    private FuncTree _finishedAchievementstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6358;
    }

    public AchievementDetailedListMessage initAchievementDetailedListMessage(Vector<Achievement> param1,Vector<Achievement>  param2) {
         this.startedAchievements = param1;
         this.finishedAchievements = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.startedAchievements = new Vector.<Achievement>();
         this.finishedAchievements = new Vector.<Achievement>();
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
         this.serializeAs_AchievementDetailedListMessage(param1);
    }

    public void serializeAs_AchievementDetailedListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.startedAchievements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.startedAchievements.length)
         {
            (this.startedAchievements[_loc2_] as Achievement).serializeAs_Achievement(param1);
            _loc2_++;
         }
         param1.writeShort(this.finishedAchievements.length);
         int _loc3_ = 0;
         while(_loc3_ < this.finishedAchievements.length)
         {
            (this.finishedAchievements[_loc3_] as Achievement).serializeAs_Achievement(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementDetailedListMessage(param1);
    }

    public void deserializeAs_AchievementDetailedListMessage(ICustomDataInput param1) {
         Achievement _loc6_ = null;
         Achievement _loc7_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new Achievement();
            _loc6_.deserialize(param1);
            this.startedAchievements.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new Achievement();
            _loc7_.deserialize(param1);
            this.finishedAchievements.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementDetailedListMessage(param1);
    }

    public void deserializeAsyncAs_AchievementDetailedListMessage(FuncTree param1) {
         this._startedAchievementstree = param1.addChild(this._startedAchievementstreeFunc);
         this._finishedAchievementstree = param1.addChild(this._finishedAchievementstreeFunc);
    }

    private void _startedAchievementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._startedAchievementstree.addChild(this._startedAchievementsFunc);
            _loc3_++;
         }
    }

    private void _startedAchievementsFunc(ICustomDataInput param1) {
         Achievement _loc2_ = new Achievement();
         _loc2_.deserialize(param1);
         this.startedAchievements.push(_loc2_);
    }

    private void _finishedAchievementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._finishedAchievementstree.addChild(this._finishedAchievementsFunc);
            _loc3_++;
         }
    }

    private void _finishedAchievementsFunc(ICustomDataInput param1) {
         Achievement _loc2_ = new Achievement();
         _loc2_.deserialize(param1);
         this.finishedAchievements.push(_loc2_);
    }

}