package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildMemberOnlineStatusMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number memberId = 0;
  public boolean online = false;
  public static final int protocolId = 6061;

  public void serialize(ICustomDataOutput param1) {
    if (this.memberId < 0 || this.memberId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeVarLong(this.memberId);
    param1.writeBoolean(this.online);
  }

  public void deserialize(ICustomDataInput param1) {
    this.memberId = param1.readInt();
    if (this.memberId < 0) {
      throw new Error(
          "Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }

    this.online = param1.readBoolean();
  }
}
