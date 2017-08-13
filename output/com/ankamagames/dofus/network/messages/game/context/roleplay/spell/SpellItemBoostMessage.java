package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SpellItemBoostMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6011;
    private boolean _isInitialized = false;
    private int statId = 0;
    private int spellId = 0;
    private int value = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.statId < 0)
         {
            throw new Exception("Forbidden value (" + this.statId + ") on element statId.");
         }
         param1.writeVarInt(this.statId);
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
         }
         param1.writeVarShort(this.spellId);
         param1.writeVarShort(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.statId = param1.readVarUhInt();
         if(this.statId < 0)
         {
            throw new Exception("Forbidden value (" + this.statId + ") on element of SpellItemBoostMessage.statId.");
         }
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element of SpellItemBoostMessage.spellId.");
         }
         this.value = param1.readVarShort();
    }

}