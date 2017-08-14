package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceGuildLeavingMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean kicked = false;
  public int guildId = 0;
  public static final int protocolId = 6399;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.kicked);
    if (this.guildId < 0) {
      throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
    }
    param1.writeVarInt(this.guildId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.kicked = param1.readBoolean();

    this.guildId = param1.readVarUhInt();
    if (this.guildId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.guildId
              + ") on element of GuildVersatileInformations.guildId.");
    }
  }
}
