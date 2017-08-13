package com.ankamagames.dofus.network.messages.game.context.roleplay.visual;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlaySpellAnimMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6114;
    private boolean _isInitialized = false;
    private Number casterId = 0;
    private int targetCellId = 0;
    private int spellId = 0;
    private int spellLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.casterId < 0 || this.casterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.casterId + ") on element casterId.");
         }
         param1.writeVarLong(this.casterId);
         if(this.targetCellId < 0 || this.targetCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element targetCellId.");
         }
         param1.writeVarShort(this.targetCellId);
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
         }
         param1.writeVarShort(this.spellId);
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
         }
         param1.writeShort(this.spellLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.casterId = param1.readVarUhLong();
         if(this.casterId < 0 || this.casterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.casterId + ") on element of GameRolePlaySpellAnimMessage.casterId.");
         }
         this.targetCellId = param1.readVarUhShort();
         if(this.targetCellId < 0 || this.targetCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element of GameRolePlaySpellAnimMessage.targetCellId.");
         }
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element of GameRolePlaySpellAnimMessage.spellId.");
         }
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element of GameRolePlaySpellAnimMessage.spellLevel.");
         }
    }

}