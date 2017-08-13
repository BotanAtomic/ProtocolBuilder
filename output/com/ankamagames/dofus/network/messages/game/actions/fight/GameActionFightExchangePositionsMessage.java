package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightExchangePositionsMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 5527;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int casterCellId = 0;
    private int targetCellId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.casterCellId < -1 || this.casterCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.casterCellId + ") on element casterCellId.");
         }
         param1.writeShort(this.casterCellId);
         if(this.targetCellId < -1 || this.targetCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element targetCellId.");
         }
         param1.writeShort(this.targetCellId);
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
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameActionFightExchangePositionsMessage.targetId.");
         }
         this.casterCellId = param1.readShort();
         if(this.casterCellId < -1 || this.casterCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.casterCellId + ") on element of GameActionFightExchangePositionsMessage.casterCellId.");
         }
         this.targetCellId = param1.readShort();
         if(this.targetCellId < -1 || this.targetCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element of GameActionFightExchangePositionsMessage.targetCellId.");
         }
    }

}