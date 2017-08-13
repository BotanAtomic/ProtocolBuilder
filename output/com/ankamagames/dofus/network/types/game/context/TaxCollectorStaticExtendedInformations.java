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


    public int getTypeId() {
         return 440;
    }

    public TaxCollectorStaticExtendedInformations initTaxCollectorStaticExtendedInformations(int param1,int  param2,GuildInformations  param3,AllianceInformations  param4) {
         super.initTaxCollectorStaticInformations(param1,param2,param3);
         this.allianceIdentity = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.allianceIdentity = new AllianceInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorStaticExtendedInformations(param1);
    }

    public void serializeAs_TaxCollectorStaticExtendedInformations(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorStaticInformations(param1);
         this.allianceIdentity.serializeAs_AllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorStaticExtendedInformations(param1);
    }

    public void deserializeAs_TaxCollectorStaticExtendedInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.allianceIdentity = new AllianceInformations();
         this.allianceIdentity.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorStaticExtendedInformations(param1);
    }

    public void deserializeAsyncAs_TaxCollectorStaticExtendedInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._allianceIdentitytree = param1.addChild(this._allianceIdentitytreeFunc);
    }

    private void _allianceIdentitytreeFunc(ICustomDataInput param1) {
         this.allianceIdentity = new AllianceInformations();
         this.allianceIdentity.deserializeAsync(this._allianceIdentitytree);
    }

}