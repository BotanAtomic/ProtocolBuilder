package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightSpellCooldown;
import com.ankamagames.dofus.network.types.game.action.fight.FightDispellableEffectExtendedInformations;
import com.ankamagames.dofus.network.types.game.actions.fight.GameActionMark;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightResumeMessage extends GameFightSpectateMessage implements INetworkMessage {

    private int protocolId = 6067;
    private boolean _isInitialized = false;
    private Vector<GameFightSpellCooldown> spellCooldowns;
    private int summonCount = 0;
    private int bombCount = 0;
    private FuncTree _spellCooldownstree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6067;
    }

    public GameFightResumeMessage initGameFightResumeMessage(Vector<FightDispellableEffectExtendedInformations> param1,Vector<GameActionMark>  param2,int  param3,int  param4,Vector<Idol>  param5,Vector<GameFightSpellCooldown>  param6,int  param7,int  param8) {
         super.initGameFightSpectateMessage(param1,param2,param3,param4,param5);
         this.spellCooldowns = param6;
         this.summonCount = param7;
         this.bombCount = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.spellCooldowns = new Vector.<GameFightSpellCooldown>();
         this.summonCount = 0;
         this.bombCount = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightResumeMessage(param1);
    }

    public void serializeAs_GameFightResumeMessage(ICustomDataOutput param1) {
         super.serializeAs_GameFightSpectateMessage(param1);
         param1.writeShort(this.spellCooldowns.length);
         int _loc2_ = 0;
         while(_loc2_ < this.spellCooldowns.length)
         {
            (this.spellCooldowns[_loc2_] as GameFightSpellCooldown).serializeAs_GameFightSpellCooldown(param1);
            _loc2_++;
         }
         if(this.summonCount < 0)
         {
            throw new Exception("Forbidden value (" + this.summonCount + ") on element summonCount.");
         }
         param1.writeByte(this.summonCount);
         if(this.bombCount < 0)
         {
            throw new Exception("Forbidden value (" + this.bombCount + ") on element bombCount.");
         }
         param1.writeByte(this.bombCount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightResumeMessage(param1);
    }

    public void deserializeAs_GameFightResumeMessage(ICustomDataInput param1) {
         GameFightSpellCooldown _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GameFightSpellCooldown();
            _loc4_.deserialize(param1);
            this.spellCooldowns.push(_loc4_);
            _loc3_++;
         }
         this._summonCountFunc(param1);
         this._bombCountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightResumeMessage(param1);
    }

    public void deserializeAsyncAs_GameFightResumeMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._spellCooldownstree = param1.addChild(this._spellCooldownstreeFunc);
         param1.addChild(this._summonCountFunc);
         param1.addChild(this._bombCountFunc);
    }

    private void _spellCooldownstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._spellCooldownstree.addChild(this._spellCooldownsFunc);
            _loc3_++;
         }
    }

    private void _spellCooldownsFunc(ICustomDataInput param1) {
         GameFightSpellCooldown _loc2_ = new GameFightSpellCooldown();
         _loc2_.deserialize(param1);
         this.spellCooldowns.push(_loc2_);
    }

    private void _summonCountFunc(ICustomDataInput param1) {
         this.summonCount = param1.readByte();
         if(this.summonCount < 0)
         {
            throw new Exception("Forbidden value (" + this.summonCount + ") on element of GameFightResumeMessage.summonCount.");
         }
    }

    private void _bombCountFunc(ICustomDataInput param1) {
         this.bombCount = param1.readByte();
         if(this.bombCount < 0)
         {
            throw new Exception("Forbidden value (" + this.bombCount + ") on element of GameFightResumeMessage.bombCount.");
         }
    }

}