package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyInvitationCancelledForGuestMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6256;
    private boolean _isInitialized = false;
    private Number cancelerId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
         }
         param1.writeVarInt(this.partyId);
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element cancelerId.");
         }
         param1.writeVarLong(this.cancelerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.cancelerId = param1.readVarUhLong();
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element of PartyInvitationCancelledForGuestMessage.cancelerId.");
         }
    }

}