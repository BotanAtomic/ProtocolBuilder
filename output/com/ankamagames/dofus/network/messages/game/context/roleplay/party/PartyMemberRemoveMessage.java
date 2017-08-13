package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyMemberRemoveMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 5579;
    private boolean _isInitialized = false;
    private Number leavingPlayerId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         if(this.leavingPlayerId < 0 || this.leavingPlayerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leavingPlayerId + ") on element leavingPlayerId.");
         }
         param1.writeVarLong(this.leavingPlayerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPartyMessage(param1);
         this.leavingPlayerId = param1.readVarUhLong();
         if(this.leavingPlayerId < 0 || this.leavingPlayerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leavingPlayerId + ") on element of PartyMemberRemoveMessage.leavingPlayerId.");
         }
    }

}