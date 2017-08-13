package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorStaticExtendedInformations extends TaxCollectorStaticInformations implements INetworkType {

    private int protocolId = 440;
    private AllianceInformations allianceIdentity;
    private FuncTree _allianceIdentitytree;


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
         this.allianceIdentity.serializeAs_AllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorStaticInformations(param1);
         this.allianceIdentity = new AllianceInformations();
         this.allianceIdentity.deserialize(param1);
    }

}