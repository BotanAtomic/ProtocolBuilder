package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyNewGuestMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 6260;
    private boolean _isInitialized = false;
    private PartyGuestInformations guest;
    private FuncTree _guesttree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         this.guest.serializeAs_PartyGuestInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPartyMessage(param1);
         this.guest = new PartyGuestInformations();
         this.guest.deserialize(param1);
    }

}