package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightSpellCooldown extends Object implements INetworkType {

    private int protocolId = 205;
    private int spellId = 0;
    private int cooldown = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.spellId);
         if(this.cooldown < 0)
         {
            throw new Exception("Forbidden value (" + this.cooldown + ") on element cooldown.");
         }
         param1.writeByte(this.cooldown);
    }

    public void deserialize(ICustomDataInput param1) {
         this.spellId = param1.readInt();
         this.cooldown = param1.readByte();
         if(this.cooldown < 0)
         {
            throw new Exception("Forbidden value (" + this.cooldown + ") on element of GameFightSpellCooldown.cooldown.");
         }
    }

}