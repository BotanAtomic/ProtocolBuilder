package package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlliancePrismInformation extends PrismInformation implements INetworkType {

    private int protocolId = 427;
    private AllianceInformations alliance = ;
    private FuncTree _alliancetree = ;


    public int getTypeId() {
         return 427;
    }

    public AlliancePrismInformation initAlliancePrismInformation(int param1,int  param2,int  param3,int  param4,int  param5,AllianceInformations  param6) {
         super.initPrismInformation(param1,param2,param3,param4,param5);
         this.alliance = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.alliance = new AllianceInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AlliancePrismInformation(param1);
    }

    public void serializeAs_AlliancePrismInformation(ICustomDataOutput param1) {
         super.serializeAs_PrismInformation(param1);
         this.alliance.serializeAs_AllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AlliancePrismInformation(param1);
    }

    public void deserializeAs_AlliancePrismInformation(ICustomDataInput param1) {
         super.deserialize(param1);
         this.alliance = new AllianceInformations();
         this.alliance.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AlliancePrismInformation(param1);
    }

    public void deserializeAsyncAs_AlliancePrismInformation(FuncTree param1) {
         super.deserializeAsync(param1);
         this._alliancetree = param1.addChild(this._alliancetreeFunc);
    }

    private void _alliancetreeFunc(ICustomDataInput param1) {
         this.alliance = new AllianceInformations();
         this.alliance.deserializeAsync(this._alliancetree);
    }

}