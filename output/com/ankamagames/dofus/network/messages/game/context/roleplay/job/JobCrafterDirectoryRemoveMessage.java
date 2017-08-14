package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryRemoveMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int jobId = 0;
  public Number playerId = 0;
  public static final int protocolId = 5653;

  public void serialize(ICustomDataOutput param1) {
    if (this.jobId < 0) {
      throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }
    param1.writeByte(this.jobId);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.jobId = param1.readByte();
    if (this.jobId < 0) {
      throw new Exception(
          "Forbidden value (" + this.jobId + ") on element of JobExperience.jobId.");
    }

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }
  }
}
