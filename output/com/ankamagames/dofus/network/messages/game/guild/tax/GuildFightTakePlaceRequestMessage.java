package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildFightTakePlaceRequestMessage extends GuildFightJoinRequestMessage implements INetworkMessage {

    private int protocolId = 6235;
    private boolean _isInitialized = false;
    private int replacedCharacterId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GuildFightJoinRequestMessage(param1);
         param1.writeInt(this.replacedCharacterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.taxCollectorId = param1.readInt();
         this.replacedCharacterId = param1.readInt();
    }

}