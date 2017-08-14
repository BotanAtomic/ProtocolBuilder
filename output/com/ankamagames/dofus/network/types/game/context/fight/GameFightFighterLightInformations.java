package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightFighterLightInformations extends Object implements INetworkType {

  public Number id = 0;
  public int wave = 0;
  public int level = 0;
  public int breed = 0;
  public boolean sex = false;
  public boolean alive = false;
  public static final int protocolId = 413;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.sex);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.alive);
    param1.writeByte(_loc2_);
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    if (this.wave < 0) {
      throw new Error("Forbidden value (" + this.wave + ") on element wave.");
    }
    param1.writeByte(this.wave);
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeVarShort(this.level);
    param1.writeByte(this.breed);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.id = param1.readUTF();

    this.wave = param1.readByte();
    if (this.wave < 0) {
      throw new Error(
          "Forbidden value ("
              + this.wave
              + ") on element of GameFightFighterLightInformations.wave.");
    }

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.breed = param1.readByte();
  }
}
