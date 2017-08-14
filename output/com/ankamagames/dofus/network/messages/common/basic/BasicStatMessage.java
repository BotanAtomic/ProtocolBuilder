package com.ankamagames.dofus.network.messages.common.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicStatMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number timeSpent = 0;
  public int statId = 0;
  public static final int protocolId = 6530;

  public void serialize(ICustomDataOutput param1) {
    if (this.timeSpent < 0 || this.timeSpent > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.timeSpent + ") on element timeSpent.");
    }
    param1.writeDouble(this.timeSpent);
    param1.writeVarShort(this.statId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.timeSpent = param1.readDouble();
    if (this.timeSpent < 0 || this.timeSpent > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.timeSpent + ") on element of BasicStatMessage.timeSpent.");
    }

    this.statId = param1.readByte();
    if (this.statId < 0) {
      throw new Exception(
          "Forbidden value (" + this.statId + ") on element of StatsUpgradeRequestMessage.statId.");
    }
  }
}
