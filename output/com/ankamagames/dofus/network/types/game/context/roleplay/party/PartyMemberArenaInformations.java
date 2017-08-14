package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyMemberArenaInformations extends PartyMemberInformations implements INetworkType {

  public int rank = 0;
  public static final int protocolId = 391;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeUTF(this.name);

    if (this.level < 1 || this.level > 206) {
      throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);

    this.entityLook.serializeAs_EntityLook(param1);

    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);

    if (this.lifePoints < 0) {
      throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }
    param1.writeVarInt(this.lifePoints);
    if (this.maxLifePoints < 0) {
      throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
    }
    param1.writeVarInt(this.maxLifePoints);
    if (this.prospecting < 0) {
      throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
    }
    param1.writeVarShort(this.prospecting);
    if (this.regenRate < 0 || this.regenRate > 255) {
      throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
    }
    param1.writeByte(this.regenRate);
    if (this.initiative < 0) {
      throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
    }
    param1.writeVarShort(this.initiative);
    param1.writeByte(this.alignmentSide);
    if (this.worldX < -255 || this.worldX > 255) {
      throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }
    param1.writeShort(this.worldX);
    if (this.worldY < -255 || this.worldY > 255) {
      throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
    }
    param1.writeShort(this.worldY);
    param1.writeInt(this.mapId);
    if (this.subAreaId < 0) {
      throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
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

    if (this.rank < 0 || this.rank > 20000) {
      throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
    }
    param1.writeVarShort(this.rank);
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

    this.rank = param1.readVarUhShort();
    if (this.rank < 0) {
      throw new Exception("Forbidden value (" + this.rank + ") on element of GuildMember.rank.");
    }
  }
}
