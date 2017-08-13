package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightSpellCooldown extends Object implements INetworkType {

    private int protocolId = 205;
    private int spellId = 0;
    private int cooldown = 0;


    public int getTypeId() {
         return 205;
    }

    public GameFightSpellCooldown initGameFightSpellCooldown(int param1,int  param2) {
         this.spellId = param1;
         this.cooldown = param2;
         return this;
    }

    public void reset() {
         this.spellId = 0;
         this.cooldown = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightSpellCooldown(param1);
    }

    public void serializeAs_GameFightSpellCooldown(ICustomDataOutput param1) {
         param1.writeInt(this.spellId);
         if(this.cooldown < 0)
         {
            throw new Exception("Forbidden value (" + this.cooldown + ") on element cooldown.");
         }
         param1.writeByte(this.cooldown);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightSpellCooldown(param1);
    }

    public void deserializeAs_GameFightSpellCooldown(ICustomDataInput param1) {
         this._spellIdFunc(param1);
         this._cooldownFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightSpellCooldown(param1);
    }

    public void deserializeAsyncAs_GameFightSpellCooldown(FuncTree param1) {
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._cooldownFunc);
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readInt();
    }

    private void _cooldownFunc(ICustomDataInput param1) {
         this.cooldown = param1.readByte();
         if(this.cooldown < 0)
         {
            throw new Exception("Forbidden value (" + this.cooldown + ") on element of GameFightSpellCooldown.cooldown.");
         }
    }

}