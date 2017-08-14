package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryEntryJobInfo extends Object implements INetworkType {

  public int jobId = 0;
  public int jobLevel = 0;
  public boolean free = false;
  public int minLevel = 0;
  public static final int protocolId = 195;

  public void serialize(ICustomDataOutput param1) {
    if (this.jobId < 0) {
      throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }
    param1.writeByte(this.jobId);
    if (this.jobLevel < 1 || this.jobLevel > 200) {
      throw new Exception("Forbidden value (" + this.jobLevel + ") on element jobLevel.");
    }
    param1.writeByte(this.jobLevel);
    param1.writeBoolean(this.free);
    if (this.minLevel < 0 || this.minLevel > 255) {
      throw new Exception("Forbidden value (" + this.minLevel + ") on element minLevel.");
    }
    param1.writeByte(this.minLevel);
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

    this.free = param1.readBoolean();

    this.minLevel = param1.readUnsignedByte();
    if (this.minLevel < 0 || this.minLevel > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.minLevel
              + ") on element of JobCrafterDirectorySettings.minLevel.");
    }
  }
}
