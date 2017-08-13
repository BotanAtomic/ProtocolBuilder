package com.ankamagames.dofus.network.types.game.character.characteristic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorExtendedAlignmentInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterCharacteristicsInformations extends Object implements INetworkType {

    private int protocolId = 8;
    private Number experience = 0;
    private Number experienceLevelFloor = 0;
    private Number experienceNextLevelFloor = 0;
    private Number experienceBonusLimit = 0;
    private Number kamas = 0;
    private int statsPoints = 0;
    private int additionnalPoints = 0;
    private int spellsPoints = 0;
    private ActorExtendedAlignmentInformations alignmentInfos;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int energyPoints = 0;
    private int maxEnergyPoints = 0;
    private int actionPointsCurrent = 0;
    private int movementPointsCurrent = 0;
    private CharacterBaseCharacteristic initiative;
    private CharacterBaseCharacteristic prospecting;
    private CharacterBaseCharacteristic actionPoints;
    private CharacterBaseCharacteristic movementPoints;
    private CharacterBaseCharacteristic strength;
    private CharacterBaseCharacteristic vitality;
    private CharacterBaseCharacteristic wisdom;
    private CharacterBaseCharacteristic chance;
    private CharacterBaseCharacteristic agility;
    private CharacterBaseCharacteristic intelligence;
    private CharacterBaseCharacteristic range;
    private CharacterBaseCharacteristic summonableCreaturesBoost;
    private CharacterBaseCharacteristic reflect;
    private CharacterBaseCharacteristic criticalHit;
    private int criticalHitWeapon = 0;
    private CharacterBaseCharacteristic criticalMiss;
    private CharacterBaseCharacteristic healBonus;
    private CharacterBaseCharacteristic allDamagesBonus;
    private CharacterBaseCharacteristic weaponDamagesBonusPercent;
    private CharacterBaseCharacteristic damagesBonusPercent;
    private CharacterBaseCharacteristic trapBonus;
    private CharacterBaseCharacteristic trapBonusPercent;
    private CharacterBaseCharacteristic glyphBonusPercent;
    private CharacterBaseCharacteristic runeBonusPercent;
    private CharacterBaseCharacteristic permanentDamagePercent;
    private CharacterBaseCharacteristic tackleBlock;
    private CharacterBaseCharacteristic tackleEvade;
    private CharacterBaseCharacteristic PAAttack;
    private CharacterBaseCharacteristic PMAttack;
    private CharacterBaseCharacteristic pushDamageBonus;
    private CharacterBaseCharacteristic criticalDamageBonus;
    private CharacterBaseCharacteristic neutralDamageBonus;
    private CharacterBaseCharacteristic earthDamageBonus;
    private CharacterBaseCharacteristic waterDamageBonus;
    private CharacterBaseCharacteristic airDamageBonus;
    private CharacterBaseCharacteristic fireDamageBonus;
    private CharacterBaseCharacteristic dodgePALostProbability;
    private CharacterBaseCharacteristic dodgePMLostProbability;
    private CharacterBaseCharacteristic neutralElementResistPercent;
    private CharacterBaseCharacteristic earthElementResistPercent;
    private CharacterBaseCharacteristic waterElementResistPercent;
    private CharacterBaseCharacteristic airElementResistPercent;
    private CharacterBaseCharacteristic fireElementResistPercent;
    private CharacterBaseCharacteristic neutralElementReduction;
    private CharacterBaseCharacteristic earthElementReduction;
    private CharacterBaseCharacteristic waterElementReduction;
    private CharacterBaseCharacteristic airElementReduction;
    private CharacterBaseCharacteristic fireElementReduction;
    private CharacterBaseCharacteristic pushDamageReduction;
    private CharacterBaseCharacteristic criticalDamageReduction;
    private CharacterBaseCharacteristic pvpNeutralElementResistPercent;
    private CharacterBaseCharacteristic pvpEarthElementResistPercent;
    private CharacterBaseCharacteristic pvpWaterElementResistPercent;
    private CharacterBaseCharacteristic pvpAirElementResistPercent;
    private CharacterBaseCharacteristic pvpFireElementResistPercent;
    private CharacterBaseCharacteristic pvpNeutralElementReduction;
    private CharacterBaseCharacteristic pvpEarthElementReduction;
    private CharacterBaseCharacteristic pvpWaterElementReduction;
    private CharacterBaseCharacteristic pvpAirElementReduction;
    private CharacterBaseCharacteristic pvpFireElementReduction;
    private CharacterBaseCharacteristic meleeDamageDonePercent;
    private CharacterBaseCharacteristic meleeDamageReceivedPercent;
    private CharacterBaseCharacteristic rangedDamageDonePercent;
    private CharacterBaseCharacteristic rangedDamageReceivedPercent;
    private CharacterBaseCharacteristic weaponDamageDonePercent;
    private CharacterBaseCharacteristic weaponDamageReceivedPercent;
    private CharacterBaseCharacteristic spellDamageDonePercent;
    private CharacterBaseCharacteristic spellDamageReceivedPercent;
    private CharacterSpellModification[] spellModifications;
    private int probationTime = 0;
    private FuncTree _alignmentInfostree;
    private FuncTree _initiativetree;
    private FuncTree _prospectingtree;
    private FuncTree _actionPointstree;
    private FuncTree _movementPointstree;
    private FuncTree _strengthtree;
    private FuncTree _vitalitytree;
    private FuncTree _wisdomtree;
    private FuncTree _chancetree;
    private FuncTree _agilitytree;
    private FuncTree _intelligencetree;
    private FuncTree _rangetree;
    private FuncTree _summonableCreaturesBoosttree;
    private FuncTree _reflecttree;
    private FuncTree _criticalHittree;
    private FuncTree _criticalMisstree;
    private FuncTree _healBonustree;
    private FuncTree _allDamagesBonustree;
    private FuncTree _weaponDamagesBonusPercenttree;
    private FuncTree _damagesBonusPercenttree;
    private FuncTree _trapBonustree;
    private FuncTree _trapBonusPercenttree;
    private FuncTree _glyphBonusPercenttree;
    private FuncTree _runeBonusPercenttree;
    private FuncTree _permanentDamagePercenttree;
    private FuncTree _tackleBlocktree;
    private FuncTree _tackleEvadetree;
    private FuncTree _PAAttacktree;
    private FuncTree _PMAttacktree;
    private FuncTree _pushDamageBonustree;
    private FuncTree _criticalDamageBonustree;
    private FuncTree _neutralDamageBonustree;
    private FuncTree _earthDamageBonustree;
    private FuncTree _waterDamageBonustree;
    private FuncTree _airDamageBonustree;
    private FuncTree _fireDamageBonustree;
    private FuncTree _dodgePALostProbabilitytree;
    private FuncTree _dodgePMLostProbabilitytree;
    private FuncTree _neutralElementResistPercenttree;
    private FuncTree _earthElementResistPercenttree;
    private FuncTree _waterElementResistPercenttree;
    private FuncTree _airElementResistPercenttree;
    private FuncTree _fireElementResistPercenttree;
    private FuncTree _neutralElementReductiontree;
    private FuncTree _earthElementReductiontree;
    private FuncTree _waterElementReductiontree;
    private FuncTree _airElementReductiontree;
    private FuncTree _fireElementReductiontree;
    private FuncTree _pushDamageReductiontree;
    private FuncTree _criticalDamageReductiontree;
    private FuncTree _pvpNeutralElementResistPercenttree;
    private FuncTree _pvpEarthElementResistPercenttree;
    private FuncTree _pvpWaterElementResistPercenttree;
    private FuncTree _pvpAirElementResistPercenttree;
    private FuncTree _pvpFireElementResistPercenttree;
    private FuncTree _pvpNeutralElementReductiontree;
    private FuncTree _pvpEarthElementReductiontree;
    private FuncTree _pvpWaterElementReductiontree;
    private FuncTree _pvpAirElementReductiontree;
    private FuncTree _pvpFireElementReductiontree;
    private FuncTree _meleeDamageDonePercenttree;
    private FuncTree _meleeDamageReceivedPercenttree;
    private FuncTree _rangedDamageDonePercenttree;
    private FuncTree _rangedDamageReceivedPercenttree;
    private FuncTree _weaponDamageDonePercenttree;
    private FuncTree _weaponDamageReceivedPercenttree;
    private FuncTree _spellDamageDonePercenttree;
    private FuncTree _spellDamageReceivedPercenttree;
    private FuncTree _spellModificationstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
         }
         param1.writeVarLong(this.experience);
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceLevelFloor + ") on element experienceLevelFloor.");
         }
         param1.writeVarLong(this.experienceLevelFloor);
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceNextLevelFloor + ") on element experienceNextLevelFloor.");
         }
         param1.writeVarLong(this.experienceNextLevelFloor);
         if(this.experienceBonusLimit < 0 || this.experienceBonusLimit > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceBonusLimit + ") on element experienceBonusLimit.");
         }
         param1.writeVarLong(this.experienceBonusLimit);
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
         }
         param1.writeVarLong(this.kamas);
         if(this.statsPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.statsPoints + ") on element statsPoints.");
         }
         param1.writeVarShort(this.statsPoints);
         if(this.additionnalPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.additionnalPoints + ") on element additionnalPoints.");
         }
         param1.writeVarShort(this.additionnalPoints);
         if(this.spellsPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.spellsPoints + ") on element spellsPoints.");
         }
         param1.writeVarShort(this.spellsPoints);
         this.alignmentInfos.serializeAs_ActorExtendedAlignmentInformations(param1);
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
         }
         param1.writeVarInt(this.lifePoints);
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
         }
         param1.writeVarInt(this.maxLifePoints);
         if(this.energyPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.energyPoints + ") on element energyPoints.");
         }
         param1.writeVarShort(this.energyPoints);
         if(this.maxEnergyPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxEnergyPoints + ") on element maxEnergyPoints.");
         }
         param1.writeVarShort(this.maxEnergyPoints);
         param1.writeVarShort(this.actionPointsCurrent);
         param1.writeVarShort(this.movementPointsCurrent);
         this.initiative.serializeAs_CharacterBaseCharacteristic(param1);
         this.prospecting.serializeAs_CharacterBaseCharacteristic(param1);
         this.actionPoints.serializeAs_CharacterBaseCharacteristic(param1);
         this.movementPoints.serializeAs_CharacterBaseCharacteristic(param1);
         this.strength.serializeAs_CharacterBaseCharacteristic(param1);
         this.vitality.serializeAs_CharacterBaseCharacteristic(param1);
         this.wisdom.serializeAs_CharacterBaseCharacteristic(param1);
         this.chance.serializeAs_CharacterBaseCharacteristic(param1);
         this.agility.serializeAs_CharacterBaseCharacteristic(param1);
         this.intelligence.serializeAs_CharacterBaseCharacteristic(param1);
         this.range.serializeAs_CharacterBaseCharacteristic(param1);
         this.summonableCreaturesBoost.serializeAs_CharacterBaseCharacteristic(param1);
         this.reflect.serializeAs_CharacterBaseCharacteristic(param1);
         this.criticalHit.serializeAs_CharacterBaseCharacteristic(param1);
         if(this.criticalHitWeapon < 0)
         {
            throw new Exception("Forbidden value (" + this.criticalHitWeapon + ") on element criticalHitWeapon.");
         }
         param1.writeVarShort(this.criticalHitWeapon);
         this.criticalMiss.serializeAs_CharacterBaseCharacteristic(param1);
         this.healBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.allDamagesBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.weaponDamagesBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.damagesBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.trapBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.trapBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.glyphBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.runeBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.permanentDamagePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.tackleBlock.serializeAs_CharacterBaseCharacteristic(param1);
         this.tackleEvade.serializeAs_CharacterBaseCharacteristic(param1);
         this.PAAttack.serializeAs_CharacterBaseCharacteristic(param1);
         this.PMAttack.serializeAs_CharacterBaseCharacteristic(param1);
         this.pushDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.criticalDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.neutralDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.earthDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.waterDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.airDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.fireDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.dodgePALostProbability.serializeAs_CharacterBaseCharacteristic(param1);
         this.dodgePMLostProbability.serializeAs_CharacterBaseCharacteristic(param1);
         this.neutralElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.earthElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.waterElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.airElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.fireElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.neutralElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.earthElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.waterElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.airElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.fireElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pushDamageReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.criticalDamageReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpNeutralElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpEarthElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpWaterElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpAirElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpFireElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpNeutralElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpEarthElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpWaterElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpAirElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpFireElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.meleeDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.meleeDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.rangedDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.rangedDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.weaponDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.weaponDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.spellDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.spellDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         param1.writeShort(this.spellModifications.length);
         int _loc2_ = 0;
         while(_loc2_ < this.spellModifications.length)
         {
            (this.spellModifications[_loc2_] as CharacterSpellModification).serializeAs_CharacterSpellModification(param1);
            _loc2_++;
         }
         if(this.probationTime < 0)
         {
            throw new Exception("Forbidden value (" + this.probationTime + ") on element probationTime.");
         }
         param1.writeInt(this.probationTime);
    }

    public void deserialize(ICustomDataInput param1) {
         CharacterSpellModification _loc4_ = null;
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element of CharacterCharacteristicsInformations.experience.");
         }
         this.experienceLevelFloor = param1.readVarUhLong();
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceLevelFloor + ") on element of CharacterCharacteristicsInformations.experienceLevelFloor.");
         }
         this.experienceNextLevelFloor = param1.readVarUhLong();
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceNextLevelFloor + ") on element of CharacterCharacteristicsInformations.experienceNextLevelFloor.");
         }
         this.experienceBonusLimit = param1.readVarUhLong();
         if(this.experienceBonusLimit < 0 || this.experienceBonusLimit > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceBonusLimit + ") on element of CharacterCharacteristicsInformations.experienceBonusLimit.");
         }
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element of CharacterCharacteristicsInformations.kamas.");
         }
         this.statsPoints = param1.readVarUhShort();
         if(this.statsPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.statsPoints + ") on element of CharacterCharacteristicsInformations.statsPoints.");
         }
         this.additionnalPoints = param1.readVarUhShort();
         if(this.additionnalPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.additionnalPoints + ") on element of CharacterCharacteristicsInformations.additionnalPoints.");
         }
         this.spellsPoints = param1.readVarUhShort();
         if(this.spellsPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.spellsPoints + ") on element of CharacterCharacteristicsInformations.spellsPoints.");
         }
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of CharacterCharacteristicsInformations.lifePoints.");
         }
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of CharacterCharacteristicsInformations.maxLifePoints.");
         }
         this.energyPoints = param1.readVarUhShort();
         if(this.energyPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.energyPoints + ") on element of CharacterCharacteristicsInformations.energyPoints.");
         }
         this.maxEnergyPoints = param1.readVarUhShort();
         if(this.maxEnergyPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxEnergyPoints + ") on element of CharacterCharacteristicsInformations.maxEnergyPoints.");
         }
         this.actionPointsCurrent = param1.readVarShort();
         this.movementPointsCurrent = param1.readVarShort();
         this.initiative = new CharacterBaseCharacteristic();
         this.initiative.deserialize(param1);
         this.prospecting = new CharacterBaseCharacteristic();
         this.prospecting.deserialize(param1);
         this.actionPoints = new CharacterBaseCharacteristic();
         this.actionPoints.deserialize(param1);
         this.movementPoints = new CharacterBaseCharacteristic();
         this.movementPoints.deserialize(param1);
         this.strength = new CharacterBaseCharacteristic();
         this.strength.deserialize(param1);
         this.vitality = new CharacterBaseCharacteristic();
         this.vitality.deserialize(param1);
         this.wisdom = new CharacterBaseCharacteristic();
         this.wisdom.deserialize(param1);
         this.chance = new CharacterBaseCharacteristic();
         this.chance.deserialize(param1);
         this.agility = new CharacterBaseCharacteristic();
         this.agility.deserialize(param1);
         this.intelligence = new CharacterBaseCharacteristic();
         this.intelligence.deserialize(param1);
         this.range = new CharacterBaseCharacteristic();
         this.range.deserialize(param1);
         this.summonableCreaturesBoost = new CharacterBaseCharacteristic();
         this.summonableCreaturesBoost.deserialize(param1);
         this.reflect = new CharacterBaseCharacteristic();
         this.reflect.deserialize(param1);
         this.criticalHit = new CharacterBaseCharacteristic();
         this.criticalHit.deserialize(param1);
         this.criticalHitWeapon = param1.readVarUhShort();
         if(this.criticalHitWeapon < 0)
         {
            throw new Exception("Forbidden value (" + this.criticalHitWeapon + ") on element of CharacterCharacteristicsInformations.criticalHitWeapon.");
         }
         this.criticalMiss = new CharacterBaseCharacteristic();
         this.criticalMiss.deserialize(param1);
         this.healBonus = new CharacterBaseCharacteristic();
         this.healBonus.deserialize(param1);
         this.allDamagesBonus = new CharacterBaseCharacteristic();
         this.allDamagesBonus.deserialize(param1);
         this.weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
         this.weaponDamagesBonusPercent.deserialize(param1);
         this.damagesBonusPercent = new CharacterBaseCharacteristic();
         this.damagesBonusPercent.deserialize(param1);
         this.trapBonus = new CharacterBaseCharacteristic();
         this.trapBonus.deserialize(param1);
         this.trapBonusPercent = new CharacterBaseCharacteristic();
         this.trapBonusPercent.deserialize(param1);
         this.glyphBonusPercent = new CharacterBaseCharacteristic();
         this.glyphBonusPercent.deserialize(param1);
         this.runeBonusPercent = new CharacterBaseCharacteristic();
         this.runeBonusPercent.deserialize(param1);
         this.permanentDamagePercent = new CharacterBaseCharacteristic();
         this.permanentDamagePercent.deserialize(param1);
         this.tackleBlock = new CharacterBaseCharacteristic();
         this.tackleBlock.deserialize(param1);
         this.tackleEvade = new CharacterBaseCharacteristic();
         this.tackleEvade.deserialize(param1);
         this.PAAttack = new CharacterBaseCharacteristic();
         this.PAAttack.deserialize(param1);
         this.PMAttack = new CharacterBaseCharacteristic();
         this.PMAttack.deserialize(param1);
         this.pushDamageBonus = new CharacterBaseCharacteristic();
         this.pushDamageBonus.deserialize(param1);
         this.criticalDamageBonus = new CharacterBaseCharacteristic();
         this.criticalDamageBonus.deserialize(param1);
         this.neutralDamageBonus = new CharacterBaseCharacteristic();
         this.neutralDamageBonus.deserialize(param1);
         this.earthDamageBonus = new CharacterBaseCharacteristic();
         this.earthDamageBonus.deserialize(param1);
         this.waterDamageBonus = new CharacterBaseCharacteristic();
         this.waterDamageBonus.deserialize(param1);
         this.airDamageBonus = new CharacterBaseCharacteristic();
         this.airDamageBonus.deserialize(param1);
         this.fireDamageBonus = new CharacterBaseCharacteristic();
         this.fireDamageBonus.deserialize(param1);
         this.dodgePALostProbability = new CharacterBaseCharacteristic();
         this.dodgePALostProbability.deserialize(param1);
         this.dodgePMLostProbability = new CharacterBaseCharacteristic();
         this.dodgePMLostProbability.deserialize(param1);
         this.neutralElementResistPercent = new CharacterBaseCharacteristic();
         this.neutralElementResistPercent.deserialize(param1);
         this.earthElementResistPercent = new CharacterBaseCharacteristic();
         this.earthElementResistPercent.deserialize(param1);
         this.waterElementResistPercent = new CharacterBaseCharacteristic();
         this.waterElementResistPercent.deserialize(param1);
         this.airElementResistPercent = new CharacterBaseCharacteristic();
         this.airElementResistPercent.deserialize(param1);
         this.fireElementResistPercent = new CharacterBaseCharacteristic();
         this.fireElementResistPercent.deserialize(param1);
         this.neutralElementReduction = new CharacterBaseCharacteristic();
         this.neutralElementReduction.deserialize(param1);
         this.earthElementReduction = new CharacterBaseCharacteristic();
         this.earthElementReduction.deserialize(param1);
         this.waterElementReduction = new CharacterBaseCharacteristic();
         this.waterElementReduction.deserialize(param1);
         this.airElementReduction = new CharacterBaseCharacteristic();
         this.airElementReduction.deserialize(param1);
         this.fireElementReduction = new CharacterBaseCharacteristic();
         this.fireElementReduction.deserialize(param1);
         this.pushDamageReduction = new CharacterBaseCharacteristic();
         this.pushDamageReduction.deserialize(param1);
         this.criticalDamageReduction = new CharacterBaseCharacteristic();
         this.criticalDamageReduction.deserialize(param1);
         this.pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpNeutralElementResistPercent.deserialize(param1);
         this.pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpEarthElementResistPercent.deserialize(param1);
         this.pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpWaterElementResistPercent.deserialize(param1);
         this.pvpAirElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpAirElementResistPercent.deserialize(param1);
         this.pvpFireElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpFireElementResistPercent.deserialize(param1);
         this.pvpNeutralElementReduction = new CharacterBaseCharacteristic();
         this.pvpNeutralElementReduction.deserialize(param1);
         this.pvpEarthElementReduction = new CharacterBaseCharacteristic();
         this.pvpEarthElementReduction.deserialize(param1);
         this.pvpWaterElementReduction = new CharacterBaseCharacteristic();
         this.pvpWaterElementReduction.deserialize(param1);
         this.pvpAirElementReduction = new CharacterBaseCharacteristic();
         this.pvpAirElementReduction.deserialize(param1);
         this.pvpFireElementReduction = new CharacterBaseCharacteristic();
         this.pvpFireElementReduction.deserialize(param1);
         this.meleeDamageDonePercent = new CharacterBaseCharacteristic();
         this.meleeDamageDonePercent.deserialize(param1);
         this.meleeDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.meleeDamageReceivedPercent.deserialize(param1);
         this.rangedDamageDonePercent = new CharacterBaseCharacteristic();
         this.rangedDamageDonePercent.deserialize(param1);
         this.rangedDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.rangedDamageReceivedPercent.deserialize(param1);
         this.weaponDamageDonePercent = new CharacterBaseCharacteristic();
         this.weaponDamageDonePercent.deserialize(param1);
         this.weaponDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.weaponDamageReceivedPercent.deserialize(param1);
         this.spellDamageDonePercent = new CharacterBaseCharacteristic();
         this.spellDamageDonePercent.deserialize(param1);
         this.spellDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.spellDamageReceivedPercent.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new CharacterSpellModification();
            _loc4_.deserialize(param1);
            this.spellModifications.push(_loc4_);
            _loc3_++;
         }
         this.probationTime = param1.readInt();
         if(this.probationTime < 0)
         {
            throw new Exception("Forbidden value (" + this.probationTime + ") on element of CharacterCharacteristicsInformations.probationTime.");
         }
    }

}