package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightTriggerGlyphTrapMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5741;
    private boolean _isInitialized = false;
    private int markId = 0;
    private Number triggeringCharacterId = 0;
    private int triggeredSpellId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element sourceId.");
         }
         param1.writeDouble(this.sourceId);
         param1.writeShort(this.markId);
         if(this.triggeringCharacterId < -9.007199254740992E15 || this.triggeringCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.triggeringCharacterId + ") on element triggeringCharacterId.");
         }
         param1.writeDouble(this.triggeringCharacterId);
         if(this.triggeredSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.triggeredSpellId + ") on element triggeredSpellId.");
         }
         param1.writeVarShort(this.triggeredSpellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of AbstractGameActionMessage.actionId.");
         }
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of AbstractGameActionMessage.sourceId.");
         }
         this.markId = param1.readShort();
         this.triggeringCharacterId = param1.readDouble();
         if(this.triggeringCharacterId < -9.007199254740992E15 || this.triggeringCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.triggeringCharacterId + ") on element of GameActionFightTriggerGlyphTrapMessage.triggeringCharacterId.");
         }
         this.triggeredSpellId = param1.readVarUhShort();
         if(this.triggeredSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.triggeredSpellId + ") on element of GameActionFightTriggerGlyphTrapMessage.triggeredSpellId.");
         }
    }

}