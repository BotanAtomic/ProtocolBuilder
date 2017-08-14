package com.ankamagames.dofus.network.messages.game.context.roleplay.stats;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatsUpgradeRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean useAdditionnal = false;
  public int statId = 11;
  public int boostPoint = 0;
  public static final int protocolId = 5610;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.useAdditionnal);
    param1.writeByte(this.statId);
    if (this.boostPoint < 0) {
      throw new Exception("Forbidden value (" + this.boostPoint + ") on element boostPoint.");
    }
    param1.writeVarShort(this.boostPoint);
  }

  public void deserialize(ICustomDataInput param1) {
    this.useAdditionnal = param1.readBoolean();

    this.statId = param1.readByte();
    if (this.statId < 0) {
      throw new Exception(
          "Forbidden value (" + this.statId + ") on element of StatsUpgradeRequestMessage.statId.");
    }

    this.boostPoint = param1.readVarUhShort();
    if (this.boostPoint < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.boostPoint
              + ") on element of StatsUpgradeRequestMessage.boostPoint.");
    }
  }
}
