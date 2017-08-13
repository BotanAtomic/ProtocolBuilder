package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicNamedAllianceInformations extends BasicAllianceInformations implements INetworkType {

    private int protocolId = 418;
    private String allianceName = "";


    public int getTypeId() {
         return 418;
    }

    public BasicNamedAllianceInformations initBasicNamedAllianceInformations(int param1,String  param2,String  param3) {
         super.initBasicAllianceInformations(param1,param2);
         this.allianceName = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.allianceName = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_BasicNamedAllianceInformations(param1);
    }

    public void serializeAs_BasicNamedAllianceInformations(ICustomDataOutput param1) {
         super.serializeAs_BasicAllianceInformations(param1);
         param1.writeUTF(this.allianceName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicNamedAllianceInformations(param1);
    }

    public void deserializeAs_BasicNamedAllianceInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._allianceNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicNamedAllianceInformations(param1);
    }

    public void deserializeAsyncAs_BasicNamedAllianceInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._allianceNameFunc);
    }

    private void _allianceNameFunc(ICustomDataInput param1) {
         this.allianceName = param1.readUTF();
    }

}