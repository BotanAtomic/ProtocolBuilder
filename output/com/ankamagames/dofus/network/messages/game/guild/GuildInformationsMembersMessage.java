package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildMember;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInformationsMembersMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5558;
    private boolean _isInitialized = false;
    private GuildMember[] members;
    private FuncTree _memberstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.members.length);
         int _loc2_ = 0;
         while(_loc2_ < this.members.length)
         {
            (this.members[_loc2_] as GuildMember).serializeAs_GuildMember(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         GuildMember _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GuildMember();
            _loc4_.deserialize(param1);
            this.members.push(_loc4_);
            _loc3_++;
         }
    }

}