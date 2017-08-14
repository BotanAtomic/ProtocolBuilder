package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobExperience extends Object implements INetworkType {

  public int jobId = 0;
  public int jobLevel = 0;
  public Number jobXP = 0;
  public Number jobXpLevelFloor = 0;
  public Number jobXpNextLevelFloor = 0;
  public static final int protocolId = 98;

  public void serialize(ICustomDataOutput param1) {
    if (this.jobId < 0) {
      throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }
    param1.writeByte(this.jobId);
    if (this.jobLevel < 0 || this.jobLevel > 255) {
      throw new Exception("Forbidden value (" + this.jobLevel + ") on element jobLevel.");
    }
    param1.writeByte(this.jobLevel);
    if (this.jobXP < 0 || this.jobXP > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.jobXP + ") on element jobXP.");
    }
    param1.writeVarLong(this.jobXP);
    if (this.jobXpLevelFloor < 0 || this.jobXpLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.jobXpLevelFloor + ") on element jobXpLevelFloor.");
    }
    param1.writeVarLong(this.jobXpLevelFloor);
    if (this.jobXpNextLevelFloor < 0 || this.jobXpNextLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.jobXpNextLevelFloor + ") on element jobXpNextLevelFloor.");
    }
    param1.writeVarLong(this.jobXpNextLevelFloor);
  }

  public void deserialize(ICustomDataInput param1) {
    this.jobId = param1.readByte();
    if (this.jobId < 0) {
      throw new Exception(
          "Forbidden value (" + this.jobId + ") on element of JobExperience.jobId.");
    }

    this.jobLevel = param1.readUnsignedByte();
    if (this.jobLevel < 0 || this.jobLevel > 255) {
      throw new Exception(
          "Forbidden value (" + this.jobLevel + ") on element of JobExperience.jobLevel.");
    }

    this.jobXP = param1.readVarUhLong();
    if (this.jobXP < 0 || this.jobXP > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.jobXP + ") on element of JobExperience.jobXP.");
    }

    this.jobXpLevelFloor = param1.readVarUhLong();
    if (this.jobXpLevelFloor < 0 || this.jobXpLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.jobXpLevelFloor
              + ") on element of JobExperience.jobXpLevelFloor.");
    }

    this.jobXpNextLevelFloor = param1.readVarUhLong();
    if (this.jobXpNextLevelFloor < 0 || this.jobXpNextLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.jobXpNextLevelFloor
              + ") on element of JobExperience.jobXpNextLevelFloor.");
    }
  }
}
