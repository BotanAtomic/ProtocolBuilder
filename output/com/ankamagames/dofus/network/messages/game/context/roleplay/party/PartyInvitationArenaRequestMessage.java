package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyInvitationArenaRequestMessage extends PartyInvitationRequestMessage implements INetworkMessage {

    private int protocolId = 6283;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationRequestMessage(param1);
    }

}