package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartOkNpcTradeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number npcId = 0;
  public static final int protocolId = 5785;

  public void serialize(ICustomDataOutput param1) {
    if (this.npcId < -9.007199254740992E15 || this.npcId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
    }
    param1.writeDouble(this.npcId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.npcId = param1.readVarUhShort();
    if (this.npcId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.npcId
              + ") on element of TreasureHuntStepFollowDirectionToHint.npcId.");
    }
  }
}
