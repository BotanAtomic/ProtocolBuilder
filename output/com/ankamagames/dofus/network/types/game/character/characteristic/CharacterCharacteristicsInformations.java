package package com.ankamagames.dofus.network.types.game.character.characteristic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorExtendedAlignmentInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
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
    private ActorExtendedAlignmentInformations alignmentInfos = ;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int energyPoints = 0;
    private int maxEnergyPoints = 0;
    private int actionPointsCurrent = 0;
    private int movementPointsCurrent = 0;
    private CharacterBaseCharacteristic initiative = ;
    private CharacterBaseCharacteristic prospecting = ;
    private CharacterBaseCharacteristic actionPoints = ;
    private CharacterBaseCharacteristic movementPoints = ;
    private CharacterBaseCharacteristic strength = ;
    private CharacterBaseCharacteristic vitality = ;
    private CharacterBaseCharacteristic wisdom = ;
    private CharacterBaseCharacteristic chance = ;
    private CharacterBaseCharacteristic agility = ;
    private CharacterBaseCharacteristic intelligence = ;
    private CharacterBaseCharacteristic range = ;
    private CharacterBaseCharacteristic summonableCreaturesBoost = ;
    private CharacterBaseCharacteristic reflect = ;
    private CharacterBaseCharacteristic criticalHit = ;
    private int criticalHitWeapon = 0;
    private CharacterBaseCharacteristic criticalMiss = ;
    private CharacterBaseCharacteristic healBonus = ;
    private CharacterBaseCharacteristic allDamagesBonus = ;
    private CharacterBaseCharacteristic weaponDamagesBonusPercent = ;
    private CharacterBaseCharacteristic damagesBonusPercent = ;
    private CharacterBaseCharacteristic trapBonus = ;
    private CharacterBaseCharacteristic trapBonusPercent = ;
    private CharacterBaseCharacteristic glyphBonusPercent = ;
    private CharacterBaseCharacteristic runeBonusPercent = ;
    private CharacterBaseCharacteristic permanentDamagePercent = ;
    private CharacterBaseCharacteristic tackleBlock = ;
    private CharacterBaseCharacteristic tackleEvade = ;
    private CharacterBaseCharacteristic PAAttack = ;
    private CharacterBaseCharacteristic PMAttack = ;
    private CharacterBaseCharacteristic pushDamageBonus = ;
    private CharacterBaseCharacteristic criticalDamageBonus = ;
    private CharacterBaseCharacteristic neutralDamageBonus = ;
    private CharacterBaseCharacteristic earthDamageBonus = ;
    private CharacterBaseCharacteristic waterDamageBonus = ;
    private CharacterBaseCharacteristic airDamageBonus = ;
    private CharacterBaseCharacteristic fireDamageBonus = ;
    private CharacterBaseCharacteristic dodgePALostProbability = ;
    private CharacterBaseCharacteristic dodgePMLostProbability = ;
    private CharacterBaseCharacteristic neutralElementResistPercent = ;
    private CharacterBaseCharacteristic earthElementResistPercent = ;
    private CharacterBaseCharacteristic waterElementResistPercent = ;
    private CharacterBaseCharacteristic airElementResistPercent = ;
    private CharacterBaseCharacteristic fireElementResistPercent = ;
    private CharacterBaseCharacteristic neutralElementReduction = ;
    private CharacterBaseCharacteristic earthElementReduction = ;
    private CharacterBaseCharacteristic waterElementReduction = ;
    private CharacterBaseCharacteristic airElementReduction = ;
    private CharacterBaseCharacteristic fireElementReduction = ;
    private CharacterBaseCharacteristic pushDamageReduction = ;
    private CharacterBaseCharacteristic criticalDamageReduction = ;
    private CharacterBaseCharacteristic pvpNeutralElementResistPercent = ;
    private CharacterBaseCharacteristic pvpEarthElementResistPercent = ;
    private CharacterBaseCharacteristic pvpWaterElementResistPercent = ;
    private CharacterBaseCharacteristic pvpAirElementResistPercent = ;
    private CharacterBaseCharacteristic pvpFireElementResistPercent = ;
    private CharacterBaseCharacteristic pvpNeutralElementReduction = ;
    private CharacterBaseCharacteristic pvpEarthElementReduction = ;
    private CharacterBaseCharacteristic pvpWaterElementReduction = ;
    private CharacterBaseCharacteristic pvpAirElementReduction = ;
    private CharacterBaseCharacteristic pvpFireElementReduction = ;
    private CharacterBaseCharacteristic meleeDamageDonePercent = ;
    private CharacterBaseCharacteristic meleeDamageReceivedPercent = ;
    private CharacterBaseCharacteristic rangedDamageDonePercent = ;
    private CharacterBaseCharacteristic rangedDamageReceivedPercent = ;
    private CharacterBaseCharacteristic weaponDamageDonePercent = ;
    private CharacterBaseCharacteristic weaponDamageReceivedPercent = ;
    private CharacterBaseCharacteristic spellDamageDonePercent = ;
    private CharacterBaseCharacteristic spellDamageReceivedPercent = ;
    private Vector.<CharacterSpellModification> spellModifications = ;
    private int probationTime = 0;
    private FuncTree _alignmentInfostree = ;
    private FuncTree _initiativetree = ;
    private FuncTree _prospectingtree = ;
    private FuncTree _actionPointstree = ;
    private FuncTree _movementPointstree = ;
    private FuncTree _strengthtree = ;
    private FuncTree _vitalitytree = ;
    private FuncTree _wisdomtree = ;
    private FuncTree _chancetree = ;
    private FuncTree _agilitytree = ;
    private FuncTree _intelligencetree = ;
    private FuncTree _rangetree = ;
    private FuncTree _summonableCreaturesBoosttree = ;
    private FuncTree _reflecttree = ;
    private FuncTree _criticalHittree = ;
    private FuncTree _criticalMisstree = ;
    private FuncTree _healBonustree = ;
    private FuncTree _allDamagesBonustree = ;
    private FuncTree _weaponDamagesBonusPercenttree = ;
    private FuncTree _damagesBonusPercenttree = ;
    private FuncTree _trapBonustree = ;
    private FuncTree _trapBonusPercenttree = ;
    private FuncTree _glyphBonusPercenttree = ;
    private FuncTree _runeBonusPercenttree = ;
    private FuncTree _permanentDamagePercenttree = ;
    private FuncTree _tackleBlocktree = ;
    private FuncTree _tackleEvadetree = ;
    private FuncTree _PAAttacktree = ;
    private FuncTree _PMAttacktree = ;
    private FuncTree _pushDamageBonustree = ;
    private FuncTree _criticalDamageBonustree = ;
    private FuncTree _neutralDamageBonustree = ;
    private FuncTree _earthDamageBonustree = ;
    private FuncTree _waterDamageBonustree = ;
    private FuncTree _airDamageBonustree = ;
    private FuncTree _fireDamageBonustree = ;
    private FuncTree _dodgePALostProbabilitytree = ;
    private FuncTree _dodgePMLostProbabilitytree = ;
    private FuncTree _neutralElementResistPercenttree = ;
    private FuncTree _earthElementResistPercenttree = ;
    private FuncTree _waterElementResistPercenttree = ;
    private FuncTree _airElementResistPercenttree = ;
    private FuncTree _fireElementResistPercenttree = ;
    private FuncTree _neutralElementReductiontree = ;
    private FuncTree _earthElementReductiontree = ;
    private FuncTree _waterElementReductiontree = ;
    private FuncTree _airElementReductiontree = ;
    private FuncTree _fireElementReductiontree = ;
    private FuncTree _pushDamageReductiontree = ;
    private FuncTree _criticalDamageReductiontree = ;
    private FuncTree _pvpNeutralElementResistPercenttree = ;
    private FuncTree _pvpEarthElementResistPercenttree = ;
    private FuncTree _pvpWaterElementResistPercenttree = ;
    private FuncTree _pvpAirElementResistPercenttree = ;
    private FuncTree _pvpFireElementResistPercenttree = ;
    private FuncTree _pvpNeutralElementReductiontree = ;
    private FuncTree _pvpEarthElementReductiontree = ;
    private FuncTree _pvpWaterElementReductiontree = ;
    private FuncTree _pvpAirElementReductiontree = ;
    private FuncTree _pvpFireElementReductiontree = ;
    private FuncTree _meleeDamageDonePercenttree = ;
    private FuncTree _meleeDamageReceivedPercenttree = ;
    private FuncTree _rangedDamageDonePercenttree = ;
    private FuncTree _rangedDamageReceivedPercenttree = ;
    private FuncTree _weaponDamageDonePercenttree = ;
    private FuncTree _weaponDamageReceivedPercenttree = ;
    private FuncTree _spellDamageDonePercenttree = ;
    private FuncTree _spellDamageReceivedPercenttree = ;
    private FuncTree _spellModificationstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 8;
    }

    public CharacterCharacteristicsInformations initCharacterCharacteristicsInformations(Number param1,Number  param2,Number  param3,Number  param4,Number  param5,int  param6,int  param7,int  param8,ActorExtendedAlignmentInformations  param9,int  param10,int  param11,int  param12,int  param13,int  param14,int  param15,CharacterBaseCharacteristic  param16,CharacterBaseCharacteristic  param17,CharacterBaseCharacteristic  param18,CharacterBaseCharacteristic  param19,CharacterBaseCharacteristic  param20,CharacterBaseCharacteristic  param21,CharacterBaseCharacteristic  param22,CharacterBaseCharacteristic  param23,CharacterBaseCharacteristic  param24,CharacterBaseCharacteristic  param25,CharacterBaseCharacteristic  param26,CharacterBaseCharacteristic  param27,CharacterBaseCharacteristic  param28,CharacterBaseCharacteristic  param29,int  param30,CharacterBaseCharacteristic  param31,CharacterBaseCharacteristic  param32,CharacterBaseCharacteristic  param33,CharacterBaseCharacteristic  param34,CharacterBaseCharacteristic  param35,CharacterBaseCharacteristic  param36,CharacterBaseCharacteristic  param37,CharacterBaseCharacteristic  param38,CharacterBaseCharacteristic  param39,CharacterBaseCharacteristic  param40,CharacterBaseCharacteristic  param41,CharacterBaseCharacteristic  param42,CharacterBaseCharacteristic  param43,CharacterBaseCharacteristic  param44,CharacterBaseCharacteristic  param45,CharacterBaseCharacteristic  param46,CharacterBaseCharacteristic  param47,CharacterBaseCharacteristic  param48,CharacterBaseCharacteristic  param49,CharacterBaseCharacteristic  param50,CharacterBaseCharacteristic  param51,CharacterBaseCharacteristic  param52,CharacterBaseCharacteristic  param53,CharacterBaseCharacteristic  param54,CharacterBaseCharacteristic  param55,CharacterBaseCharacteristic  param56,CharacterBaseCharacteristic  param57,CharacterBaseCharacteristic  param58,CharacterBaseCharacteristic  param59,CharacterBaseCharacteristic  param60,CharacterBaseCharacteristic  param61,CharacterBaseCharacteristic  param62,CharacterBaseCharacteristic  param63,CharacterBaseCharacteristic  param64,CharacterBaseCharacteristic  param65,CharacterBaseCharacteristic  param66,CharacterBaseCharacteristic  param67,CharacterBaseCharacteristic  param68,CharacterBaseCharacteristic  param69,CharacterBaseCharacteristic  param70,CharacterBaseCharacteristic  param71,CharacterBaseCharacteristic  param72,CharacterBaseCharacteristic  param73,CharacterBaseCharacteristic  param74,CharacterBaseCharacteristic  param75,CharacterBaseCharacteristic  param76,CharacterBaseCharacteristic  param77,CharacterBaseCharacteristic  param78,CharacterBaseCharacteristic  param79,CharacterBaseCharacteristic  param80,CharacterBaseCharacteristic  param81,CharacterBaseCharacteristic  param82,CharacterBaseCharacteristic  param83,Vector.<CharacterSpellModification>  param84,int  param85) {
         this.experience = param1;
         this.experienceLevelFloor = param2;
         this.experienceNextLevelFloor = param3;
         this.experienceBonusLimit = param4;
         this.kamas = param5;
         this.statsPoints = param6;
         this.additionnalPoints = param7;
         this.spellsPoints = param8;
         this.alignmentInfos = param9;
         this.lifePoints = param10;
         this.maxLifePoints = param11;
         this.energyPoints = param12;
         this.maxEnergyPoints = param13;
         this.actionPointsCurrent = param14;
         this.movementPointsCurrent = param15;
         this.initiative = param16;
         this.prospecting = param17;
         this.actionPoints = param18;
         this.movementPoints = param19;
         this.strength = param20;
         this.vitality = param21;
         this.wisdom = param22;
         this.chance = param23;
         this.agility = param24;
         this.intelligence = param25;
         this.range = param26;
         this.summonableCreaturesBoost = param27;
         this.reflect = param28;
         this.criticalHit = param29;
         this.criticalHitWeapon = param30;
         this.criticalMiss = param31;
         this.healBonus = param32;
         this.allDamagesBonus = param33;
         this.weaponDamagesBonusPercent = param34;
         this.damagesBonusPercent = param35;
         this.trapBonus = param36;
         this.trapBonusPercent = param37;
         this.glyphBonusPercent = param38;
         this.runeBonusPercent = param39;
         this.permanentDamagePercent = param40;
         this.tackleBlock = param41;
         this.tackleEvade = param42;
         this.PAAttack = param43;
         this.PMAttack = param44;
         this.pushDamageBonus = param45;
         this.criticalDamageBonus = param46;
         this.neutralDamageBonus = param47;
         this.earthDamageBonus = param48;
         this.waterDamageBonus = param49;
         this.airDamageBonus = param50;
         this.fireDamageBonus = param51;
         this.dodgePALostProbability = param52;
         this.dodgePMLostProbability = param53;
         this.neutralElementResistPercent = param54;
         this.earthElementResistPercent = param55;
         this.waterElementResistPercent = param56;
         this.airElementResistPercent = param57;
         this.fireElementResistPercent = param58;
         this.neutralElementReduction = param59;
         this.earthElementReduction = param60;
         this.waterElementReduction = param61;
         this.airElementReduction = param62;
         this.fireElementReduction = param63;
         this.pushDamageReduction = param64;
         this.criticalDamageReduction = param65;
         this.pvpNeutralElementResistPercent = param66;
         this.pvpEarthElementResistPercent = param67;
         this.pvpWaterElementResistPercent = param68;
         this.pvpAirElementResistPercent = param69;
         this.pvpFireElementResistPercent = param70;
         this.pvpNeutralElementReduction = param71;
         this.pvpEarthElementReduction = param72;
         this.pvpWaterElementReduction = param73;
         this.pvpAirElementReduction = param74;
         this.pvpFireElementReduction = param75;
         this.meleeDamageDonePercent = param76;
         this.meleeDamageReceivedPercent = param77;
         this.rangedDamageDonePercent = param78;
         this.rangedDamageReceivedPercent = param79;
         this.weaponDamageDonePercent = param80;
         this.weaponDamageReceivedPercent = param81;
         this.spellDamageDonePercent = param82;
         this.spellDamageReceivedPercent = param83;
         this.spellModifications = param84;
         this.probationTime = param85;
         return this;
    }

    public void reset() {
         this.experience = 0;
         this.experienceLevelFloor = 0;
         this.experienceNextLevelFloor = 0;
         this.experienceBonusLimit = 0;
         this.kamas = 0;
         this.statsPoints = 0;
         this.additionnalPoints = 0;
         this.spellsPoints = 0;
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.maxLifePoints = 0;
         this.energyPoints = 0;
         this.maxEnergyPoints = 0;
         this.actionPointsCurrent = 0;
         this.movementPointsCurrent = 0;
         this.initiative = new CharacterBaseCharacteristic();
         this.criticalMiss = new CharacterBaseCharacteristic();
         this.probationTime = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterCharacteristicsInformations(param1);
    }

    public void serializeAs_CharacterCharacteristicsInformations(ICustomDataOutput param1) {
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterCharacteristicsInformations(param1);
    }

    public void deserializeAs_CharacterCharacteristicsInformations(ICustomDataInput param1) {
         CharacterSpellModification _loc4_ = null;
         this._experienceFunc(param1);
         this._experienceLevelFloorFunc(param1);
         this._experienceNextLevelFloorFunc(param1);
         this._experienceBonusLimitFunc(param1);
         this._kamasFunc(param1);
         this._statsPointsFunc(param1);
         this._additionnalPointsFunc(param1);
         this._spellsPointsFunc(param1);
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
         this._lifePointsFunc(param1);
         this._maxLifePointsFunc(param1);
         this._energyPointsFunc(param1);
         this._maxEnergyPointsFunc(param1);
         this._actionPointsCurrentFunc(param1);
         this._movementPointsCurrentFunc(param1);
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
         this._criticalHitWeaponFunc(param1);
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
            _loc4_ = new CharacterSpellModification();
            _loc4_.deserialize(param1);
            this.spellModifications.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterCharacteristicsInformations(param1);
    }

    public void deserializeAsyncAs_CharacterCharacteristicsInformations(FuncTree param1) {
         param1.addChild(this._experienceFunc);
         param1.addChild(this._experienceLevelFloorFunc);
         param1.addChild(this._experienceNextLevelFloorFunc);
         param1.addChild(this._experienceBonusLimitFunc);
         param1.addChild(this._kamasFunc);
         param1.addChild(this._statsPointsFunc);
         param1.addChild(this._additionnalPointsFunc);
         param1.addChild(this._spellsPointsFunc);
         this._alignmentInfostree = param1.addChild(this._alignmentInfostreeFunc);
         param1.addChild(this._lifePointsFunc);
         param1.addChild(this._maxLifePointsFunc);
         param1.addChild(this._energyPointsFunc);
         param1.addChild(this._maxEnergyPointsFunc);
         param1.addChild(this._actionPointsCurrentFunc);
         param1.addChild(this._movementPointsCurrentFunc);
         this._initiativetree = param1.addChild(this._initiativetreeFunc);
         this._prospectingtree = param1.addChild(this._prospectingtreeFunc);
         this._actionPointstree = param1.addChild(this._actionPointstreeFunc);
         this._movementPointstree = param1.addChild(this._movementPointstreeFunc);
         this._strengthtree = param1.addChild(this._strengthtreeFunc);
         this._vitalitytree = param1.addChild(this._vitalitytreeFunc);
         this._wisdomtree = param1.addChild(this._wisdomtreeFunc);
         this._chancetree = param1.addChild(this._chancetreeFunc);
         this._agilitytree = param1.addChild(this._agilitytreeFunc);
         this._intelligencetree = param1.addChild(this._intelligencetreeFunc);
         this._rangetree = param1.addChild(this._rangetreeFunc);
         this._summonableCreaturesBoosttree = param1.addChild(this._summonableCreaturesBoosttreeFunc);
         this._reflecttree = param1.addChild(this._reflecttreeFunc);
         this._criticalHittree = param1.addChild(this._criticalHittreeFunc);
         param1.addChild(this._criticalHitWeaponFunc);
         this._criticalMisstree = param1.addChild(this._criticalMisstreeFunc);
         this._healBonustree = param1.addChild(this._healBonustreeFunc);
         this._allDamagesBonustree = param1.addChild(this._allDamagesBonustreeFunc);
         this._weaponDamagesBonusPercenttree = param1.addChild(this._weaponDamagesBonusPercenttreeFunc);
         this._damagesBonusPercenttree = param1.addChild(this._damagesBonusPercenttreeFunc);
         this._trapBonustree = param1.addChild(this._trapBonustreeFunc);
         this._trapBonusPercenttree = param1.addChild(this._trapBonusPercenttreeFunc);
         this._glyphBonusPercenttree = param1.addChild(this._glyphBonusPercenttreeFunc);
         this._runeBonusPercenttree = param1.addChild(this._runeBonusPercenttreeFunc);
         this._permanentDamagePercenttree = param1.addChild(this._permanentDamagePercenttreeFunc);
         this._tackleBlocktree = param1.addChild(this._tackleBlocktreeFunc);
         this._tackleEvadetree = param1.addChild(this._tackleEvadetreeFunc);
         this._PAAttacktree = param1.addChild(this._PAAttacktreeFunc);
         this._PMAttacktree = param1.addChild(this._PMAttacktreeFunc);
         this._pushDamageBonustree = param1.addChild(this._pushDamageBonustreeFunc);
         this._criticalDamageBonustree = param1.addChild(this._criticalDamageBonustreeFunc);
         this._neutralDamageBonustree = param1.addChild(this._neutralDamageBonustreeFunc);
         this._earthDamageBonustree = param1.addChild(this._earthDamageBonustreeFunc);
         this._waterDamageBonustree = param1.addChild(this._waterDamageBonustreeFunc);
         this._airDamageBonustree = param1.addChild(this._airDamageBonustreeFunc);
         this._fireDamageBonustree = param1.addChild(this._fireDamageBonustreeFunc);
         this._dodgePALostProbabilitytree = param1.addChild(this._dodgePALostProbabilitytreeFunc);
         this._dodgePMLostProbabilitytree = param1.addChild(this._dodgePMLostProbabilitytreeFunc);
         this._neutralElementResistPercenttree = param1.addChild(this._neutralElementResistPercenttreeFunc);
         this._earthElementResistPercenttree = param1.addChild(this._earthElementResistPercenttreeFunc);
         this._waterElementResistPercenttree = param1.addChild(this._waterElementResistPercenttreeFunc);
         this._airElementResistPercenttree = param1.addChild(this._airElementResistPercenttreeFunc);
         this._fireElementResistPercenttree = param1.addChild(this._fireElementResistPercenttreeFunc);
         this._neutralElementReductiontree = param1.addChild(this._neutralElementReductiontreeFunc);
         this._earthElementReductiontree = param1.addChild(this._earthElementReductiontreeFunc);
         this._waterElementReductiontree = param1.addChild(this._waterElementReductiontreeFunc);
         this._airElementReductiontree = param1.addChild(this._airElementReductiontreeFunc);
         this._fireElementReductiontree = param1.addChild(this._fireElementReductiontreeFunc);
         this._pushDamageReductiontree = param1.addChild(this._pushDamageReductiontreeFunc);
         this._criticalDamageReductiontree = param1.addChild(this._criticalDamageReductiontreeFunc);
         this._pvpNeutralElementResistPercenttree = param1.addChild(this._pvpNeutralElementResistPercenttreeFunc);
         this._pvpEarthElementResistPercenttree = param1.addChild(this._pvpEarthElementResistPercenttreeFunc);
         this._pvpWaterElementResistPercenttree = param1.addChild(this._pvpWaterElementResistPercenttreeFunc);
         this._pvpAirElementResistPercenttree = param1.addChild(this._pvpAirElementResistPercenttreeFunc);
         this._pvpFireElementResistPercenttree = param1.addChild(this._pvpFireElementResistPercenttreeFunc);
         this._pvpNeutralElementReductiontree = param1.addChild(this._pvpNeutralElementReductiontreeFunc);
         this._pvpEarthElementReductiontree = param1.addChild(this._pvpEarthElementReductiontreeFunc);
         this._pvpWaterElementReductiontree = param1.addChild(this._pvpWaterElementReductiontreeFunc);
         this._pvpAirElementReductiontree = param1.addChild(this._pvpAirElementReductiontreeFunc);
         this._pvpFireElementReductiontree = param1.addChild(this._pvpFireElementReductiontreeFunc);
         this._meleeDamageDonePercenttree = param1.addChild(this._meleeDamageDonePercenttreeFunc);
         this._meleeDamageReceivedPercenttree = param1.addChild(this._meleeDamageReceivedPercenttreeFunc);
         this._rangedDamageDonePercenttree = param1.addChild(this._rangedDamageDonePercenttreeFunc);
         this._rangedDamageReceivedPercenttree = param1.addChild(this._rangedDamageReceivedPercenttreeFunc);
         this._weaponDamageDonePercenttree = param1.addChild(this._weaponDamageDonePercenttreeFunc);
         this._weaponDamageReceivedPercenttree = param1.addChild(this._weaponDamageReceivedPercenttreeFunc);
         this._spellDamageDonePercenttree = param1.addChild(this._spellDamageDonePercenttreeFunc);
         this._spellDamageReceivedPercenttree = param1.addChild(this._spellDamageReceivedPercenttreeFunc);
         this._spellModificationstree = param1.addChild(this._spellModificationstreeFunc);
         param1.addChild(this._probationTimeFunc);
    }

    private void _experienceFunc(ICustomDataInput param1) {
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element of CharacterCharacteristicsInformations.experience.");
    }

    private void _experienceLevelFloorFunc(ICustomDataInput param1) {
         this.experienceLevelFloor = param1.readVarUhLong();
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceLevelFloor + ") on element of CharacterCharacteristicsInformations.experienceLevelFloor.");
    }

    private void _experienceNextLevelFloorFunc(ICustomDataInput param1) {
         this.experienceNextLevelFloor = param1.readVarUhLong();
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceNextLevelFloor + ") on element of CharacterCharacteristicsInformations.experienceNextLevelFloor.");
    }

    private void _experienceBonusLimitFunc(ICustomDataInput param1) {
         this.experienceBonusLimit = param1.readVarUhLong();
         if(this.experienceBonusLimit < 0 || this.experienceBonusLimit > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceBonusLimit + ") on element of CharacterCharacteristicsInformations.experienceBonusLimit.");
    }

    private void _kamasFunc(ICustomDataInput param1) {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kamas + ") on element of CharacterCharacteristicsInformations.kamas.");
    }

    private void _statsPointsFunc(ICustomDataInput param1) {
         this.statsPoints = param1.readVarUhShort();
         if(this.statsPoints < 0)
            throw new Exception("Forbidden value (" + this.statsPoints + ") on element of CharacterCharacteristicsInformations.statsPoints.");
    }

    private void _additionnalPointsFunc(ICustomDataInput param1) {
         this.additionnalPoints = param1.readVarUhShort();
         if(this.additionnalPoints < 0)
            throw new Exception("Forbidden value (" + this.additionnalPoints + ") on element of CharacterCharacteristicsInformations.additionnalPoints.");
    }

    private void _spellsPointsFunc(ICustomDataInput param1) {
         this.spellsPoints = param1.readVarUhShort();
         if(this.spellsPoints < 0)
            throw new Exception("Forbidden value (" + this.spellsPoints + ") on element of CharacterCharacteristicsInformations.spellsPoints.");
    }

    private void _alignmentInfostreeFunc(ICustomDataInput param1) {
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.alignmentInfos.deserializeAsync(this._alignmentInfostree);
    }

    private void _lifePointsFunc(ICustomDataInput param1) {
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of CharacterCharacteristicsInformations.lifePoints.");
    }

    private void _maxLifePointsFunc(ICustomDataInput param1) {
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of CharacterCharacteristicsInformations.maxLifePoints.");
    }

    private void _energyPointsFunc(ICustomDataInput param1) {
         this.energyPoints = param1.readVarUhShort();
         if(this.energyPoints < 0)
            throw new Exception("Forbidden value (" + this.energyPoints + ") on element of CharacterCharacteristicsInformations.energyPoints.");
    }

    private void _maxEnergyPointsFunc(ICustomDataInput param1) {
         this.maxEnergyPoints = param1.readVarUhShort();
         if(this.maxEnergyPoints < 0)
            throw new Exception("Forbidden value (" + this.maxEnergyPoints + ") on element of CharacterCharacteristicsInformations.maxEnergyPoints.");
    }

    private void _actionPointsCurrentFunc(ICustomDataInput param1) {
         this.actionPointsCurrent = param1.readVarShort();
    }

    private void _movementPointsCurrentFunc(ICustomDataInput param1) {
         this.movementPointsCurrent = param1.readVarShort();
    }

    private void _initiativetreeFunc(ICustomDataInput param1) {
         this.initiative = new CharacterBaseCharacteristic();
         this.initiative.deserializeAsync(this._initiativetree);
    }

    private void _prospectingtreeFunc(ICustomDataInput param1) {
         this.prospecting = new CharacterBaseCharacteristic();
         this.prospecting.deserializeAsync(this._prospectingtree);
    }

    private void _actionPointstreeFunc(ICustomDataInput param1) {
         this.actionPoints = new CharacterBaseCharacteristic();
         this.actionPoints.deserializeAsync(this._actionPointstree);
    }

    private void _movementPointstreeFunc(ICustomDataInput param1) {
         this.movementPoints = new CharacterBaseCharacteristic();
         this.movementPoints.deserializeAsync(this._movementPointstree);
    }

    private void _strengthtreeFunc(ICustomDataInput param1) {
         this.strength = new CharacterBaseCharacteristic();
         this.strength.deserializeAsync(this._strengthtree);
    }

    private void _vitalitytreeFunc(ICustomDataInput param1) {
         this.vitality = new CharacterBaseCharacteristic();
         this.vitality.deserializeAsync(this._vitalitytree);
    }

    private void _wisdomtreeFunc(ICustomDataInput param1) {
         this.wisdom = new CharacterBaseCharacteristic();
         this.wisdom.deserializeAsync(this._wisdomtree);
    }

    private void _chancetreeFunc(ICustomDataInput param1) {
         this.chance = new CharacterBaseCharacteristic();
         this.chance.deserializeAsync(this._chancetree);
    }

    private void _agilitytreeFunc(ICustomDataInput param1) {
         this.agility = new CharacterBaseCharacteristic();
         this.agility.deserializeAsync(this._agilitytree);
    }

    private void _intelligencetreeFunc(ICustomDataInput param1) {
         this.intelligence = new CharacterBaseCharacteristic();
         this.intelligence.deserializeAsync(this._intelligencetree);
    }

    private void _rangetreeFunc(ICustomDataInput param1) {
         this.range = new CharacterBaseCharacteristic();
         this.range.deserializeAsync(this._rangetree);
    }

    private void _summonableCreaturesBoosttreeFunc(ICustomDataInput param1) {
         this.summonableCreaturesBoost = new CharacterBaseCharacteristic();
         this.summonableCreaturesBoost.deserializeAsync(this._summonableCreaturesBoosttree);
    }

    private void _reflecttreeFunc(ICustomDataInput param1) {
         this.reflect = new CharacterBaseCharacteristic();
         this.reflect.deserializeAsync(this._reflecttree);
    }

    private void _criticalHittreeFunc(ICustomDataInput param1) {
         this.criticalHit = new CharacterBaseCharacteristic();
         this.criticalHit.deserializeAsync(this._criticalHittree);
    }

    private void _criticalHitWeaponFunc(ICustomDataInput param1) {
         this.criticalHitWeapon = param1.readVarUhShort();
         if(this.criticalHitWeapon < 0)
            throw new Exception("Forbidden value (" + this.criticalHitWeapon + ") on element of CharacterCharacteristicsInformations.criticalHitWeapon.");
    }

    private void _criticalMisstreeFunc(ICustomDataInput param1) {
         this.criticalMiss = new CharacterBaseCharacteristic();
         this.criticalMiss.deserializeAsync(this._criticalMisstree);
    }

    private void _healBonustreeFunc(ICustomDataInput param1) {
         this.healBonus = new CharacterBaseCharacteristic();
         this.healBonus.deserializeAsync(this._healBonustree);
    }

    private void _allDamagesBonustreeFunc(ICustomDataInput param1) {
         this.allDamagesBonus = new CharacterBaseCharacteristic();
         this.allDamagesBonus.deserializeAsync(this._allDamagesBonustree);
    }

    private void _weaponDamagesBonusPercenttreeFunc(ICustomDataInput param1) {
         this.weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
         this.weaponDamagesBonusPercent.deserializeAsync(this._weaponDamagesBonusPercenttree);
    }

    private void _damagesBonusPercenttreeFunc(ICustomDataInput param1) {
         this.damagesBonusPercent = new CharacterBaseCharacteristic();
         this.damagesBonusPercent.deserializeAsync(this._damagesBonusPercenttree);
    }

    private void _trapBonustreeFunc(ICustomDataInput param1) {
         this.trapBonus = new CharacterBaseCharacteristic();
         this.trapBonus.deserializeAsync(this._trapBonustree);
    }

    private void _trapBonusPercenttreeFunc(ICustomDataInput param1) {
         this.trapBonusPercent = new CharacterBaseCharacteristic();
         this.trapBonusPercent.deserializeAsync(this._trapBonusPercenttree);
    }

    private void _glyphBonusPercenttreeFunc(ICustomDataInput param1) {
         this.glyphBonusPercent = new CharacterBaseCharacteristic();
         this.glyphBonusPercent.deserializeAsync(this._glyphBonusPercenttree);
    }

    private void _runeBonusPercenttreeFunc(ICustomDataInput param1) {
         this.runeBonusPercent = new CharacterBaseCharacteristic();
         this.runeBonusPercent.deserializeAsync(this._runeBonusPercenttree);
    }

    private void _permanentDamagePercenttreeFunc(ICustomDataInput param1) {
         this.permanentDamagePercent = new CharacterBaseCharacteristic();
         this.permanentDamagePercent.deserializeAsync(this._permanentDamagePercenttree);
    }

    private void _tackleBlocktreeFunc(ICustomDataInput param1) {
         this.tackleBlock = new CharacterBaseCharacteristic();
         this.tackleBlock.deserializeAsync(this._tackleBlocktree);
    }

    private void _tackleEvadetreeFunc(ICustomDataInput param1) {
         this.tackleEvade = new CharacterBaseCharacteristic();
         this.tackleEvade.deserializeAsync(this._tackleEvadetree);
    }

    private void _PAAttacktreeFunc(ICustomDataInput param1) {
         this.PAAttack = new CharacterBaseCharacteristic();
         this.PAAttack.deserializeAsync(this._PAAttacktree);
    }

    private void _PMAttacktreeFunc(ICustomDataInput param1) {
         this.PMAttack = new CharacterBaseCharacteristic();
         this.PMAttack.deserializeAsync(this._PMAttacktree);
    }

    private void _pushDamageBonustreeFunc(ICustomDataInput param1) {
         this.pushDamageBonus = new CharacterBaseCharacteristic();
         this.pushDamageBonus.deserializeAsync(this._pushDamageBonustree);
    }

    private void _criticalDamageBonustreeFunc(ICustomDataInput param1) {
         this.criticalDamageBonus = new CharacterBaseCharacteristic();
         this.criticalDamageBonus.deserializeAsync(this._criticalDamageBonustree);
    }

    private void _neutralDamageBonustreeFunc(ICustomDataInput param1) {
         this.neutralDamageBonus = new CharacterBaseCharacteristic();
         this.neutralDamageBonus.deserializeAsync(this._neutralDamageBonustree);
    }

    private void _earthDamageBonustreeFunc(ICustomDataInput param1) {
         this.earthDamageBonus = new CharacterBaseCharacteristic();
         this.earthDamageBonus.deserializeAsync(this._earthDamageBonustree);
    }

    private void _waterDamageBonustreeFunc(ICustomDataInput param1) {
         this.waterDamageBonus = new CharacterBaseCharacteristic();
         this.waterDamageBonus.deserializeAsync(this._waterDamageBonustree);
    }

    private void _airDamageBonustreeFunc(ICustomDataInput param1) {
         this.airDamageBonus = new CharacterBaseCharacteristic();
         this.airDamageBonus.deserializeAsync(this._airDamageBonustree);
    }

    private void _fireDamageBonustreeFunc(ICustomDataInput param1) {
         this.fireDamageBonus = new CharacterBaseCharacteristic();
         this.fireDamageBonus.deserializeAsync(this._fireDamageBonustree);
    }

    private void _dodgePALostProbabilitytreeFunc(ICustomDataInput param1) {
         this.dodgePALostProbability = new CharacterBaseCharacteristic();
         this.dodgePALostProbability.deserializeAsync(this._dodgePALostProbabilitytree);
    }

    private void _dodgePMLostProbabilitytreeFunc(ICustomDataInput param1) {
         this.dodgePMLostProbability = new CharacterBaseCharacteristic();
         this.dodgePMLostProbability.deserializeAsync(this._dodgePMLostProbabilitytree);
    }

    private void _neutralElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.neutralElementResistPercent = new CharacterBaseCharacteristic();
         this.neutralElementResistPercent.deserializeAsync(this._neutralElementResistPercenttree);
    }

    private void _earthElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.earthElementResistPercent = new CharacterBaseCharacteristic();
         this.earthElementResistPercent.deserializeAsync(this._earthElementResistPercenttree);
    }

    private void _waterElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.waterElementResistPercent = new CharacterBaseCharacteristic();
         this.waterElementResistPercent.deserializeAsync(this._waterElementResistPercenttree);
    }

    private void _airElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.airElementResistPercent = new CharacterBaseCharacteristic();
         this.airElementResistPercent.deserializeAsync(this._airElementResistPercenttree);
    }

    private void _fireElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.fireElementResistPercent = new CharacterBaseCharacteristic();
         this.fireElementResistPercent.deserializeAsync(this._fireElementResistPercenttree);
    }

    private void _neutralElementReductiontreeFunc(ICustomDataInput param1) {
         this.neutralElementReduction = new CharacterBaseCharacteristic();
         this.neutralElementReduction.deserializeAsync(this._neutralElementReductiontree);
    }

    private void _earthElementReductiontreeFunc(ICustomDataInput param1) {
         this.earthElementReduction = new CharacterBaseCharacteristic();
         this.earthElementReduction.deserializeAsync(this._earthElementReductiontree);
    }

    private void _waterElementReductiontreeFunc(ICustomDataInput param1) {
         this.waterElementReduction = new CharacterBaseCharacteristic();
         this.waterElementReduction.deserializeAsync(this._waterElementReductiontree);
    }

    private void _airElementReductiontreeFunc(ICustomDataInput param1) {
         this.airElementReduction = new CharacterBaseCharacteristic();
         this.airElementReduction.deserializeAsync(this._airElementReductiontree);
    }

    private void _fireElementReductiontreeFunc(ICustomDataInput param1) {
         this.fireElementReduction = new CharacterBaseCharacteristic();
         this.fireElementReduction.deserializeAsync(this._fireElementReductiontree);
    }

    private void _pushDamageReductiontreeFunc(ICustomDataInput param1) {
         this.pushDamageReduction = new CharacterBaseCharacteristic();
         this.pushDamageReduction.deserializeAsync(this._pushDamageReductiontree);
    }

    private void _criticalDamageReductiontreeFunc(ICustomDataInput param1) {
         this.criticalDamageReduction = new CharacterBaseCharacteristic();
         this.criticalDamageReduction.deserializeAsync(this._criticalDamageReductiontree);
    }

    private void _pvpNeutralElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpNeutralElementResistPercent.deserializeAsync(this._pvpNeutralElementResistPercenttree);
    }

    private void _pvpEarthElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpEarthElementResistPercent.deserializeAsync(this._pvpEarthElementResistPercenttree);
    }

    private void _pvpWaterElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpWaterElementResistPercent.deserializeAsync(this._pvpWaterElementResistPercenttree);
    }

    private void _pvpAirElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.pvpAirElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpAirElementResistPercent.deserializeAsync(this._pvpAirElementResistPercenttree);
    }

    private void _pvpFireElementResistPercenttreeFunc(ICustomDataInput param1) {
         this.pvpFireElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpFireElementResistPercent.deserializeAsync(this._pvpFireElementResistPercenttree);
    }

    private void _pvpNeutralElementReductiontreeFunc(ICustomDataInput param1) {
         this.pvpNeutralElementReduction = new CharacterBaseCharacteristic();
         this.pvpNeutralElementReduction.deserializeAsync(this._pvpNeutralElementReductiontree);
    }

    private void _pvpEarthElementReductiontreeFunc(ICustomDataInput param1) {
         this.pvpEarthElementReduction = new CharacterBaseCharacteristic();
         this.pvpEarthElementReduction.deserializeAsync(this._pvpEarthElementReductiontree);
    }

    private void _pvpWaterElementReductiontreeFunc(ICustomDataInput param1) {
         this.pvpWaterElementReduction = new CharacterBaseCharacteristic();
         this.pvpWaterElementReduction.deserializeAsync(this._pvpWaterElementReductiontree);
    }

    private void _pvpAirElementReductiontreeFunc(ICustomDataInput param1) {
         this.pvpAirElementReduction = new CharacterBaseCharacteristic();
         this.pvpAirElementReduction.deserializeAsync(this._pvpAirElementReductiontree);
    }

    private void _pvpFireElementReductiontreeFunc(ICustomDataInput param1) {
         this.pvpFireElementReduction = new CharacterBaseCharacteristic();
         this.pvpFireElementReduction.deserializeAsync(this._pvpFireElementReductiontree);
    }

    private void _meleeDamageDonePercenttreeFunc(ICustomDataInput param1) {
         this.meleeDamageDonePercent = new CharacterBaseCharacteristic();
         this.meleeDamageDonePercent.deserializeAsync(this._meleeDamageDonePercenttree);
    }

    private void _meleeDamageReceivedPercenttreeFunc(ICustomDataInput param1) {
         this.meleeDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.meleeDamageReceivedPercent.deserializeAsync(this._meleeDamageReceivedPercenttree);
    }

    private void _rangedDamageDonePercenttreeFunc(ICustomDataInput param1) {
         this.rangedDamageDonePercent = new CharacterBaseCharacteristic();
         this.rangedDamageDonePercent.deserializeAsync(this._rangedDamageDonePercenttree);
    }

    private void _rangedDamageReceivedPercenttreeFunc(ICustomDataInput param1) {
         this.rangedDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.rangedDamageReceivedPercent.deserializeAsync(this._rangedDamageReceivedPercenttree);
    }

    private void _weaponDamageDonePercenttreeFunc(ICustomDataInput param1) {
         this.weaponDamageDonePercent = new CharacterBaseCharacteristic();
         this.weaponDamageDonePercent.deserializeAsync(this._weaponDamageDonePercenttree);
    }

    private void _weaponDamageReceivedPercenttreeFunc(ICustomDataInput param1) {
         this.weaponDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.weaponDamageReceivedPercent.deserializeAsync(this._weaponDamageReceivedPercenttree);
    }

    private void _spellDamageDonePercenttreeFunc(ICustomDataInput param1) {
         this.spellDamageDonePercent = new CharacterBaseCharacteristic();
         this.spellDamageDonePercent.deserializeAsync(this._spellDamageDonePercenttree);
    }

    private void _spellDamageReceivedPercenttreeFunc(ICustomDataInput param1) {
         this.spellDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.spellDamageReceivedPercent.deserializeAsync(this._spellDamageReceivedPercenttree);
    }

    private void _spellModificationstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._spellModificationstree.addChild(this._spellModificationsFunc);
            _loc3_++;
    }

    private void _spellModificationsFunc(ICustomDataInput param1) {
         CharacterSpellModification _loc2_ = new CharacterSpellModification();
         _loc2_.deserialize(param1);
         this.spellModifications.push(_loc2_);
    }

    private void _probationTimeFunc(ICustomDataInput param1) {
         this.probationTime = param1.readInt();
         if(this.probationTime < 0)
            throw new Exception("Forbidden value (" + this.probationTime + ") on element of CharacterCharacteristicsInformations.probationTime.");
    }

}