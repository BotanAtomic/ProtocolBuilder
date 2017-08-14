package com.ankamagames.dofus.network.messages.game.context.roleplay.stats;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatsUpgradeResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int result = 0;
  public int nbCharacBoost = 0;
  public static final int protocolId = 5609;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.result);
    if (this.nbCharacBoost < 0) {
      throw new Error("Forbidden value (" + this.nbCharacBoost + ") on element nbCharacBoost.");
    }
    param1.writeVarShort(this.nbCharacBoost);
  }

  public void deserialize(ICustomDataInput param1) {
    this.result = param1.readByte();
    if (this.result < 0) {
      throw new Error(
          "Forbidden value (" + this.result + ") on element of GuildCreationResultMessage.result.");
    }

    this.nbCharacBoost = param1.readVarUhShort();
    if (this.nbCharacBoost < 0) {
      throw new Error(
          "Forbidden value ("
              + this.nbCharacBoost
              + ") on element of StatsUpgradeResultMessage.nbCharacBoost.");
    }
  }
}
