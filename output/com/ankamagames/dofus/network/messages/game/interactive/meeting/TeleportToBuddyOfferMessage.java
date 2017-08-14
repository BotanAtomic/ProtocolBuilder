package com.ankamagames.dofus.network.messages.game.interactive.meeting;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TeleportToBuddyOfferMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int dungeonId = 0;
  public Number buddyId = 0;
  public int timeLeft = 0;
  public static final int protocolId = 6287;

  public void serialize(ICustomDataOutput param1) {
    if (this.dungeonId < 0) {
      throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }
    param1.writeVarShort(this.dungeonId);
    if (this.buddyId < 0 || this.buddyId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.buddyId + ") on element buddyId.");
    }
    param1.writeVarLong(this.buddyId);
    if (this.timeLeft < 0) {
      throw new Exception("Forbidden value (" + this.timeLeft + ") on element timeLeft.");
    }
    param1.writeVarInt(this.timeLeft);
  }

  public void deserialize(ICustomDataInput param1) {
    this.dungeonId = param1.readVarUhShort();
    if (this.dungeonId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.dungeonId
              + ") on element of TeleportToBuddyOfferMessage.dungeonId.");
    }

    this.buddyId = param1.readVarUhLong();
    if (this.buddyId < 0 || this.buddyId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.buddyId
              + ") on element of TeleportToBuddyOfferMessage.buddyId.");
    }

    this.timeLeft = param1.readVarUhInt();
    if (this.timeLeft < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.timeLeft
              + ") on element of TeleportToBuddyOfferMessage.timeLeft.");
    }
  }
}
