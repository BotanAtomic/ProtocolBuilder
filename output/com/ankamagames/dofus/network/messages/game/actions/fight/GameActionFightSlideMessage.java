package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightSlideMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5525;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int startCellId = 0;
    private int endCellId = 0;


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
         if(this.startCellId < -1 || this.startCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.startCellId + ") on element startCellId.");
         }
         param1.writeShort(this.startCellId);
         if(this.endCellId < -1 || this.endCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.endCellId + ") on element endCellId.");
         }
         param1.writeShort(this.endCellId);
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
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightSlideMessage.targetId.");
         }
         this.startCellId = param1.readShort();
         if(this.startCellId < -1 || this.startCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.startCellId + ") on element of GameActionFightSlideMessage.startCellId.");
         }
         this.endCellId = param1.readShort();
         if(this.endCellId < -1 || this.endCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.endCellId + ") on element of GameActionFightSlideMessage.endCellId.");
         }
    }

}