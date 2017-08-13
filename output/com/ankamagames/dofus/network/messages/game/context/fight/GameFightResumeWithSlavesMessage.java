package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightResumeSlaveInfo;
import com.ankamagames.dofus.network.types.game.action.fight.FightDispellableEffectExtendedInformations;
import com.ankamagames.dofus.network.types.game.actions.fight.GameActionMark;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightSpellCooldown;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightResumeWithSlavesMessage extends GameFightResumeMessage implements INetworkMessage {

    private int protocolId = 6215;
    private boolean _isInitialized = false;
    private GameFightResumeSlaveInfo[] slavesInfo;
    private FuncTree _slavesInfotree;


    public void serialize(ICustomDataOutput param1) {
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
         param1.writeShort(this.slavesInfo.length);
         int _loc2_ = 0;
         while(_loc2_ < this.slavesInfo.length)
         {
            (this.slavesInfo[_loc2_] as GameFightResumeSlaveInfo).serializeAs_GameFightResumeSlaveInfo(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         GameFightResumeSlaveInfo _loc4_ = null;
         GameFightSpellCooldown _loc4_ = null;
         this.deserializeAs_GameFightSpectateMessage(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GameFightSpellCooldown();
            _loc4_.deserialize(param1);
            this.spellCooldowns.push(_loc4_);
            _loc3_++;
         }
         this.summonCount = param1.readByte();
         if(this.summonCount < 0)
         {
            throw new Exception("Forbidden value (" + this.summonCount + ") on element of GameFightResumeMessage.summonCount.");
         }
         this.bombCount = param1.readByte();
         if(this.bombCount < 0)
         {
            throw new Exception("Forbidden value (" + this.bombCount + ") on element of GameFightResumeMessage.bombCount.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GameFightResumeSlaveInfo();
            _loc4_.deserialize(param1);
            this.slavesInfo.push(_loc4_);
            _loc3_++;
         }
    }

}