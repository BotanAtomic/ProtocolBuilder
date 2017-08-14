package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class PartyJoinMessage extends AbstractPartyMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int partyType = 0;
  public Number partyLeaderId = 0;
  public int maxParticipants = 0;
  public Vector<PartyMemberInformations> members;
  public Vector<PartyGuestInformations> guests;
  public boolean restricted = false;
  public String partyName = "";
  private FuncTree _memberstree;
  private FuncTree _gueststree;
  public static final int protocolId = 5576;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    param1.writeByte(this.partyType);
    if (this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element partyLeaderId.");
    }
    param1.writeVarLong(this.partyLeaderId);
    if (this.maxParticipants < 0) {
      throw new Exception(
          "Forbidden value (" + this.maxParticipants + ") on element maxParticipants.");
    }
    param1.writeByte(this.maxParticipants);
    param1.writeShort(this.members.length);
    int _loc2_ = 0;
    while (_loc2_ < this.members.length) {
      param1.writeShort(((PartyMemberInformations) (this.members[_loc2_])).getTypeId());
      ((PartyMemberInformations) this.members[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.guests.length);
    int _loc3_ = 0;
    while (_loc3_ < this.guests.length) {
      ((PartyGuestInformations) this.guests[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
    param1.writeBoolean(this.restricted);
    param1.writeUTF(this.partyName);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    PartyMemberInformations _loc7_ = null;
    PartyGuestInformations _loc8_ = null;
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

    this.partyType = param1.readByte();
    if (this.partyType < 0) {
      throw new Exception(
          "Forbidden value (" + this.partyType + ") on element of PartyJoinMessage.partyType.");
    }

    this.partyLeaderId = param1.readVarUhLong();
    if (this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.partyLeaderId
              + ") on element of PartyLeaderUpdateMessage.partyLeaderId.");
    }

    this.maxParticipants = param1.readByte();
    if (this.maxParticipants < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.maxParticipants
              + ") on element of PartyJoinMessage.maxParticipants.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readUnsignedShort();
      _loc7_ = ProtocolTypeManager.getInstance(PartyMemberInformations, _loc6_);
      _loc7_.deserialize(param1);
      this.members.push(_loc7_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc8_ = new PartyGuestInformations();
      _loc8_.deserialize(param1);
      this.guests.push(_loc8_);
      _loc5_++;
    }
    this.restricted = param1.readBoolean();

    this.partyName = param1.readUTF();
  }
}
