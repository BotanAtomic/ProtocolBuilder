package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceMembershipMessage extends AllianceJoinedMessage implements INetworkMessage {

    private int protocolId = 6390;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AllianceJoinedMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.allianceInfo = new AllianceInformations();
         this.allianceInfo.deserialize(param1);
         this.enabled = param1.readBoolean();
         this.leadingGuildId = param1.readVarUhInt();
         if(this.leadingGuildId < 0)
         {
            throw new Exception("Forbidden value (" + this.leadingGuildId + ") on element of AllianceJoinedMessage.leadingGuildId.");
         }
    }

}