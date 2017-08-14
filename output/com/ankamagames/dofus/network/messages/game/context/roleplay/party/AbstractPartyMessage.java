package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AbstractPartyMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int partyId = 0;
  public static final int protocolId = 6274;

  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Error("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.partyId = param1.readVarUhInt();
    if (this.partyId < 0) {
      throw new Error(
          "Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
    }
  }
}
