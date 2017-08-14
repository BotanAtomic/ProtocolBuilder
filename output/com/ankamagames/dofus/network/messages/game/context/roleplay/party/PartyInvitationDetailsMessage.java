package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyInvitationMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyInvitationDetailsMessage extends AbstractPartyMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int partyType = 0;
  public String partyName = "";
  public Number fromId = 0;
  public String fromName = "";
  public Number leaderId = 0;
  public Vector<PartyInvitationMemberInformations> members;
  public Vector<PartyGuestInformations> guests;
  private FuncTree _memberstree;
  private FuncTree _gueststree;
  public static final int protocolId = 6263;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Error("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    param1.writeByte(this.partyType);
    param1.writeUTF(this.partyName);
    if (this.fromId < 0 || this.fromId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.fromId + ") on element fromId.");
    }
    param1.writeVarLong(this.fromId);
    param1.writeUTF(this.fromName);
    if (this.leaderId < 0 || this.leaderId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.leaderId + ") on element leaderId.");
    }
    param1.writeVarLong(this.leaderId);
    param1.writeShort(this.members.length);
    int _loc2_ = 0;
    while (_loc2_ < this.members.length) {
      ((PartyInvitationMemberInformations) this.members[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.guests.length);
    int _loc3_ = 0;
    while (_loc3_ < this.guests.length) {
      ((PartyGuestInformations) this.guests[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    PartyInvitationMemberInformations _loc6_ = null;
    PartyGuestInformations _loc7_ = null;
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

    this.fromId = param1.readVarUhLong();
    if (this.fromId < 0 || this.fromId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.fromId + ") on element of PartyInvitationMessage.fromId.");
    }

    this.fromName = param1.readUTF();

    this.leaderId = param1.readVarUhLong();
    if (this.leaderId < 0 || this.leaderId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.leaderId
              + ") on element of GuildVersatileInformations.leaderId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = new PartyInvitationMemberInformations();
      _loc6_.deserialize(param1);
      this.members.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = new PartyGuestInformations();
      _loc7_.deserialize(param1);
      this.guests.push(_loc7_);
      _loc5_++;
    }
  }
}
