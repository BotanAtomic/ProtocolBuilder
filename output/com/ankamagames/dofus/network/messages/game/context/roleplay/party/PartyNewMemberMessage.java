package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyNewMemberMessage extends PartyUpdateMessage implements INetworkMessage {

    private int protocolId = 6306;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         param1.writeShort(this.memberInformations.getTypeId());
         this.memberInformations.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyUpdateMessage(param1);
    }

}