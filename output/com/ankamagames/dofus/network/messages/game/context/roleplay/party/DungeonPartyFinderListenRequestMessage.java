package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DungeonPartyFinderListenRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int dungeonId = 0;
  public static final int protocolId = 6246;

  public void serialize(ICustomDataOutput param1) {
    if (this.dungeonId < 0) {
      throw new Error("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }
    param1.writeVarShort(this.dungeonId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.dungeonId = param1.readVarUhShort();
    if (this.dungeonId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.dungeonId
              + ") on element of TeleportToBuddyOfferMessage.dungeonId.");
    }
  }
}
