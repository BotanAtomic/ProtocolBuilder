package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceChangeGuildRightsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int guildId = 0;
  public int rights = 0;
  public static final int protocolId = 6426;

  public void serialize(ICustomDataOutput param1) {
    if (this.guildId < 0) {
      throw new Error("Forbidden value (" + this.guildId + ") on element guildId.");
    }
    param1.writeVarInt(this.guildId);
    if (this.rights < 0) {
      throw new Error("Forbidden value (" + this.rights + ") on element rights.");
    }
    param1.writeByte(this.rights);
  }

  public void deserialize(ICustomDataInput param1) {
    this.guildId = param1.readVarUhInt();
    if (this.guildId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.guildId
              + ") on element of GuildVersatileInformations.guildId.");
    }

    this.rights = param1.readVarUhInt();
    if (this.rights < 0) {
      throw new Error("Forbidden value (" + this.rights + ") on element of GuildMember.rights.");
    }
  }
}
