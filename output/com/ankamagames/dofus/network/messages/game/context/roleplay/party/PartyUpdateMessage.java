package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class PartyUpdateMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 5575;
    private boolean _isInitialized = false;
    private PartyMemberInformations memberInformations;
    private FuncTree _memberInformationstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeShort(this.memberInformations.getTypeId());
         this.memberInformations.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPartyMessage(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.memberInformations = ProtocolTypeManager.getInstance(PartyMemberInformations,_loc2_);
         this.memberInformations.deserialize(param1);
    }

}