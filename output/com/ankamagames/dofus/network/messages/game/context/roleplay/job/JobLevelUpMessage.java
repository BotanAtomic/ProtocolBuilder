package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobDescription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobLevelUpMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int newLevel = 0;
  public JobDescription jobsDescription;
  private FuncTree _jobsDescriptiontree;
  public static final int protocolId = 5656;

  public void serialize(ICustomDataOutput param1) {
    if (this.newLevel < 0 || this.newLevel > 255) {
      throw new Exception("Forbidden value (" + this.newLevel + ") on element newLevel.");
    }
    param1.writeByte(this.newLevel);
    this.jobsDescription.serializeAs_JobDescription(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.newLevel = param1.readUnsignedByte();
    if (this.newLevel < 2 || this.newLevel > 200) {
      throw new Exception(
          "Forbidden value (" + this.newLevel + ") on element of GuildLevelUpMessage.newLevel.");
    }

    this.jobsDescription = new JobDescription();
    this.jobsDescription.deserialize(param1);
  }
}
