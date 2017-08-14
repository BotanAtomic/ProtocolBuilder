package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyInvitationMessage extends AbstractPartyMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int partyType = 0;
  public String partyName = "";
  public int maxParticipants = 0;
  public Number fromId = 0;
  public String fromName = "";
  public Number toId = 0;
  public static final int protocolId = 5586;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Error("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    param1.writeByte(this.partyType);
    param1.writeUTF(this.partyName);
    if (this.maxParticipants < 0) {
      throw new Error("Forbidden value (" + this.maxParticipants + ") on element maxParticipants.");
    }
    param1.writeByte(this.maxParticipants);
    if (this.fromId < 0 || this.fromId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.fromId + ") on element fromId.");
    }
    param1.writeVarLong(this.fromId);
    param1.writeUTF(this.fromName);
    if (this.toId < 0 || this.toId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.toId + ") on element toId.");
    }
    param1.writeVarLong(this.toId);
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

    this.partyType = param1.readByte();
    if (this.partyType < 0) {
      throw new Error(
          "Forbidden value (" + this.partyType + ") on element of PartyJoinMessage.partyType.");
    }

    this.partyName = param1.readUTF();

    this.maxParticipants = param1.readByte();
    if (this.maxParticipants < 0) {
      throw new Error(
          "Forbidden value ("
              + this.maxParticipants
              + ") on element of PartyJoinMessage.maxParticipants.");
    }

    this.fromId = param1.readVarUhLong();
    if (this.fromId < 0 || this.fromId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.fromId + ") on element of PartyInvitationMessage.fromId.");
    }

    this.fromName = param1.readUTF();

    this.toId = param1.readVarUhLong();
    if (this.toId < 0 || this.toId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.toId + ") on element of PartyInvitationMessage.toId.");
    }
  }
}
