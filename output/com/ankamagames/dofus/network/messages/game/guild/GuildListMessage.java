package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6413;
    private boolean _isInitialized = false;
    private GuildInformations[] guilds;
    private FuncTree _guildstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.guilds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.guilds.length)
         {
            (this.guilds[_loc2_] as GuildInformations).serializeAs_GuildInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         GuildInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GuildInformations();
            _loc4_.deserialize(param1);
            this.guilds.push(_loc4_);
            _loc3_++;
         }
    }

}