package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AllianceInvitationStateRecrutedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6392;
    private boolean _isInitialized = false;
    private int invitationState = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.invitationState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.invitationState = param1.readByte();
         if(this.invitationState < 0)
         {
            throw new Exception("Forbidden value (" + this.invitationState + ") on element of AllianceInvitationStateRecrutedMessage.invitationState.");
         }
    }

}