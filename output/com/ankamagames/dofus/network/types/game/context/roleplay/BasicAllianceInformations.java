package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class BasicAllianceInformations extends AbstractSocialGroupInfos implements INetworkType {

    private int protocolId = 419;
    private int allianceId = 0;
    private String allianceTag = "";


    public int getTypeId() {
         return 419;
    }

    public BasicAllianceInformations initBasicAllianceInformations(int param1,String  param2) {
         this.allianceId = param1;
         this.allianceTag = param2;
         return this;
    }

    public void reset() {
         this.allianceId = 0;
         this.allianceTag = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_BasicAllianceInformations(param1);
    }

    public void serializeAs_BasicAllianceInformations(ICustomDataOutput param1) {
         super.serializeAs_AbstractSocialGroupInfos(param1);
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicAllianceInformations(param1);
    }

    public void deserializeAs_BasicAllianceInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._allianceIdFunc(param1);
         this._allianceTagFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicAllianceInformations(param1);
    }

    public void deserializeAsyncAs_BasicAllianceInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._allianceIdFunc);
         param1.addChild(this._allianceTagFunc);
    }

    private void _allianceIdFunc(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of BasicAllianceInformations.allianceId.");
    }

    private void _allianceTagFunc(ICustomDataInput param1) {
         this.allianceTag = param1.readUTF();
    }

}