package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightMinimalStatsPreparation extends GameFightMinimalStats
    implements INetworkType {

  public int initiative = 0;
  public static final int protocolId = 360;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.lifePoints < 0) {
      throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }
    param1.writeVarInt(this.lifePoints);
    if (this.maxLifePoints < 0) {
      throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
    }
    param1.writeVarInt(this.maxLifePoints);
    if (this.baseMaxLifePoints < 0) {
      throw new Exception(
          "Forbidden value (" + this.baseMaxLifePoints + ") on element baseMaxLifePoints.");
    }
    param1.writeVarInt(this.baseMaxLifePoints);
    if (this.permanentDamagePercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.permanentDamagePercent
              + ") on element permanentDamagePercent.");
    }
    param1.writeVarInt(this.permanentDamagePercent);
    if (this.shieldPoints < 0) {
      throw new Exception("Forbidden value (" + this.shieldPoints + ") on element shieldPoints.");
    }
    param1.writeVarInt(this.shieldPoints);
    param1.writeVarShort(this.actionPoints);
    param1.writeVarShort(this.maxActionPoints);
    param1.writeVarShort(this.movementPoints);
    param1.writeVarShort(this.maxMovementPoints);
    if (this.summoner < -9.007199254740992E15 || this.summoner > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.summoner + ") on element summoner.");
    }
    param1.writeDouble(this.summoner);
    param1.writeBoolean(this.summoned);
    param1.writeVarShort(this.neutralElementResistPercent);
    param1.writeVarShort(this.earthElementResistPercent);
    param1.writeVarShort(this.waterElementResistPercent);
    param1.writeVarShort(this.airElementResistPercent);
    param1.writeVarShort(this.fireElementResistPercent);
    param1.writeVarShort(this.neutralElementReduction);
    param1.writeVarShort(this.earthElementReduction);
    param1.writeVarShort(this.waterElementReduction);
    param1.writeVarShort(this.airElementReduction);
    param1.writeVarShort(this.fireElementReduction);
    param1.writeVarShort(this.criticalDamageFixedResist);
    param1.writeVarShort(this.pushDamageFixedResist);
    param1.writeVarShort(this.pvpNeutralElementResistPercent);
    param1.writeVarShort(this.pvpEarthElementResistPercent);
    param1.writeVarShort(this.pvpWaterElementResistPercent);
    param1.writeVarShort(this.pvpAirElementResistPercent);
    param1.writeVarShort(this.pvpFireElementResistPercent);
    param1.writeVarShort(this.pvpNeutralElementReduction);
    param1.writeVarShort(this.pvpEarthElementReduction);
    param1.writeVarShort(this.pvpWaterElementReduction);
    param1.writeVarShort(this.pvpAirElementReduction);
    param1.writeVarShort(this.pvpFireElementReduction);
    if (this.dodgePALostProbability < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.dodgePALostProbability
              + ") on element dodgePALostProbability.");
    }
    param1.writeVarShort(this.dodgePALostProbability);
    if (this.dodgePMLostProbability < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.dodgePMLostProbability
              + ") on element dodgePMLostProbability.");
    }
    param1.writeVarShort(this.dodgePMLostProbability);
    param1.writeVarShort(this.tackleBlock);
    param1.writeVarShort(this.tackleEvade);
    param1.writeVarShort(this.fixedDamageReflection);
    param1.writeByte(this.invisibilityState);
    if (this.meleeDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.meleeDamageReceivedPercent
              + ") on element meleeDamageReceivedPercent.");
    }
    param1.writeVarShort(this.meleeDamageReceivedPercent);
    if (this.rangedDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.rangedDamageReceivedPercent
              + ") on element rangedDamageReceivedPercent.");
    }
    param1.writeVarShort(this.rangedDamageReceivedPercent);
    if (this.weaponDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.weaponDamageReceivedPercent
              + ") on element weaponDamageReceivedPercent.");
    }
    param1.writeVarShort(this.weaponDamageReceivedPercent);
    if (this.spellDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.spellDamageReceivedPercent
              + ") on element spellDamageReceivedPercent.");
    }
    param1.writeVarShort(this.spellDamageReceivedPercent);

    if (this.initiative < 0) {
      throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
    }
    param1.writeVarInt(this.initiative);
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

    this.initiative = param1.readVarUhShort();
    if (this.initiative < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.initiative
              + ") on element of PartyMemberInformations.initiative.");
    }
  }
}
