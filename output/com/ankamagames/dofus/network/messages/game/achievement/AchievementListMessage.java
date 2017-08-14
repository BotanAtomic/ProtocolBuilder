package com.ankamagames.dofus.network.messages.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.achievement.AchievementRewardable;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> finishedAchievementsIds;
  public Vector<AchievementRewardable> rewardableAchievements;
  private FuncTree _finishedAchievementsIdstree;
  private FuncTree _rewardableAchievementstree;
  public static final int protocolId = 6205;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.finishedAchievementsIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.finishedAchievementsIds.length) {
      if (this.finishedAchievementsIds[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.finishedAchievementsIds[_loc2_]
                + ") on element 1 (starting at 1) of finishedAchievementsIds.");
      }
      param1.writeVarShort(this.finishedAchievementsIds[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.rewardableAchievements.length);
    int _loc3_ = 0;
    while (_loc3_ < this.rewardableAchievements.length) {
      ((AchievementRewardable) this.rewardableAchievements[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    AchievementRewardable _loc7_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhShort();
      if (_loc6_ < 0) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of finishedAchievementsIds.");
      }
      this.finishedAchievementsIds.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = new AchievementRewardable();
      _loc7_.deserialize(param1);
      this.rewardableAchievements.push(_loc7_);
      _loc5_++;
    }
  }
}
