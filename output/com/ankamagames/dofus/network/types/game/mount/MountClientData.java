package package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffectInteger;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
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

public class MountClientData extends Object implements INetworkType {

    private int protocolId = 178;
    private Number id = 0;
    private int model = 0;
    private Vector.<uint> ancestor = ;
    private Vector.<uint> behaviors = ;
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
    private Vector.<ObjectEffectInteger> effectList = ;
    private FuncTree _ancestortree = ;
    private FuncTree _behaviorstree = ;
    private FuncTree _effectListtree = ;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private int _loc5_ = 0;
    private int _loc9_ = 0;
    private ObjectEffectInteger _loc10_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc6_ = param1.readUnsignedShort();
    private int _loc7_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 178;
    }

    public MountClientData initMountClientData(Number param1,int  param2,Vector.<uint>  param3,Vector.<uint>  param4,String  param5,boolean  param6,int  param7,Number  param8,Number  param9,Number  param10,int  param11,boolean  param12,int  param13,boolean  param14,int  param15,int  param16,int  param17,int  param18,int  param19,int  param20,int  param21,int  param22,int  param23,int  param24,int  param25,int  param26,boolean  param27,int  param28,Number  param29,int  param30,int  param31,int  param32,boolean  param33,Vector.<ObjectEffectInteger>  param34) {
         this.id = param1;
         this.model = param2;
         this.ancestor = param3;
         this.behaviors = param4;
         this.name = param5;
         this.sex = param6;
         this.ownerId = param7;
         this.experience = param8;
         this.experienceForLevel = param9;
         this.experienceForNextLevel = param10;
         this.level = param11;
         this.isRideable = param12;
         this.maxPods = param13;
         this.isWild = param14;
         this.stamina = param15;
         this.staminaMax = param16;
         this.maturity = param17;
         this.maturityForAdult = param18;
         this.energy = param19;
         this.energyMax = param20;
         this.serenity = param21;
         this.aggressivityMax = param22;
         this.serenityMax = param23;
         this.love = param24;
         this.loveMax = param25;
         this.fecondationTime = param26;
         this.isFecondationReady = param27;
         this.boostLimiter = param28;
         this.boostMax = param29;
         this.reproductionCount = param30;
         this.reproductionCountMax = param31;
         this.harnessGID = param32;
         this.useHarnessColors = param33;
         this.effectList = param34;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.model = 0;
         this.ancestor = new Vector.<uint>();
         this.behaviors = new Vector.<uint>();
         this.name = "";
         this.sex = false;
         this.ownerId = 0;
         this.experience = 0;
         this.experienceForLevel = 0;
         this.experienceForNextLevel = 0;
         this.level = 0;
         this.isRideable = false;
         this.maxPods = 0;
         this.isWild = false;
         this.stamina = 0;
         this.staminaMax = 0;
         this.maturity = 0;
         this.maturityForAdult = 0;
         this.energy = 0;
         this.energyMax = 0;
         this.serenity = 0;
         this.aggressivityMax = 0;
         this.serenityMax = 0;
         this.love = 0;
         this.loveMax = 0;
         this.fecondationTime = 0;
         this.isFecondationReady = false;
         this.boostLimiter = 0;
         this.boostMax = 0;
         this.reproductionCount = 0;
         this.reproductionCountMax = 0;
         this.harnessGID = 0;
         this.useHarnessColors = false;
         this.effectList = new Vector.<ObjectEffectInteger>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MountClientData(param1);
    }

    public void serializeAs_MountClientData(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.sex);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isRideable);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isWild);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.isFecondationReady);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,4,this.useHarnessColors);
         param1.writeByte(_loc2_);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountClientData(param1);
    }

    public void deserializeAs_MountClientData(ICustomDataInput param1) {
         int _loc8_ = 0;
         int _loc9_ = 0;
         ObjectEffectInteger _loc10_ = null;
         this.deserializeByteBoxes(param1);
         this._idFunc(param1);
         this._modelFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc8_ = param1.readInt();
            if(_loc8_ < 0)
               throw new Exception("Forbidden value (" + _loc8_ + ") on elements of ancestor.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountClientData(param1);
    }

    public void deserializeAsyncAs_MountClientData(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._idFunc);
         param1.addChild(this._modelFunc);
         this._ancestortree = param1.addChild(this._ancestortreeFunc);
         this._behaviorstree = param1.addChild(this._behaviorstreeFunc);
         param1.addChild(this._nameFunc);
         param1.addChild(this._ownerIdFunc);
         param1.addChild(this._experienceFunc);
         param1.addChild(this._experienceForLevelFunc);
         param1.addChild(this._experienceForNextLevelFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._maxPodsFunc);
         param1.addChild(this._staminaFunc);
         param1.addChild(this._staminaMaxFunc);
         param1.addChild(this._maturityFunc);
         param1.addChild(this._maturityForAdultFunc);
         param1.addChild(this._energyFunc);
         param1.addChild(this._energyMaxFunc);
         param1.addChild(this._serenityFunc);
         param1.addChild(this._aggressivityMaxFunc);
         param1.addChild(this._serenityMaxFunc);
         param1.addChild(this._loveFunc);
         param1.addChild(this._loveMaxFunc);
         param1.addChild(this._fecondationTimeFunc);
         param1.addChild(this._boostLimiterFunc);
         param1.addChild(this._boostMaxFunc);
         param1.addChild(this._reproductionCountFunc);
         param1.addChild(this._reproductionCountMaxFunc);
         param1.addChild(this._harnessGIDFunc);
         this._effectListtree = param1.addChild(this._effectListtreeFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isRideable = BooleanByteWrapper.getFlag(_loc2_,1);
         this.isWild = BooleanByteWrapper.getFlag(_loc2_,2);
         this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_,3);
         this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_,4);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element of MountClientData.id.");
    }

    private void _modelFunc(ICustomDataInput param1) {
         this.model = param1.readVarUhInt();
         if(this.model < 0)
            throw new Exception("Forbidden value (" + this.model + ") on element of MountClientData.model.");
    }

    private void _ancestortreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._ancestortree.addChild(this._ancestorFunc);
            _loc3_++;
    }

    private void _ancestorFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ancestor.");
    }

    private void _behaviorstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._behaviorstree.addChild(this._behaviorsFunc);
            _loc3_++;
    }

    private void _behaviorsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of behaviors.");
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _ownerIdFunc(ICustomDataInput param1) {
         this.ownerId = param1.readInt();
         if(this.ownerId < 0)
            throw new Exception("Forbidden value (" + this.ownerId + ") on element of MountClientData.ownerId.");
    }

    private void _experienceFunc(ICustomDataInput param1) {
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element of MountClientData.experience.");
    }

    private void _experienceForLevelFunc(ICustomDataInput param1) {
         this.experienceForLevel = param1.readVarUhLong();
         if(this.experienceForLevel < 0 || this.experienceForLevel > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceForLevel + ") on element of MountClientData.experienceForLevel.");
    }

    private void _experienceForNextLevelFunc(ICustomDataInput param1) {
         this.experienceForNextLevel = param1.readDouble();
         if(this.experienceForNextLevel < -9.007199254740992E15 || this.experienceForNextLevel > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experienceForNextLevel + ") on element of MountClientData.experienceForNextLevel.");
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readByte();
         if(this.level < 0)
            throw new Exception("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    private void _maxPodsFunc(ICustomDataInput param1) {
         this.maxPods = param1.readVarUhInt();
         if(this.maxPods < 0)
            throw new Exception("Forbidden value (" + this.maxPods + ") on element of MountClientData.maxPods.");
    }

    private void _staminaFunc(ICustomDataInput param1) {
         this.stamina = param1.readVarUhInt();
         if(this.stamina < 0)
            throw new Exception("Forbidden value (" + this.stamina + ") on element of MountClientData.stamina.");
    }

    private void _staminaMaxFunc(ICustomDataInput param1) {
         this.staminaMax = param1.readVarUhInt();
         if(this.staminaMax < 0)
            throw new Exception("Forbidden value (" + this.staminaMax + ") on element of MountClientData.staminaMax.");
    }

    private void _maturityFunc(ICustomDataInput param1) {
         this.maturity = param1.readVarUhInt();
         if(this.maturity < 0)
            throw new Exception("Forbidden value (" + this.maturity + ") on element of MountClientData.maturity.");
    }

    private void _maturityForAdultFunc(ICustomDataInput param1) {
         this.maturityForAdult = param1.readVarUhInt();
         if(this.maturityForAdult < 0)
            throw new Exception("Forbidden value (" + this.maturityForAdult + ") on element of MountClientData.maturityForAdult.");
    }

    private void _energyFunc(ICustomDataInput param1) {
         this.energy = param1.readVarUhInt();
         if(this.energy < 0)
            throw new Exception("Forbidden value (" + this.energy + ") on element of MountClientData.energy.");
    }

    private void _energyMaxFunc(ICustomDataInput param1) {
         this.energyMax = param1.readVarUhInt();
         if(this.energyMax < 0)
            throw new Exception("Forbidden value (" + this.energyMax + ") on element of MountClientData.energyMax.");
    }

    private void _serenityFunc(ICustomDataInput param1) {
         this.serenity = param1.readInt();
    }

    private void _aggressivityMaxFunc(ICustomDataInput param1) {
         this.aggressivityMax = param1.readInt();
    }

    private void _serenityMaxFunc(ICustomDataInput param1) {
         this.serenityMax = param1.readVarUhInt();
         if(this.serenityMax < 0)
            throw new Exception("Forbidden value (" + this.serenityMax + ") on element of MountClientData.serenityMax.");
    }

    private void _loveFunc(ICustomDataInput param1) {
         this.love = param1.readVarUhInt();
         if(this.love < 0)
            throw new Exception("Forbidden value (" + this.love + ") on element of MountClientData.love.");
    }

    private void _loveMaxFunc(ICustomDataInput param1) {
         this.loveMax = param1.readVarUhInt();
         if(this.loveMax < 0)
            throw new Exception("Forbidden value (" + this.loveMax + ") on element of MountClientData.loveMax.");
    }

    private void _fecondationTimeFunc(ICustomDataInput param1) {
         this.fecondationTime = param1.readInt();
    }

    private void _boostLimiterFunc(ICustomDataInput param1) {
         this.boostLimiter = param1.readInt();
         if(this.boostLimiter < 0)
            throw new Exception("Forbidden value (" + this.boostLimiter + ") on element of MountClientData.boostLimiter.");
    }

    private void _boostMaxFunc(ICustomDataInput param1) {
         this.boostMax = param1.readDouble();
         if(this.boostMax < -9.007199254740992E15 || this.boostMax > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.boostMax + ") on element of MountClientData.boostMax.");
    }

    private void _reproductionCountFunc(ICustomDataInput param1) {
         this.reproductionCount = param1.readInt();
    }

    private void _reproductionCountMaxFunc(ICustomDataInput param1) {
         this.reproductionCountMax = param1.readVarUhInt();
         if(this.reproductionCountMax < 0)
            throw new Exception("Forbidden value (" + this.reproductionCountMax + ") on element of MountClientData.reproductionCountMax.");
    }

    private void _harnessGIDFunc(ICustomDataInput param1) {
         this.harnessGID = param1.readVarUhShort();
         if(this.harnessGID < 0)
            throw new Exception("Forbidden value (" + this.harnessGID + ") on element of MountClientData.harnessGID.");
    }

    private void _effectListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._effectListtree.addChild(this._effectListFunc);
            _loc3_++;
    }

    private void _effectListFunc(ICustomDataInput param1) {
         ObjectEffectInteger _loc2_ = new ObjectEffectInteger();
         _loc2_.deserialize(param1);
         this.effectList.push(_loc2_);
    }

}