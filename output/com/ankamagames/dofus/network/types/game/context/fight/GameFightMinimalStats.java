package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
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

public class GameFightMinimalStats extends Object implements INetworkType {

    private int protocolId = 31;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int baseMaxLifePoints = 0;
    private int permanentDamagePercent = 0;
    private int shieldPoints = 0;
    private int actionPoints = 0;
    private int maxActionPoints = 0;
    private int movementPoints = 0;
    private int maxMovementPoints = 0;
    private Number summoner = 0;
    private boolean summoned = false;
    private int neutralElementResistPercent = 0;
    private int earthElementResistPercent = 0;
    private int waterElementResistPercent = 0;
    private int airElementResistPercent = 0;
    private int fireElementResistPercent = 0;
    private int neutralElementReduction = 0;
    private int earthElementReduction = 0;
    private int waterElementReduction = 0;
    private int airElementReduction = 0;
    private int fireElementReduction = 0;
    private int criticalDamageFixedResist = 0;
    private int pushDamageFixedResist = 0;
    private int pvpNeutralElementResistPercent = 0;
    private int pvpEarthElementResistPercent = 0;
    private int pvpWaterElementResistPercent = 0;
    private int pvpAirElementResistPercent = 0;
    private int pvpFireElementResistPercent = 0;
    private int pvpNeutralElementReduction = 0;
    private int pvpEarthElementReduction = 0;
    private int pvpWaterElementReduction = 0;
    private int pvpAirElementReduction = 0;
    private int pvpFireElementReduction = 0;
    private int dodgePALostProbability = 0;
    private int dodgePMLostProbability = 0;
    private int tackleBlock = 0;
    private int tackleEvade = 0;
    private int fixedDamageReflection = 0;
    private int invisibilityState = 0;
    private int meleeDamageReceivedPercent = 0;
    private int rangedDamageReceivedPercent = 0;
    private int weaponDamageReceivedPercent = 0;
    private int spellDamageReceivedPercent = 0;


    public int getTypeId() {
         return 31;
    }

    public GameFightMinimalStats initGameFightMinimalStats(int param1,int  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8,int  param9,Number  param10,boolean  param11,int  param12,int  param13,int  param14,int  param15,int  param16,int  param17,int  param18,int  param19,int  param20,int  param21,int  param22,int  param23,int  param24,int  param25,int  param26,int  param27,int  param28,int  param29,int  param30,int  param31,int  param32,int  param33,int  param34,int  param35,int  param36,int  param37,int  param38,int  param39,int  param40,int  param41,int  param42,int  param43) {
         this.lifePoints = param1;
         this.maxLifePoints = param2;
         this.baseMaxLifePoints = param3;
         this.permanentDamagePercent = param4;
         this.shieldPoints = param5;
         this.actionPoints = param6;
         this.maxActionPoints = param7;
         this.movementPoints = param8;
         this.maxMovementPoints = param9;
         this.summoner = param10;
         this.summoned = param11;
         this.neutralElementResistPercent = param12;
         this.earthElementResistPercent = param13;
         this.waterElementResistPercent = param14;
         this.airElementResistPercent = param15;
         this.fireElementResistPercent = param16;
         this.neutralElementReduction = param17;
         this.earthElementReduction = param18;
         this.waterElementReduction = param19;
         this.airElementReduction = param20;
         this.fireElementReduction = param21;
         this.criticalDamageFixedResist = param22;
         this.pushDamageFixedResist = param23;
         this.pvpNeutralElementResistPercent = param24;
         this.pvpEarthElementResistPercent = param25;
         this.pvpWaterElementResistPercent = param26;
         this.pvpAirElementResistPercent = param27;
         this.pvpFireElementResistPercent = param28;
         this.pvpNeutralElementReduction = param29;
         this.pvpEarthElementReduction = param30;
         this.pvpWaterElementReduction = param31;
         this.pvpAirElementReduction = param32;
         this.pvpFireElementReduction = param33;
         this.dodgePALostProbability = param34;
         this.dodgePMLostProbability = param35;
         this.tackleBlock = param36;
         this.tackleEvade = param37;
         this.fixedDamageReflection = param38;
         this.invisibilityState = param39;
         this.meleeDamageReceivedPercent = param40;
         this.rangedDamageReceivedPercent = param41;
         this.weaponDamageReceivedPercent = param42;
         this.spellDamageReceivedPercent = param43;
         return this;
    }

