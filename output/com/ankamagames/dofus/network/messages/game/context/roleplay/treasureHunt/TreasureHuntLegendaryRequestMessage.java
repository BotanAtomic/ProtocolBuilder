package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntLegendaryRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int legendaryId = 0;
  public static final int protocolId = 6499;

  public void serialize(ICustomDataOutput param1) {
    if (this.legendaryId < 0) {
      throw new Error("Forbidden value (" + this.legendaryId + ") on element legendaryId.");
    }
    param1.writeVarShort(this.legendaryId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.legendaryId = param1.readVarUhShort();
    if (this.legendaryId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.legendaryId
              + ") on element of TreasureHuntLegendaryRequestMessage.legendaryId.");
    }
  }
}
