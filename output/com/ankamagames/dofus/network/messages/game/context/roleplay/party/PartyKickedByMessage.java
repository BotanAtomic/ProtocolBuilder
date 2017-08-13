package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyKickedByMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5590;
    private boolean _isInitialized = false;
    private Number kickerId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
         }
         param1.writeVarInt(this.partyId);
         if(this.kickerId < 0 || this.kickerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kickerId + ") on element kickerId.");
         }
         param1.writeVarLong(this.kickerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.kickerId = param1.readVarUhLong();
         if(this.kickerId < 0 || this.kickerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kickerId + ") on element of PartyKickedByMessage.kickerId.");
         }
    }

}