package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildMembershipMessage extends GuildJoinedMessage implements INetworkMessage {

    private int protocolId = 5835;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         this.guildInfo.serializeAs_GuildInformations(param1);
         if(this.memberRights < 0)
         {
            throw new Exception("Forbidden value (" + this.memberRights + ") on element memberRights.");
         }
         param1.writeVarInt(this.memberRights);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this.memberRights = param1.readVarUhInt();
         if(this.memberRights < 0)
         {
            throw new Exception("Forbidden value (" + this.memberRights + ") on element of GuildJoinedMessage.memberRights.");
         }
    }

}