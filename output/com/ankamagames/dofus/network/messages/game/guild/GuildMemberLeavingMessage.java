package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildMemberLeavingMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean kicked = false;
  public Number memberId = 0;
  public static final int protocolId = 5923;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.kicked);
    if (this.memberId < 0 || this.memberId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeVarLong(this.memberId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.kicked = param1.readBoolean();

    this.memberId = param1.readInt();
    if (this.memberId < 0) {
      throw new Exception(
          "Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }
  }
}
