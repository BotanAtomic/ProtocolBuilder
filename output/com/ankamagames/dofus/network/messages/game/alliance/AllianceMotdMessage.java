package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.dofus.network.messages.game.social.SocialNoticeMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceMotdMessage extends SocialNoticeMessage implements INetworkMessage {

    private int protocolId = 6685;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.content);
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
         }
         param1.writeInt(this.timestamp);
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
         }
         param1.writeVarLong(this.memberId);
         param1.writeUTF(this.memberName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SocialNoticeMessage(param1);
    }

}