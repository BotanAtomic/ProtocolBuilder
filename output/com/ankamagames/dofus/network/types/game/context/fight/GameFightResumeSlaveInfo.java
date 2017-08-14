package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightResumeSlaveInfo extends Object implements INetworkType {

  public Number slaveId = 0;
  public Vector<GameFightSpellCooldown> spellCooldowns;
  public int summonCount = 0;
  public int bombCount = 0;
  private FuncTree _spellCooldownstree;
  public static final int protocolId = 364;

  public void serialize(ICustomDataOutput param1) {
    if (this.slaveId < -9.007199254740992E15 || this.slaveId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.slaveId + ") on element slaveId.");
    }
    param1.writeDouble(this.slaveId);
    param1.writeShort(this.spellCooldowns.length);
    int _loc2_ = 0;
    while (_loc2_ < this.spellCooldowns.length) {
      ((GameFightSpellCooldown) this.spellCooldowns[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    if (this.summonCount < 0) {
      throw new Error("Forbidden value (" + this.summonCount + ") on element summonCount.");
    }
    param1.writeByte(this.summonCount);
    if (this.bombCount < 0) {
      throw new Error("Forbidden value (" + this.bombCount + ") on element bombCount.");
    }
    param1.writeByte(this.bombCount);
  }

  public void deserialize(ICustomDataInput param1) {
    GameFightSpellCooldown _loc4_ = null;
    this.slaveId = param1.readDouble();
    if (this.slaveId < -9.007199254740992E15 || this.slaveId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.slaveId + ") on element of GameFightResumeSlaveInfo.slaveId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new GameFightSpellCooldown();
      _loc4_.deserialize(param1);
      this.spellCooldowns.push(_loc4_);
      _loc3_++;
    }
    this.summonCount = param1.readByte();
    if (this.summonCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.summonCount
              + ") on element of GameFightResumeSlaveInfo.summonCount.");
    }

    this.bombCount = param1.readByte();
    if (this.bombCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.bombCount
              + ") on element of GameFightResumeSlaveInfo.bombCount.");
    }
  }
}
