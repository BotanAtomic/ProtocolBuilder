package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyKickedByMessage extends AbstractPartyMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number kickerId = 0;
  public static final int protocolId = 5590;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    if (this.kickerId < 0 || this.kickerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.kickerId + ") on element kickerId.");
    }
    param1.writeVarLong(this.kickerId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.kickerId = param1.readVarUhLong();
    if (this.kickerId < 0 || this.kickerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.kickerId
              + ") on element of PartyMemberEjectedMessage.kickerId.");
    }
  }
}
