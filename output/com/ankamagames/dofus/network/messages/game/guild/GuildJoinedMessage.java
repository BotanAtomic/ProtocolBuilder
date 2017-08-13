package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildJoinedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5564;
    private boolean _isInitialized = false;
    private GuildInformations guildInfo;
    private int memberRights = 0;
    private FuncTree _guildInfotree;


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