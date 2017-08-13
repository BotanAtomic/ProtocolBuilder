package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightLifePointsLostMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 6312;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int loss = 0;
    private int permanentDamages = 0;


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
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.loss < 0)
         {
            throw new Exception("Forbidden value (" + this.loss + ") on element loss.");
         }
         param1.writeVarInt(this.loss);
         if(this.permanentDamages < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamages + ") on element permanentDamages.");
         }
         param1.writeVarInt(this.permanentDamages);
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
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightLifePointsLostMessage.targetId.");
         }
         this.loss = param1.readVarUhInt();
         if(this.loss < 0)
         {
            throw new Exception("Forbidden value (" + this.loss + ") on element of GameActionFightLifePointsLostMessage.loss.");
         }
         this.permanentDamages = param1.readVarUhInt();
         if(this.permanentDamages < 0)
         {
            throw new Exception("Forbidden value (" + this.permanentDamages + ") on element of GameActionFightLifePointsLostMessage.permanentDamages.");
         }
    }

}