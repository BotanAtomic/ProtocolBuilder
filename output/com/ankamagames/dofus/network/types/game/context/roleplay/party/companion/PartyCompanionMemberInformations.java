package com.ankamagames.dofus.network.types.game.context.roleplay.party.companion;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyCompanionMemberInformations extends PartyCompanionBaseInformations
    implements INetworkType {

  public int initiative = 0;
  public int lifePoints = 0;
  public int maxLifePoints = 0;
  public int prospecting = 0;
  public int regenRate = 0;
  public static final int protocolId = 452;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.indexId < 0) {
      throw new Error("Forbidden value (" + this.indexId + ") on element indexId.");
    }
    param1.writeByte(this.indexId);
    if (this.companionGenericId < 0) {
      throw new Error(
          "Forbidden value (" + this.companionGenericId + ") on element companionGenericId.");
    }
    param1.writeByte(this.companionGenericId);
    this.entityLook.serializeAs_EntityLook(param1);

    if (this.initiative < 0) {
      throw new Error("Forbidden value (" + this.initiative + ") on element initiative.");
    }
    param1.writeVarShort(this.initiative);
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

    this.initiative = param1.readVarUhShort();
    if (this.initiative < 0) {
      throw new Error(
          "Forbidden value ("
              + this.initiative
              + ") on element of PartyMemberInformations.initiative.");
    }

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
  }
}
