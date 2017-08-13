package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightCastRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1005;
    private boolean _isInitialized = false;
    private int spellId = 0;
    private int cellId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
         }
         param1.writeVarShort(this.spellId);
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeShort(this.cellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element of GameActionFightCastRequestMessage.spellId.");
         }
         this.cellId = param1.readShort();
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of GameActionFightCastRequestMessage.cellId.");
         }
    }

}