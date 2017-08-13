package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildInvitedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5552;
    private boolean _isInitialized = false;
    private Number recruterId = 0;
    private String recruterName = "";
    private BasicGuildInformations guildInfo;
    private FuncTree _guildInfotree;


    public void serialize(ICustomDataOutput param1) {
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.recruterId + ") on element recruterId.");
         }
         param1.writeVarLong(this.recruterId);
         param1.writeUTF(this.recruterName);
         this.guildInfo.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.recruterId = param1.readVarUhLong();
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.recruterId + ") on element of GuildInvitedMessage.recruterId.");
         }
         this.recruterName = param1.readUTF();
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserialize(param1);
    }

}