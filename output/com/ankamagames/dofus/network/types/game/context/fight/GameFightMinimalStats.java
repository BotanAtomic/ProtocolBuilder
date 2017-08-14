package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightMinimalStats extends Object implements INetworkType {

  public int lifePoints = 0;
  public int maxLifePoints = 0;
  public int baseMaxLifePoints = 0;
  public int permanentDamagePercent = 0;
  public int shieldPoints = 0;
  public int actionPoints = 0;
  public int maxActionPoints = 0;
  public int movementPoints = 0;
  public int maxMovementPoints = 0;
  public Number summoner = 0;
  public boolean summoned = false;
  public int neutralElementResistPercent = 0;
  public int earthElementResistPercent = 0;
  public int waterElementResistPercent = 0;
  public int airElementResistPercent = 0;
  public int fireElementResistPercent = 0;
  public int neutralElementReduction = 0;
  public int earthElementReduction = 0;
  public int waterElementReduction = 0;
  public int airElementReduction = 0;
  public int fireElementReduction = 0;
  public int criticalDamageFixedResist = 0;
  public int pushDamageFixedResist = 0;
  public int pvpNeutralElementResistPercent = 0;
  public int pvpEarthElementResistPercent = 0;
  public int pvpWaterElementResistPercent = 0;
  public int pvpAirElementResistPercent = 0;
  public int pvpFireElementResistPercent = 0;
  public int pvpNeutralElementReduction = 0;
  public int pvpEarthElementReduction = 0;
  public int pvpWaterElementReduction = 0;
  public int pvpAirElementReduction = 0;
  public int pvpFireElementReduction = 0;
  public int dodgePALostProbability = 0;
  public int dodgePMLostProbability = 0;
  public int tackleBlock = 0;
  public int tackleEvade = 0;
  public int fixedDamageReflection = 0;
  public int invisibilityState = 0;
  public int meleeDamageReceivedPercent = 0;
  public int rangedDamageReceivedPercent = 0;
  public int weaponDamageReceivedPercent = 0;
  public int spellDamageReceivedPercent = 0;
  public static final int protocolId = 31;

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
  }

  public void deserialize(ICustomDataInput param1) {
    this.lifePoints = param1.readVarUhInt();
    if (this.lifePoints < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.lifePoints
              + ") on element of PartyMemberInformations.lifePoints.");
    }

    this.maxLifePoints = param1.readVarUhInt();
    if (this.maxLifePoints < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.maxLifePoints
              + ") on element of PartyMemberInformations.maxLifePoints.");
    }

    this.baseMaxLifePoints = param1.readVarUhInt();
    if (this.baseMaxLifePoints < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.baseMaxLifePoints
              + ") on element of GameFightMinimalStats.baseMaxLifePoints.");
    }

    this.permanentDamagePercent = param1.readVarUhInt();
    if (this.permanentDamagePercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.permanentDamagePercent
              + ") on element of GameFightMinimalStats.permanentDamagePercent.");
    }

    this.shieldPoints = param1.readVarUhInt();
    if (this.shieldPoints < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.shieldPoints
              + ") on element of GameFightMinimalStats.shieldPoints.");
    }

    this.actionPoints = param1.readVarShort();

    this.maxActionPoints = param1.readVarShort();

    this.movementPoints = param1.readVarShort();

    this.maxMovementPoints = param1.readVarShort();

    this.summoner = param1.readDouble();
    if (this.summoner < -9.007199254740992E15 || this.summoner > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.summoner + ") on element of GameFightMinimalStats.summoner.");
    }

    this.summoned = param1.readBoolean();

    this.neutralElementResistPercent = param1.readVarShort();

    this.earthElementResistPercent = param1.readVarShort();

    this.waterElementResistPercent = param1.readVarShort();

    this.airElementResistPercent = param1.readVarShort();

    this.fireElementResistPercent = param1.readVarShort();

    this.neutralElementReduction = param1.readVarShort();

    this.earthElementReduction = param1.readVarShort();

    this.waterElementReduction = param1.readVarShort();

    this.airElementReduction = param1.readVarShort();

    this.fireElementReduction = param1.readVarShort();

    this.criticalDamageFixedResist = param1.readVarShort();

    this.pushDamageFixedResist = param1.readVarShort();

    this.pvpNeutralElementResistPercent = param1.readVarShort();

    this.pvpEarthElementResistPercent = param1.readVarShort();

    this.pvpWaterElementResistPercent = param1.readVarShort();

    this.pvpAirElementResistPercent = param1.readVarShort();

    this.pvpFireElementResistPercent = param1.readVarShort();

    this.pvpNeutralElementReduction = param1.readVarShort();

    this.pvpEarthElementReduction = param1.readVarShort();

    this.pvpWaterElementReduction = param1.readVarShort();

    this.pvpAirElementReduction = param1.readVarShort();

    this.pvpFireElementReduction = param1.readVarShort();

    this.dodgePALostProbability = param1.readVarUhShort();
    if (this.dodgePALostProbability < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.dodgePALostProbability
              + ") on element of GameFightMinimalStats.dodgePALostProbability.");
    }

    this.dodgePMLostProbability = param1.readVarUhShort();
    if (this.dodgePMLostProbability < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.dodgePMLostProbability
              + ") on element of GameFightMinimalStats.dodgePMLostProbability.");
    }

    this.tackleBlock = param1.readVarShort();

    this.tackleEvade = param1.readVarShort();

    this.fixedDamageReflection = param1.readVarShort();

    this.invisibilityState = param1.readByte();
    if (this.invisibilityState < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.invisibilityState
              + ") on element of GameFightMinimalStats.invisibilityState.");
    }

    this.meleeDamageReceivedPercent = param1.readVarUhShort();
    if (this.meleeDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.meleeDamageReceivedPercent
              + ") on element of GameFightMinimalStats.meleeDamageReceivedPercent.");
    }

    this.rangedDamageReceivedPercent = param1.readVarUhShort();
    if (this.rangedDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.rangedDamageReceivedPercent
              + ") on element of GameFightMinimalStats.rangedDamageReceivedPercent.");
    }

    this.weaponDamageReceivedPercent = param1.readVarUhShort();
    if (this.weaponDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.weaponDamageReceivedPercent
              + ") on element of GameFightMinimalStats.weaponDamageReceivedPercent.");
    }

    this.spellDamageReceivedPercent = param1.readVarUhShort();
    if (this.spellDamageReceivedPercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.spellDamageReceivedPercent
              + ") on element of GameFightMinimalStats.spellDamageReceivedPercent.");
    }
  }
}
