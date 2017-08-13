package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyFollowThisMemberRequestMessage extends PartyFollowMemberRequestMessage implements INetworkMessage {

    private int protocolId = 5588;
    private boolean _isInitialized = false;
    private boolean enabled = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_PartyFollowMemberRequestMessage(param1);
         param1.writeBoolean(this.enabled);
    }

    public void deserialize(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of PartyFollowMemberRequestMessage.playerId.");
         }
         this.enabled = param1.readBoolean();
    }

}