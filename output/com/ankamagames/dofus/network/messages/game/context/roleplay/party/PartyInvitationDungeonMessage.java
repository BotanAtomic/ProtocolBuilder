package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyInvitationDungeonMessage extends PartyInvitationMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int dungeonId = 0;
  public static final int protocolId = 6244;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    param1.writeByte(this.partyType);
    param1.writeUTF(this.partyName);
    if (this.maxParticipants < 0) {
      throw new Exception(
          "Forbidden value (" + this.maxParticipants + ") on element maxParticipants.");
    }
    param1.writeByte(this.maxParticipants);
    if (this.fromId < 0 || this.fromId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.fromId + ") on element fromId.");
    }
    param1.writeVarLong(this.fromId);
    param1.writeUTF(this.fromName);
    if (this.toId < 0 || this.toId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.toId + ") on element toId.");
    }
    param1.writeVarLong(this.toId);

    if (this.dungeonId < 0) {
      throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }
    param1.writeVarShort(this.dungeonId);
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

    this.dungeonId = param1.readVarUhShort();
    if (this.dungeonId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.dungeonId
              + ") on element of TeleportToBuddyOfferMessage.dungeonId.");
    }
  }
}
