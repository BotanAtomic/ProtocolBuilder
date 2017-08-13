package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PrismFightAttackerRemoveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5897;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private int fightId = 0;
    private Number fighterToRemoveId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeVarShort(this.fightId);
         if(this.fighterToRemoveId < 0 || this.fighterToRemoveId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterToRemoveId + ") on element fighterToRemoveId.");
         }
         param1.writeVarLong(this.fighterToRemoveId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismFightAttackerRemoveMessage.subAreaId.");
         }
         this.fightId = param1.readVarUhShort();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of PrismFightAttackerRemoveMessage.fightId.");
         }
         this.fighterToRemoveId = param1.readVarUhLong();
         if(this.fighterToRemoveId < 0 || this.fighterToRemoveId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterToRemoveId + ") on element of PrismFightAttackerRemoveMessage.fighterToRemoveId.");
         }
    }

}