package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TaxCollectorStaticInformations extends Object implements INetworkType {

    private int protocolId = 147;
    private int firstNameId = 0;
    private int lastNameId = 0;
    private GuildInformations guildIdentity;
    private FuncTree _guildIdentitytree;


    public int getTypeId() {
         return 147;
    }

    public TaxCollectorStaticInformations initTaxCollectorStaticInformations(int param1,int  param2,GuildInformations  param3) {
         this.firstNameId = param1;
         this.lastNameId = param2;
         this.guildIdentity = param3;
         return this;
    }

    public void reset() {
         this.firstNameId = 0;
         this.lastNameId = 0;
         this.guildIdentity = new GuildInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorStaticInformations(param1);
    }

    public void serializeAs_TaxCollectorStaticInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_TaxCollectorStaticInformations(param1);
    }

    public void deserializeAs_TaxCollectorStaticInformations(ICustomDataInput param1) {
         this._firstNameIdFunc(param1);
         this._lastNameIdFunc(param1);
         this.guildIdentity = new GuildInformations();
         this.guildIdentity.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorStaticInformations(param1);
    }

    public void deserializeAsyncAs_TaxCollectorStaticInformations(FuncTree param1) {
         param1.addChild(this._firstNameIdFunc);
         param1.addChild(this._lastNameIdFunc);
         this._guildIdentitytree = param1.addChild(this._guildIdentitytreeFunc);
    }

    private void _firstNameIdFunc(ICustomDataInput param1) {
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of TaxCollectorStaticInformations.firstNameId.");
         }
    }

    private void _lastNameIdFunc(ICustomDataInput param1) {
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of TaxCollectorStaticInformations.lastNameId.");
         }
    }

    private void _guildIdentitytreeFunc(ICustomDataInput param1) {
         this.guildIdentity = new GuildInformations();
         this.guildIdentity.deserializeAsync(this._guildIdentitytree);
    }

}