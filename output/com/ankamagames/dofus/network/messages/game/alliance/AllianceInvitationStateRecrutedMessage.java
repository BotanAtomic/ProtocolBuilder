package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceInvitationStateRecrutedMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int invitationState = 0;
  public static final int protocolId = 6392;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.invitationState);
  }

  public void deserialize(ICustomDataInput param1) {
    this.invitationState = param1.readByte();
    if (this.invitationState < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.invitationState
              + ") on element of GuildInvitationStateRecruterMessage.invitationState.");
    }
  }
}
