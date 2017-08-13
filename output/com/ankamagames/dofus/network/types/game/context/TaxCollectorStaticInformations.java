package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TaxCollectorStaticInformations extends Object implements INetworkType {

    private int protocolId = 147;
    private int firstNameId = 0;
    private int lastNameId = 0;
    private GuildInformations guildIdentity;
    private FuncTree _guildIdentitytree;


    public void serialize(ICustomDataOutput param1) {
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
         }
         param1.writeVarShort(this.firstNameId);
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
         }
         param1.writeVarShort(this.lastNameId);
         this.guildIdentity.serializeAs_GuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of TaxCollectorStaticInformations.firstNameId.");
         }
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of TaxCollectorStaticInformations.lastNameId.");
         }
         this.guildIdentity = new GuildInformations();
         this.guildIdentity.deserialize(param1);
    }

}