package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TeleportHavenBagRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number guestId = 0;
  public static final int protocolId = 6647;

  public void serialize(ICustomDataOutput param1) {
    if (this.guestId < 0 || this.guestId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.guestId + ") on element guestId.");
    }
    param1.writeVarLong(this.guestId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.guestId = param1.readVarUhLong();
    if (this.guestId < 0 || this.guestId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.guestId + ") on element of PartyGuestInformations.guestId.");
    }
  }
}
