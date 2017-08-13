package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorGuildInformations extends TaxCollectorComplementaryInformations implements INetworkType {

    private int protocolId = 446;
    private BasicGuildInformations guild;
    private FuncTree _guildtree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorComplementaryInformations(param1);
         this.guild.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guild = new BasicGuildInformations();
         this.guild.deserialize(param1);
    }

}