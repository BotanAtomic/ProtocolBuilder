package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyLeaderUpdateMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 5578;
    private boolean _isInitialized = false;
    private Number partyLeaderId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element partyLeaderId.");
         }
         param1.writeVarLong(this.partyLeaderId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPartyMessage(param1);
         this.partyLeaderId = param1.readVarUhLong();
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element of PartyLeaderUpdateMessage.partyLeaderId.");
         }
    }

}