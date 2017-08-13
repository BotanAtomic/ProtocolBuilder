package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildChangeMemberParametersMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5549;
    private boolean _isInitialized = false;
    private Number memberId = 0;
    private int rank = 0;
    private int experienceGivenPercent = 0;
    private int rights = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
         }
         param1.writeVarLong(this.memberId);
         if(this.rank < 0)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
         }
         param1.writeVarShort(this.rank);
         if(this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100)
         {
            throw new Exception("Forbidden value (" + this.experienceGivenPercent + ") on element experienceGivenPercent.");
         }
         param1.writeByte(this.experienceGivenPercent);
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
         }
         param1.writeVarInt(this.rights);
    }

    public void deserialize(ICustomDataInput param1) {
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.memberId + ") on element of GuildChangeMemberParametersMessage.memberId.");
         }
         this.rank = param1.readVarUhShort();
         if(this.rank < 0)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element of GuildChangeMemberParametersMessage.rank.");
         }
         this.experienceGivenPercent = param1.readByte();
         if(this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100)
         {
            throw new Exception("Forbidden value (" + this.experienceGivenPercent + ") on element of GuildChangeMemberParametersMessage.experienceGivenPercent.");
         }
         this.rights = param1.readVarUhInt();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of GuildChangeMemberParametersMessage.rights.");
         }
    }

}