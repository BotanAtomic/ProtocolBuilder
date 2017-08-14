package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyInvitationCancelledForGuestMessage extends AbstractPartyMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number cancelerId = 0;
  public static final int protocolId = 6256;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Error("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    if (this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.cancelerId + ") on element cancelerId.");
    }
    param1.writeVarLong(this.cancelerId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.cancelerId = param1.readVarUhLong();
    if (this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.cancelerId
              + ") on element of PartyInvitationCancelledForGuestMessage.cancelerId.");
    }
  }
}
