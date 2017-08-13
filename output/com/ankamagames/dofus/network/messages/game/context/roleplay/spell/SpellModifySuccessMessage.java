package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SpellModifySuccessMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6654;
    private boolean _isInitialized = false;
    private int spellId = 0;
    private int spellLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.spellId);
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
         }
         param1.writeShort(this.spellLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.spellId = param1.readInt();
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element of SpellModifySuccessMessage.spellLevel.");
         }
    }

}