    public void reset() {
         this.lifePoints = 0;
         this.maxLifePoints = 0;
         this.baseMaxLifePoints = 0;
         this.permanentDamagePercent = 0;
         this.shieldPoints = 0;
         this.actionPoints = 0;
         this.maxActionPoints = 0;
         this.movementPoints = 0;
         this.maxMovementPoints = 0;
         this.summoner = 0;
         this.summoned = false;
         this.neutralElementResistPercent = 0;
         this.earthElementResistPercent = 0;
         this.waterElementResistPercent = 0;
         this.airElementResistPercent = 0;
         this.fireElementResistPercent = 0;
         this.neutralElementReduction = 0;
         this.earthElementReduction = 0;
         this.waterElementReduction = 0;
         this.airElementReduction = 0;
         this.fireElementReduction = 0;
         this.criticalDamageFixedResist = 0;
         this.pushDamageFixedResist = 0;
         this.pvpNeutralElementResistPercent = 0;
         this.pvpEarthElementResistPercent = 0;
         this.pvpWaterElementResistPercent = 0;
         this.pvpAirElementResistPercent = 0;
         this.pvpFireElementResistPercent = 0;
         this.pvpNeutralElementReduction = 0;
         this.pvpEarthElementReduction = 0;
         this.pvpWaterElementReduction = 0;
         this.pvpAirElementReduction = 0;
         this.pvpFireElementReduction = 0;
         this.dodgePALostProbability = 0;
         this.dodgePMLostProbability = 0;
         this.tackleBlock = 0;
         this.tackleEvade = 0;
         this.fixedDamageReflection = 0;
         this.invisibilityState = 0;
         this.meleeDamageReceivedPercent = 0;
         this.rangedDamageReceivedPercent = 0;
         this.weaponDamageReceivedPercent = 0;
         this.spellDamageReceivedPercent = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightMinimalStats(param1);
    }

