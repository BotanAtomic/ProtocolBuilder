package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightMinimalStatsPreparation extends GameFightMinimalStats implements INetworkType {

    private int protocolId = 360;
    private int initiative = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
         }
         param1.writeVarInt(this.initiative);
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
         }
         param1.writeVarInt(this.initiative);
         super.serializeAs_GameFightMinimalStats(param1);
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
         }
         param1.writeVarInt(this.initiative);
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
         this.initiative = param1.readVarUhInt();
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element of GameFightMinimalStatsPreparation.initiative.");
         }
    }

}