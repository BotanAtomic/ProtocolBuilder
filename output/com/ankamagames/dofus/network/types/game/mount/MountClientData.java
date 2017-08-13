package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffectInteger;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MountClientData extends Object implements INetworkType {

    private int protocolId = 178;
    private Number id = 0;
    private int model = 0;
    private int[] ancestor;
    private int[] behaviors;
    private String name = "";
    private boolean sex = false;
    private int ownerId = 0;
    private Number experience = 0;
    private Number experienceForLevel = 0;
    private Number experienceForNextLevel = 0;
    private int level = 0;
    private boolean isRideable = false;
    private int maxPods = 0;
    private boolean isWild = false;
    private int stamina = 0;
    private int staminaMax = 0;
    private int maturity = 0;
    private int maturityForAdult = 0;
    private int energy = 0;
    private int energyMax = 0;
    private int serenity = 0;
    private int aggressivityMax = 0;
    private int serenityMax = 0;
    private int love = 0;
    private int loveMax = 0;
    private int fecondationTime = 0;
    private boolean isFecondationReady = false;
    private int boostLimiter = 0;
    private Number boostMax = 0;
    private int reproductionCount = 0;
    private int reproductionCountMax = 0;
    private int harnessGID = 0;
    private boolean useHarnessColors = false;
    private ObjectEffectInteger[] effectList;
    private FuncTree _ancestortree;
    private FuncTree _behaviorstree;
    private FuncTree _effectListtree;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.sex);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isRideable);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isWild);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.isFecondationReady);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,4,this.useHarnessColors);
         param1.writeByte(_loc2_);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.model < 0)
         {
            throw new Exception("Forbidden value (" + this.model + ") on element model.");
         }
         param1.writeVarInt(this.model);
         param1.writeShort(this.ancestor.length);
         int _loc3_ = 0;
         while(_loc3_ < this.ancestor.length)
         {
            if(this.ancestor[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.ancestor[_loc3_] + ") on element 3 (starting at 1) of ancestor.");
            }
            param1.writeInt(this.ancestor[_loc3_]);
            _loc3_++;
         }
         param1.writeShort(this.behaviors.length);
         int _loc4_ = 0;
         while(_loc4_ < this.behaviors.length)
         {
            if(this.behaviors[_loc4_] < 0)
            {
               throw new Exception("Forbidden value (" + this.behaviors[_loc4_] + ") on element 4 (starting at 1) of behaviors.");
            }
            param1.writeInt(this.behaviors[_loc4_]);
            _loc4_++;
         }
         param1.writeUTF(this.name);
         if(this.ownerId < 0)
         {
            throw new Exception("Forbidden value (" + this.ownerId + ") on element ownerId.");
         }
         param1.writeInt(this.ownerId);
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
         }
         param1.writeVarLong(this.experience);
         if(this.experienceForLevel < 0 || this.experienceForLevel > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForLevel + ") on element experienceForLevel.");
         }
         param1.writeVarLong(this.experienceForLevel);
         if(this.experienceForNextLevel < -9.007199254740992E15 || this.experienceForNextLevel > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForNextLevel + ") on element experienceForNextLevel.");
         }
         param1.writeDouble(this.experienceForNextLevel);
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         if(this.maxPods < 0)
         {
            throw new Exception("Forbidden value (" + this.maxPods + ") on element maxPods.");
         }
         param1.writeVarInt(this.maxPods);
         if(this.stamina < 0)
         {
            throw new Exception("Forbidden value (" + this.stamina + ") on element stamina.");
         }
         param1.writeVarInt(this.stamina);
         if(this.staminaMax < 0)
         {
            throw new Exception("Forbidden value (" + this.staminaMax + ") on element staminaMax.");
         }
         param1.writeVarInt(this.staminaMax);
         if(this.maturity < 0)
         {
            throw new Exception("Forbidden value (" + this.maturity + ") on element maturity.");
         }
         param1.writeVarInt(this.maturity);
         if(this.maturityForAdult < 0)
         {
            throw new Exception("Forbidden value (" + this.maturityForAdult + ") on element maturityForAdult.");
         }
         param1.writeVarInt(this.maturityForAdult);
         if(this.energy < 0)
         {
            throw new Exception("Forbidden value (" + this.energy + ") on element energy.");
         }
         param1.writeVarInt(this.energy);
         if(this.energyMax < 0)
         {
            throw new Exception("Forbidden value (" + this.energyMax + ") on element energyMax.");
         }
         param1.writeVarInt(this.energyMax);
         param1.writeInt(this.serenity);
         param1.writeInt(this.aggressivityMax);
         if(this.serenityMax < 0)
         {
            throw new Exception("Forbidden value (" + this.serenityMax + ") on element serenityMax.");
         }
         param1.writeVarInt(this.serenityMax);
         if(this.love < 0)
         {
            throw new Exception("Forbidden value (" + this.love + ") on element love.");
         }
         param1.writeVarInt(this.love);
         if(this.loveMax < 0)
         {
            throw new Exception("Forbidden value (" + this.loveMax + ") on element loveMax.");
         }
         param1.writeVarInt(this.loveMax);
         param1.writeInt(this.fecondationTime);
         if(this.boostLimiter < 0)
         {
            throw new Exception("Forbidden value (" + this.boostLimiter + ") on element boostLimiter.");
         }
         param1.writeInt(this.boostLimiter);
         if(this.boostMax < -9.007199254740992E15 || this.boostMax > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.boostMax + ") on element boostMax.");
         }
         param1.writeDouble(this.boostMax);
         param1.writeInt(this.reproductionCount);
         if(this.reproductionCountMax < 0)
         {
            throw new Exception("Forbidden value (" + this.reproductionCountMax + ") on element reproductionCountMax.");
         }
         param1.writeVarInt(this.reproductionCountMax);
         if(this.harnessGID < 0)
         {
            throw new Exception("Forbidden value (" + this.harnessGID + ") on element harnessGID.");
         }
         param1.writeVarShort(this.harnessGID);
         param1.writeShort(this.effectList.length);
         int _loc5_ = 0;
         while(_loc5_ < this.effectList.length)
         {
            (this.effectList[_loc5_] as ObjectEffectInteger).serializeAs_ObjectEffectInteger(param1);
            _loc5_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc8_ = 0;
         int _loc9_ = 0;
         ObjectEffectInteger _loc10_ = null;
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isRideable = BooleanByteWrapper.getFlag(_loc2_,1);
         this.isWild = BooleanByteWrapper.getFlag(_loc2_,2);
         this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_,3);
         this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_,4);
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of MountClientData.id.");
         }
         this.model = param1.readVarUhInt();
         if(this.model < 0)
         {
            throw new Exception("Forbidden value (" + this.model + ") on element of MountClientData.model.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc8_ = param1.readInt();
            if(_loc8_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc8_ + ") on elements of ancestor.");
            }
            this.ancestor.push(_loc8_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc9_ = param1.readInt();
            if(_loc9_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc9_ + ") on elements of behaviors.");
            }
            this.behaviors.push(_loc9_);
            _loc5_++;
         }
         this.name = param1.readUTF();
         this.ownerId = param1.readInt();
         if(this.ownerId < 0)
         {
            throw new Exception("Forbidden value (" + this.ownerId + ") on element of MountClientData.ownerId.");
         }
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element of MountClientData.experience.");
         }
         this.experienceForLevel = param1.readVarUhLong();
         if(this.experienceForLevel < 0 || this.experienceForLevel > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForLevel + ") on element of MountClientData.experienceForLevel.");
         }
         this.experienceForNextLevel = param1.readDouble();
         if(this.experienceForNextLevel < -9.007199254740992E15 || this.experienceForNextLevel > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceForNextLevel + ") on element of MountClientData.experienceForNextLevel.");
         }
         this.level = param1.readByte();
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of MountClientData.level.");
         }
         this.maxPods = param1.readVarUhInt();
         if(this.maxPods < 0)
         {
            throw new Exception("Forbidden value (" + this.maxPods + ") on element of MountClientData.maxPods.");
         }
         this.stamina = param1.readVarUhInt();
         if(this.stamina < 0)
         {
            throw new Exception("Forbidden value (" + this.stamina + ") on element of MountClientData.stamina.");
         }
         this.staminaMax = param1.readVarUhInt();
         if(this.staminaMax < 0)
         {
            throw new Exception("Forbidden value (" + this.staminaMax + ") on element of MountClientData.staminaMax.");
         }
         this.maturity = param1.readVarUhInt();
         if(this.maturity < 0)
         {
            throw new Exception("Forbidden value (" + this.maturity + ") on element of MountClientData.maturity.");
         }
         this.maturityForAdult = param1.readVarUhInt();
         if(this.maturityForAdult < 0)
         {
            throw new Exception("Forbidden value (" + this.maturityForAdult + ") on element of MountClientData.maturityForAdult.");
         }
         this.energy = param1.readVarUhInt();
         if(this.energy < 0)
         {
            throw new Exception("Forbidden value (" + this.energy + ") on element of MountClientData.energy.");
         }
         this.energyMax = param1.readVarUhInt();
         if(this.energyMax < 0)
         {
            throw new Exception("Forbidden value (" + this.energyMax + ") on element of MountClientData.energyMax.");
         }
         this.serenity = param1.readInt();
         this.aggressivityMax = param1.readInt();
         this.serenityMax = param1.readVarUhInt();
         if(this.serenityMax < 0)
         {
            throw new Exception("Forbidden value (" + this.serenityMax + ") on element of MountClientData.serenityMax.");
         }
         this.love = param1.readVarUhInt();
         if(this.love < 0)
         {
            throw new Exception("Forbidden value (" + this.love + ") on element of MountClientData.love.");
         }
         this.loveMax = param1.readVarUhInt();
         if(this.loveMax < 0)
         {
            throw new Exception("Forbidden value (" + this.loveMax + ") on element of MountClientData.loveMax.");
         }
         this.fecondationTime = param1.readInt();
         this.boostLimiter = param1.readInt();
         if(this.boostLimiter < 0)
         {
            throw new Exception("Forbidden value (" + this.boostLimiter + ") on element of MountClientData.boostLimiter.");
         }
         this.boostMax = param1.readDouble();
         if(this.boostMax < -9.007199254740992E15 || this.boostMax > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.boostMax + ") on element of MountClientData.boostMax.");
         }
         this.reproductionCount = param1.readInt();
         this.reproductionCountMax = param1.readVarUhInt();
         if(this.reproductionCountMax < 0)
         {
            throw new Exception("Forbidden value (" + this.reproductionCountMax + ") on element of MountClientData.reproductionCountMax.");
         }
         this.harnessGID = param1.readVarUhShort();
         if(this.harnessGID < 0)
         {
            throw new Exception("Forbidden value (" + this.harnessGID + ") on element of MountClientData.harnessGID.");
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc10_ = new ObjectEffectInteger();
            _loc10_.deserialize(param1);
            this.effectList.push(_loc10_);
            _loc7_++;
         }
    }

}