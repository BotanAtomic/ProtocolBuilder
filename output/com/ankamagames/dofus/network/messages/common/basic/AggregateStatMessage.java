package com.ankamagames.dofus.network.messages.common.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AggregateStatMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int statId = 0;
  public static final int protocolId = 6669;

  public void serialize(ICustomDataOutput param1) {
    param1.writeVarShort(this.statId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.statId = param1.readByte();
    if (this.statId < 0) {
      throw new Exception(
          "Forbidden value (" + this.statId + ") on element of StatsUpgradeRequestMessage.statId.");
    }
  }
}
