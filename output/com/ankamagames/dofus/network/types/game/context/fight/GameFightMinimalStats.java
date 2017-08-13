package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
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


    public void serialize(ICustomDataOutput param1) {
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
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of GameFightMinimalStats.lifePoints.");
         }
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of GameFightMinimalStats.maxLifePoints.");
         }
         this.baseMaxLifePoints = param1.readVarUhInt();
         if(this.baseMaxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.baseMaxLifePoints + ") on element of GameFightMinimalStats.baseMaxLifePoints.");
         }
         this.permanentDamagePercent = param1.readVarUhInt();
         if(this.permanentDamagePercent < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamagePercent + ") on element of GameFightMinimalStats.permanentDamagePercent.");
         }
         this.shieldPoints = param1.readVarUhInt();
         if(this.shieldPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.shieldPoints + ") on element of GameFightMinimalStats.shieldPoints.");
         }
         this.actionPoints = param1.readVarShort();
         this.maxActionPoints = param1.readVarShort();
         this.movementPoints = param1.readVarShort();
         this.maxMovementPoints = param1.readVarShort();
         this.summoner = param1.readDouble();
         if(this.summoner < -9.007199254740992E15 || this.summoner > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.summoner + ") on element of GameFightMinimalStats.summoner.");
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
         if(this.dodgePALostProbability < 0)
         {
            throw new Exception("Forbidden value (" + this.dodgePALostProbability + ") on element of GameFightMinimalStats.dodgePALostProbability.");
         }
         this.dodgePMLostProbability = param1.readVarUhShort();
         if(this.dodgePMLostProbability < 0)
         {
            throw new Exception("Forbidden value (" + this.dodgePMLostProbability + ") on element of GameFightMinimalStats.dodgePMLostProbability.");
         }
         this.tackleBlock = param1.readVarShort();
         this.tackleEvade = param1.readVarShort();
         this.fixedDamageReflection = param1.readVarShort();
         this.invisibilityState = param1.readByte();
         if(this.invisibilityState < 0)
         {
            throw new Exception("Forbidden value (" + this.invisibilityState + ") on element of GameFightMinimalStats.invisibilityState.");
         }
         this.meleeDamageReceivedPercent = param1.readVarUhShort();
         if(this.meleeDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.meleeDamageReceivedPercent + ") on element of GameFightMinimalStats.meleeDamageReceivedPercent.");
         }
         this.rangedDamageReceivedPercent = param1.readVarUhShort();
         if(this.rangedDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.rangedDamageReceivedPercent + ") on element of GameFightMinimalStats.rangedDamageReceivedPercent.");
         }
         this.weaponDamageReceivedPercent = param1.readVarUhShort();
         if(this.weaponDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.weaponDamageReceivedPercent + ") on element of GameFightMinimalStats.weaponDamageReceivedPercent.");
         }
         this.spellDamageReceivedPercent = param1.readVarUhShort();
         if(this.spellDamageReceivedPercent < 0)
         {
            throw new Exception("Forbidden value (" + this.spellDamageReceivedPercent + ") on element of GameFightMinimalStats.spellDamageReceivedPercent.");
         }
    }

}