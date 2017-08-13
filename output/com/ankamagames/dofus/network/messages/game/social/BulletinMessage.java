package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class BulletinMessage extends SocialNoticeMessage implements INetworkMessage {

    private int protocolId = 6695;
    private boolean _isInitialized = false;
    private int lastNotifiedTimestamp = 0;


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
         if(this.lastNotifiedTimestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNotifiedTimestamp + ") on element lastNotifiedTimestamp.");
         }
         param1.writeInt(this.lastNotifiedTimestamp);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SocialNoticeMessage(param1);
         this.lastNotifiedTimestamp = param1.readInt();
         if(this.lastNotifiedTimestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNotifiedTimestamp + ") on element of BulletinMessage.lastNotifiedTimestamp.");
         }
    }

}