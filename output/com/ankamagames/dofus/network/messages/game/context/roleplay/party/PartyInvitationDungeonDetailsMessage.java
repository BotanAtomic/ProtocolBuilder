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

public class PartyInvitationDungeonDetailsMessage extends PartyInvitationDetailsMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int dungeonId = 0;
  public Vector<Boolean> playersDungeonReady;
  private FuncTree _playersDungeonReadytree;
  public static final int protocolId = 6262;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.partyId < 0) {
      throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
    }
    param1.writeVarInt(this.partyId);

    param1.writeByte(this.partyType);
    param1.writeUTF(this.partyName);
    if (this.fromId < 0 || this.fromId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.fromId + ") on element fromId.");
    }
    param1.writeVarLong(this.fromId);
    param1.writeUTF(this.fromName);
    if (this.leaderId < 0 || this.leaderId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
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

    if (this.dungeonId < 0) {
      throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }
    param1.writeVarShort(this.dungeonId);
    param1.writeShort(this.playersDungeonReady.length);
    int _loc2_ = 0;
    while (_loc2_ < this.playersDungeonReady.length) {
      param1.writeBoolean(this.playersDungeonReady[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = false;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readBoolean();
      this.playersDungeonReady.push(_loc4_);
      _loc3_++;
    }
  }
}
