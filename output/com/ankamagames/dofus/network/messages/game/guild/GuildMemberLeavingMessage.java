package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildMemberLeavingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5923;
    private boolean _isInitialized = false;
    private boolean kicked = false;
    private Number memberId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.kicked);
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
         }
         param1.writeVarLong(this.memberId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.kicked = param1.readBoolean();
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element of GuildMemberLeavingMessage.memberId.");
         }
    }

}