    public void serializeAs_GameFightMinimalStats(ICustomDataOutput param1) {
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
         if(this.baseMaxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.baseMaxLifePoints + ") on element baseMaxLifePoints.");
         }
         param1.writeVarInt(this.baseMaxLifePoints);
         if(this.permanentDamagePercent < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamagePercent + ") on element permanentDamagePercent.");
         }
         param1.writeVarInt(this.permanentDamagePercent);
         if(this.shieldPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.shieldPoints + ") on element shieldPoints.");
         }
         param1.writeVarInt(this.shieldPoints);
         param1.writeVarShort(this.actionPoints);
         param1.writeVarShort(this.maxActionPoints);
         param1.writeVarShort(this.movementPoints);
         param1.writeVarShort(this.maxMovementPoints);
         if(this.summoner < -9.007199254740992E15 || this.summoner > 9.007199254740992E15)
         {
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
         if(this.dodgePALostProbability < 0)
         {
            throw new Exception("Forbidden value (" + this.dodgePALostProbability + ") on element dodgePALostProbability.");
         }
         param1.writeVarShort(this.dodgePALostProbability);
         if(this.dodgePMLostProbability < 0)
         {
            throw new Exception("Forbidden value (" + this.dodgePMLostProbability + ") on element dodgePMLostProbability.");
         }
         param1.writeVarShort(this.dodgePMLostProbability);
         param1.writeVarShort(this.tackleBlock);
         param1.writeVarShort(this.tackleEvade);
         param1.writeVarShort(this.fixedDamageReflection);
         param1.writeByte(this.invisibilityState);
         if(this.meleeDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.meleeDamageReceivedPercent + ") on element meleeDamageReceivedPercent.");
         }
         param1.writeVarShort(this.meleeDamageReceivedPercent);
         if(this.rangedDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.rangedDamageReceivedPercent + ") on element rangedDamageReceivedPercent.");
         }
         param1.writeVarShort(this.rangedDamageReceivedPercent);
         if(this.weaponDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.weaponDamageReceivedPercent + ") on element weaponDamageReceivedPercent.");
         }
         param1.writeVarShort(this.weaponDamageReceivedPercent);
         if(this.spellDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.spellDamageReceivedPercent + ") on element spellDamageReceivedPercent.");
         }
         param1.writeVarShort(this.spellDamageReceivedPercent);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightMinimalStats(param1);
    }

    public void deserializeAs_GameFightMinimalStats(ICustomDataInput param1) {
         this._lifePointsFunc(param1);
         this._maxLifePointsFunc(param1);
         this._baseMaxLifePointsFunc(param1);
         this._permanentDamagePercentFunc(param1);
         this._shieldPointsFunc(param1);
         this._actionPointsFunc(param1);
         this._maxActionPointsFunc(param1);
         this._movementPointsFunc(param1);
         this._maxMovementPointsFunc(param1);
         this._summonerFunc(param1);
         this._summonedFunc(param1);
         this._neutralElementResistPercentFunc(param1);
         this._earthElementResistPercentFunc(param1);
         this._waterElementResistPercentFunc(param1);
         this._airElementResistPercentFunc(param1);
         this._fireElementResistPercentFunc(param1);
         this._neutralElementReductionFunc(param1);
         this._earthElementReductionFunc(param1);
         this._waterElementReductionFunc(param1);
         this._airElementReductionFunc(param1);
         this._fireElementReductionFunc(param1);
         this._criticalDamageFixedResistFunc(param1);
         this._pushDamageFixedResistFunc(param1);
         this._pvpNeutralElementResistPercentFunc(param1);
         this._pvpEarthElementResistPercentFunc(param1);
         this._pvpWaterElementResistPercentFunc(param1);
         this._pvpAirElementResistPercentFunc(param1);
         this._pvpFireElementResistPercentFunc(param1);
         this._pvpNeutralElementReductionFunc(param1);
         this._pvpEarthElementReductionFunc(param1);
         this._pvpWaterElementReductionFunc(param1);
         this._pvpAirElementReductionFunc(param1);
         this._pvpFireElementReductionFunc(param1);
         this._dodgePALostProbabilityFunc(param1);
         this._dodgePMLostProbabilityFunc(param1);
         this._tackleBlockFunc(param1);
         this._tackleEvadeFunc(param1);
         this._fixedDamageReflectionFunc(param1);
         this._invisibilityStateFunc(param1);
         this._meleeDamageReceivedPercentFunc(param1);
         this._rangedDamageReceivedPercentFunc(param1);
         this._weaponDamageReceivedPercentFunc(param1);
         this._spellDamageReceivedPercentFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightMinimalStats(param1);
    }

    public void deserializeAsyncAs_GameFightMinimalStats(FuncTree param1) {
         param1.addChild(this._lifePointsFunc);
         param1.addChild(this._maxLifePointsFunc);
         param1.addChild(this._baseMaxLifePointsFunc);
         param1.addChild(this._permanentDamagePercentFunc);
         param1.addChild(this._shieldPointsFunc);
         param1.addChild(this._actionPointsFunc);
         param1.addChild(this._maxActionPointsFunc);
         param1.addChild(this._movementPointsFunc);
         param1.addChild(this._maxMovementPointsFunc);
         param1.addChild(this._summonerFunc);
         param1.addChild(this._summonedFunc);
         param1.addChild(this._neutralElementResistPercentFunc);
         param1.addChild(this._earthElementResistPercentFunc);
         param1.addChild(this._waterElementResistPercentFunc);
         param1.addChild(this._airElementResistPercentFunc);
         param1.addChild(this._fireElementResistPercentFunc);
         param1.addChild(this._neutralElementReductionFunc);
         param1.addChild(this._earthElementReductionFunc);
         param1.addChild(this._waterElementReductionFunc);
         param1.addChild(this._airElementReductionFunc);
         param1.addChild(this._fireElementReductionFunc);
         param1.addChild(this._criticalDamageFixedResistFunc);
         param1.addChild(this._pushDamageFixedResistFunc);
         param1.addChild(this._pvpNeutralElementResistPercentFunc);
         param1.addChild(this._pvpEarthElementResistPercentFunc);
         param1.addChild(this._pvpWaterElementResistPercentFunc);
         param1.addChild(this._pvpAirElementResistPercentFunc);
         param1.addChild(this._pvpFireElementResistPercentFunc);
         param1.addChild(this._pvpNeutralElementReductionFunc);
         param1.addChild(this._pvpEarthElementReductionFunc);
         param1.addChild(this._pvpWaterElementReductionFunc);
         param1.addChild(this._pvpAirElementReductionFunc);
         param1.addChild(this._pvpFireElementReductionFunc);
         param1.addChild(this._dodgePALostProbabilityFunc);
         param1.addChild(this._dodgePMLostProbabilityFunc);
         param1.addChild(this._tackleBlockFunc);
         param1.addChild(this._tackleEvadeFunc);
         param1.addChild(this._fixedDamageReflectionFunc);
         param1.addChild(this._invisibilityStateFunc);
         param1.addChild(this._meleeDamageReceivedPercentFunc);
         param1.addChild(this._rangedDamageReceivedPercentFunc);
         param1.addChild(this._weaponDamageReceivedPercentFunc);
         param1.addChild(this._spellDamageReceivedPercentFunc);
    }

    private void _lifePointsFunc(ICustomDataInput param1) {
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of GameFightMinimalStats.lifePoints.");
         }
    }

    private void _maxLifePointsFunc(ICustomDataInput param1) {
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of GameFightMinimalStats.maxLifePoints.");
         }
    }

    private void _baseMaxLifePointsFunc(ICustomDataInput param1) {
         this.baseMaxLifePoints = param1.readVarUhInt();
         if(this.baseMaxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.baseMaxLifePoints + ") on element of GameFightMinimalStats.baseMaxLifePoints.");
         }
    }

    private void _permanentDamagePercentFunc(ICustomDataInput param1) {
         this.permanentDamagePercent = param1.readVarUhInt();
         if(this.permanentDamagePercent < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamagePercent + ") on element of GameFightMinimalStats.permanentDamagePercent.");
         }
    }

    private void _shieldPointsFunc(ICustomDataInput param1) {
         this.shieldPoints = param1.readVarUhInt();
         if(this.shieldPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.shieldPoints + ") on element of GameFightMinimalStats.shieldPoints.");
         }
    }

    private void _actionPointsFunc(ICustomDataInput param1) {
         this.actionPoints = param1.readVarShort();
    }

    private void _maxActionPointsFunc(ICustomDataInput param1) {
         this.maxActionPoints = param1.readVarShort();
    }

    private void _movementPointsFunc(ICustomDataInput param1) {
         this.movementPoints = param1.readVarShort();
    }

    private void _maxMovementPointsFunc(ICustomDataInput param1) {
         this.maxMovementPoints = param1.readVarShort();
    }

    private void _summonerFunc(ICustomDataInput param1) {
         this.summoner = param1.readDouble();
         if(this.summoner < -9.007199254740992E15 || this.summoner > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.summoner + ") on element of GameFightMinimalStats.summoner.");
         }
    }

    private void _summonedFunc(ICustomDataInput param1) {
         this.summoned = param1.readBoolean();
    }

    private void _neutralElementResistPercentFunc(ICustomDataInput param1) {
         this.neutralElementResistPercent = param1.readVarShort();
    }

    private void _earthElementResistPercentFunc(ICustomDataInput param1) {
         this.earthElementResistPercent = param1.readVarShort();
    }

    private void _waterElementResistPercentFunc(ICustomDataInput param1) {
         this.waterElementResistPercent = param1.readVarShort();
    }

    private void _airElementResistPercentFunc(ICustomDataInput param1) {
         this.airElementResistPercent = param1.readVarShort();
    }

    private void _fireElementResistPercentFunc(ICustomDataInput param1) {
         this.fireElementResistPercent = param1.readVarShort();
    }

    private void _neutralElementReductionFunc(ICustomDataInput param1) {
         this.neutralElementReduction = param1.readVarShort();
    }

    private void _earthElementReductionFunc(ICustomDataInput param1) {
         this.earthElementReduction = param1.readVarShort();
    }

    private void _waterElementReductionFunc(ICustomDataInput param1) {
         this.waterElementReduction = param1.readVarShort();
    }

    private void _airElementReductionFunc(ICustomDataInput param1) {
         this.airElementReduction = param1.readVarShort();
    }

    private void _fireElementReductionFunc(ICustomDataInput param1) {
         this.fireElementReduction = param1.readVarShort();
    }

    private void _criticalDamageFixedResistFunc(ICustomDataInput param1) {
         this.criticalDamageFixedResist = param1.readVarShort();
    }

    private void _pushDamageFixedResistFunc(ICustomDataInput param1) {
         this.pushDamageFixedResist = param1.readVarShort();
    }

    private void _pvpNeutralElementResistPercentFunc(ICustomDataInput param1) {
         this.pvpNeutralElementResistPercent = param1.readVarShort();
    }

    private void _pvpEarthElementResistPercentFunc(ICustomDataInput param1) {
         this.pvpEarthElementResistPercent = param1.readVarShort();
    }

    private void _pvpWaterElementResistPercentFunc(ICustomDataInput param1) {
         this.pvpWaterElementResistPercent = param1.readVarShort();
    }

    private void _pvpAirElementResistPercentFunc(ICustomDataInput param1) {
         this.pvpAirElementResistPercent = param1.readVarShort();
    }

    private void _pvpFireElementResistPercentFunc(ICustomDataInput param1) {
         this.pvpFireElementResistPercent = param1.readVarShort();
    }

    private void _pvpNeutralElementReductionFunc(ICustomDataInput param1) {
         this.pvpNeutralElementReduction = param1.readVarShort();
    }

    private void _pvpEarthElementReductionFunc(ICustomDataInput param1) {
         this.pvpEarthElementReduction = param1.readVarShort();
    }

    private void _pvpWaterElementReductionFunc(ICustomDataInput param1) {
         this.pvpWaterElementReduction = param1.readVarShort();
    }

    private void _pvpAirElementReductionFunc(ICustomDataInput param1) {
         this.pvpAirElementReduction = param1.readVarShort();
    }

    private void _pvpFireElementReductionFunc(ICustomDataInput param1) {
         this.pvpFireElementReduction = param1.readVarShort();
    }

    private void _dodgePALostProbabilityFunc(ICustomDataInput param1) {
         this.dodgePALostProbability = param1.readVarUhShort();
         if(this.dodgePALostProbability < 0)
         {
            throw new Exception("Forbidden value (" + this.dodgePALostProbability + ") on element of GameFightMinimalStats.dodgePALostProbability.");
         }
    }

    private void _dodgePMLostProbabilityFunc(ICustomDataInput param1) {
         this.dodgePMLostProbability = param1.readVarUhShort();
         if(this.dodgePMLostProbability < 0)
         {
            throw new Exception("Forbidden value (" + this.dodgePMLostProbability + ") on element of GameFightMinimalStats.dodgePMLostProbability.");
         }
    }

    private void _tackleBlockFunc(ICustomDataInput param1) {
         this.tackleBlock = param1.readVarShort();
    }

    private void _tackleEvadeFunc(ICustomDataInput param1) {
         this.tackleEvade = param1.readVarShort();
    }

    private void _fixedDamageReflectionFunc(ICustomDataInput param1) {
         this.fixedDamageReflection = param1.readVarShort();
    }

    private void _invisibilityStateFunc(ICustomDataInput param1) {
         this.invisibilityState = param1.readByte();
         if(this.invisibilityState < 0)
         {
            throw new Exception("Forbidden value (" + this.invisibilityState + ") on element of GameFightMinimalStats.invisibilityState.");
         }
    }

    private void _meleeDamageReceivedPercentFunc(ICustomDataInput param1) {
         this.meleeDamageReceivedPercent = param1.readVarUhShort();
         if(this.meleeDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.meleeDamageReceivedPercent + ") on element of GameFightMinimalStats.meleeDamageReceivedPercent.");
         }
    }

    private void _rangedDamageReceivedPercentFunc(ICustomDataInput param1) {
         this.rangedDamageReceivedPercent = param1.readVarUhShort();
         if(this.rangedDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.rangedDamageReceivedPercent + ") on element of GameFightMinimalStats.rangedDamageReceivedPercent.");
         }
    }

    private void _weaponDamageReceivedPercentFunc(ICustomDataInput param1) {
         this.weaponDamageReceivedPercent = param1.readVarUhShort();
         if(this.weaponDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.weaponDamageReceivedPercent + ") on element of GameFightMinimalStats.weaponDamageReceivedPercent.");
         }
    }

    private void _spellDamageReceivedPercentFunc(ICustomDataInput param1) {
         this.spellDamageReceivedPercent = param1.readVarUhShort();
         if(this.spellDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.spellDamageReceivedPercent + ") on element of GameFightMinimalStats.spellDamageReceivedPercent.");
         }
    }

}