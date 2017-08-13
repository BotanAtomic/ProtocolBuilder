package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockGuildedInformations extends PaddockBuyableInformations implements INetworkType {

    private int protocolId = 508;
    private boolean deserted = false;
    private GuildInformations guildInfo;
    private FuncTree _guildInfotree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_PaddockBuyableInformations(param1);
         param1.writeBoolean(this.deserted);
         this.guildInfo.serializeAs_GuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of PaddockBuyableInformations.price.");
         }
         this.locked = param1.readBoolean();
         this.deserted = param1.readBoolean();
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
    }

}