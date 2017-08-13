package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyCancelInvitationNotificationMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 6251;
    private boolean _isInitialized = false;
    private Number cancelerId = 0;
    private Number guestId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element cancelerId.");
         }
         param1.writeVarLong(this.cancelerId);
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.guestId + ") on element guestId.");
         }
         param1.writeVarLong(this.guestId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPartyMessage(param1);
         this.cancelerId = param1.readVarUhLong();
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element of PartyCancelInvitationNotificationMessage.cancelerId.");
         }
         this.guestId = param1.readVarUhLong();
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.guestId + ") on element of PartyCancelInvitationNotificationMessage.guestId.");
         }
    }

}