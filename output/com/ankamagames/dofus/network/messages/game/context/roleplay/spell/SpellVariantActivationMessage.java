package com.ankamagames.dofus.network.messages.game.context.roleplay.spell;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SpellVariantActivationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6705;
    private boolean _isInitialized = false;
    private boolean result = false;
    private int activatedSpellId = 0;
    private int deactivatedSpellId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.result);
         if(this.activatedSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.activatedSpellId + ") on element activatedSpellId.");
         }
         param1.writeVarShort(this.activatedSpellId);
         if(this.deactivatedSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.deactivatedSpellId + ") on element deactivatedSpellId.");
         }
         param1.writeVarShort(this.deactivatedSpellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.result = param1.readBoolean();
         this.activatedSpellId = param1.readVarUhShort();
         if(this.activatedSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.activatedSpellId + ") on element of SpellVariantActivationMessage.activatedSpellId.");
         }
         this.deactivatedSpellId = param1.readVarUhShort();
         if(this.deactivatedSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.deactivatedSpellId + ") on element of SpellVariantActivationMessage.deactivatedSpellId.");
         }
    }

}