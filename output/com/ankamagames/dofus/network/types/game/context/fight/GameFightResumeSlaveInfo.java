package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightResumeSlaveInfo extends Object implements INetworkType {

    private int protocolId = 364;
    private Number slaveId = 0;
    private Vector.<GameFightSpellCooldown> spellCooldowns = ;
    private int summonCount = 0;
    private int bombCount = 0;
    private FuncTree _spellCooldownstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 364;
    }

    public GameFightResumeSlaveInfo initGameFightResumeSlaveInfo(Number param1,Vector.<GameFightSpellCooldown>  param2,int  param3,int  param4) {
         this.slaveId = param1;
         this.spellCooldowns = param2;
         this.summonCount = param3;
         this.bombCount = param4;
         return this;
    }

    public void reset() {
         this.slaveId = 0;
         this.spellCooldowns = new Vector.<GameFightSpellCooldown>();
         this.summonCount = 0;
         this.bombCount = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightResumeSlaveInfo(param1);
    }

    public void serializeAs_GameFightResumeSlaveInfo(ICustomDataOutput param1) {
         if(this.slaveId < -9.007199254740992E15 || this.slaveId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.slaveId + ") on element slaveId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightResumeSlaveInfo(param1);
    }

    public void deserializeAs_GameFightResumeSlaveInfo(ICustomDataInput param1) {
         GameFightSpellCooldown _loc4_ = null;
         this._slaveIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new GameFightSpellCooldown();
            _loc4_.deserialize(param1);
            this.spellCooldowns.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightResumeSlaveInfo(param1);
    }

    public void deserializeAsyncAs_GameFightResumeSlaveInfo(FuncTree param1) {
         param1.addChild(this._slaveIdFunc);
         this._spellCooldownstree = param1.addChild(this._spellCooldownstreeFunc);
         param1.addChild(this._summonCountFunc);
         param1.addChild(this._bombCountFunc);
    }

    private void _slaveIdFunc(ICustomDataInput param1) {
         this.slaveId = param1.readDouble();
         if(this.slaveId < -9.007199254740992E15 || this.slaveId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.slaveId + ") on element of GameFightResumeSlaveInfo.slaveId.");
    }

    private void _spellCooldownstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._spellCooldownstree.addChild(this._spellCooldownsFunc);
            _loc3_++;
    }

    private void _spellCooldownsFunc(ICustomDataInput param1) {
         GameFightSpellCooldown _loc2_ = new GameFightSpellCooldown();
         _loc2_.deserialize(param1);
         this.spellCooldowns.push(_loc2_);
    }

    private void _summonCountFunc(ICustomDataInput param1) {
         this.summonCount = param1.readByte();
         if(this.summonCount < 0)
            throw new Exception("Forbidden value (" + this.summonCount + ") on element of GameFightResumeSlaveInfo.summonCount.");
    }

    private void _bombCountFunc(ICustomDataInput param1) {
         this.bombCount = param1.readByte();
         if(this.bombCount < 0)
            throw new Exception("Forbidden value (" + this.bombCount + ") on element of GameFightResumeSlaveInfo.bombCount.");
    }

}