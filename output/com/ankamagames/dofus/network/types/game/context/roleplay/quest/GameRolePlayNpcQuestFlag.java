package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayNpcQuestFlag extends Object implements INetworkType {

  public Vector<uint> questsToValidId;
  public Vector<uint> questsToStartId;
  private FuncTree _questsToValidIdtree;
  private FuncTree _questsToStartIdtree;
  public static final int protocolId = 384;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.questsToValidId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.questsToValidId.length) {
      if (this.questsToValidId[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.questsToValidId[_loc2_]
                + ") on element 1 (starting at 1) of questsToValidId.");
      }
      param1.writeVarShort(this.questsToValidId[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.questsToStartId.length);
    int _loc3_ = 0;
    while (_loc3_ < this.questsToStartId.length) {
      if (this.questsToStartId[_loc3_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.questsToStartId[_loc3_]
                + ") on element 2 (starting at 1) of questsToStartId.");
      }
      param1.writeVarShort(this.questsToStartId[_loc3_]);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    int _loc7_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhShort();
      if (_loc6_ < 0) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of questsToValidId.");
      }
      this.questsToValidId.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readVarUhShort();
      if (_loc7_ < 0) {
        throw new Error("Forbidden value (" + _loc7_ + ") on elements of questsToStartId.");
      }
      this.questsToStartId.push(_loc7_);
      _loc5_++;
    }
  }
}
