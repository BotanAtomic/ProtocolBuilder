package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyMemberInformations extends CharacterBaseInformations implements INetworkType {

  public int lifePoints = 0;
  public int maxLifePoints = 0;
  public int prospecting = 0;
  public int regenRate = 0;
  public int initiative = 0;
  public int alignmentSide = 0;
  public int worldX = 0;
  public int worldY = 0;
  public int mapId = 0;
  public int subAreaId = 0;
  public PlayerStatus status;
  public Vector<PartyCompanionMemberInformations> companions;
  private FuncTree _statustree;
  private FuncTree _companionstree;
  public static final int protocolId = 90;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeUTF(this.name);

    if (this.level < 1 || this.level > 206) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);

    this.entityLook.serializeAs_EntityLook(param1);

    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);

    if (this.lifePoints < 0) {
      throw new Error("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }
    param1.writeVarInt(this.lifePoints);
    if (this.maxLifePoints < 0) {
      throw new Error("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
    }
    param1.writeVarInt(this.maxLifePoints);
    if (this.prospecting < 0) {
      throw new Error("Forbidden value (" + this.prospecting + ") on element prospecting.");
    }
    param1.writeVarShort(this.prospecting);
    if (this.regenRate < 0 || this.regenRate > 255) {
      throw new Error("Forbidden value (" + this.regenRate + ") on element regenRate.");
    }
    param1.writeByte(this.regenRate);
    if (this.initiative < 0) {
      throw new Error("Forbidden value (" + this.initiative + ") on element initiative.");
    }
    param1.writeVarShort(this.initiative);
    param1.writeByte(this.alignmentSide);
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Error("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Error("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
    param1.writeInt(this.mapId);
    if (this.subAreaId < 0) {
      throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
    param1.writeShort(this.status.getTypeId());
    this.status.serialize(param1);
    param1.writeShort(this.companions.length);
    int _loc2_ = 0;
    while (_loc2_ < this.companions.length) {
      ((PartyCompanionMemberInformations) this.companions[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    PartyCompanionMemberInformations _loc5_ = null;
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

    this.lifePoints = param1.readVarUhInt();
    if (this.lifePoints < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lifePoints
              + ") on element of PartyMemberInformations.lifePoints.");
    }

    this.maxLifePoints = param1.readVarUhInt();
    if (this.maxLifePoints < 0) {
      throw new Error(
          "Forbidden value ("
              + this.maxLifePoints
              + ") on element of PartyMemberInformations.maxLifePoints.");
    }

    this.prospecting = param1.readVarUhShort();
    if (this.prospecting < 0) {
      throw new Error(
          "Forbidden value ("
              + this.prospecting
              + ") on element of PartyMemberInformations.prospecting.");
    }

    this.regenRate = param1.readUnsignedByte();
    if (this.regenRate < 0 || this.regenRate > 255) {
      throw new Error(
          "Forbidden value ("
              + this.regenRate
              + ") on element of PartyMemberInformations.regenRate.");
    }

    this.initiative = param1.readVarUhShort();
    if (this.initiative < 0) {
      throw new Error(
          "Forbidden value ("
              + this.initiative
              + ") on element of PartyMemberInformations.initiative.");
    }

    this.alignmentSide = param1.readByte();

    this.worldX = param1.readShort();
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Error(
          "Forbidden value ("
              + this.worldX
              + ") on element of PrismGeolocalizedInformation.worldX.");
    }

    this.worldY = param1.readShort();
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Error(
          "Forbidden value ("
              + this.worldY
              + ") on element of PrismGeolocalizedInformation.worldY.");
    }

    this.mapId = param1.readInt();

    this.subAreaId = param1.readVarUhShort();
    if (this.subAreaId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.subAreaId
              + ") on element of PrismSubareaEmptyInfo.subAreaId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    this.status = ProtocolTypeManager.getInstance(PlayerStatus, _loc2_);
    this.status.deserialize(param1);
    int _loc3_ = param1.readUnsignedShort();
    int _loc4_ = 0;
    while (_loc4_ < _loc3_) {
      _loc5_ = new PartyCompanionMemberInformations();
      _loc5_.deserialize(param1);
      this.companions.push(_loc5_);
      _loc4_++;
    }
  }
}
