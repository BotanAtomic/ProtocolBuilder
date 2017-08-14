package com.ankamagames.dofus.network.types.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class Achievement extends Object implements INetworkType {

  public int id = 0;
  public Vector<AchievementObjective> finishedObjective;
  public Vector<AchievementStartedObjective> startedObjectives;
  private FuncTree _finishedObjectivetree;
  private FuncTree _startedObjectivestree;
  public static final int protocolId = 363;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    param1.writeShort(this.finishedObjective.length);
    int _loc2_ = 0;
    while (_loc2_ < this.finishedObjective.length) {
      ((AchievementObjective) this.finishedObjective[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.startedObjectives.length);
    int _loc3_ = 0;
    while (_loc3_ < this.startedObjectives.length) {
      ((AchievementStartedObjective) this.startedObjectives[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    AchievementObjective _loc6_ = null;
    AchievementStartedObjective _loc7_ = null;
    this.id = param1.readUTF();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = new AchievementObjective();
      _loc6_.deserialize(param1);
      this.finishedObjective.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = new AchievementStartedObjective();
      _loc7_.deserialize(param1);
      this.startedObjectives.push(_loc7_);
      _loc5_++;
    }
  }
}
