package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceInformations extends BasicNamed {

    private int protocolId = 417;
    private GuildEmblem allianceEmblem;
    private FuncTree _allianceEmblemtree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_BasicAllianceInformations(param1);
         param1.writeUTF(this.allianceName);
         this.allianceEmblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicNamedAllianceInformations(param1);
         this.allianceEmblem = new GuildEmblem();
         this.allianceEmblem.deserialize(param1);
    }

}