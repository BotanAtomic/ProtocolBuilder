package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HumanOptionAlliance extends HumanOption implements INetworkType {

    private int protocolId = 425;
    private AllianceInformations allianceInformations = ;
    private int aggressable = 0;
    private FuncTree _allianceInformationstree = ;


    public int getTypeId() {
         return 425;
    }

    public HumanOptionAlliance initHumanOptionAlliance(AllianceInformations param1,int  param2) {
         this.allianceInformations = param1;
         this.aggressable = param2;
         return this;
    }

    public void reset() {
         this.allianceInformations = new AllianceInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionAlliance(param1);
    }

    public void serializeAs_HumanOptionAlliance(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         this.allianceInformations.serializeAs_AllianceInformations(param1);
         param1.writeByte(this.aggressable);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionAlliance(param1);
    }

    public void deserializeAs_HumanOptionAlliance(ICustomDataInput param1) {
         super.deserialize(param1);
         this.allianceInformations = new AllianceInformations();
         this.allianceInformations.deserialize(param1);
         this._aggressableFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionAlliance(param1);
    }

    public void deserializeAsyncAs_HumanOptionAlliance(FuncTree param1) {
         super.deserializeAsync(param1);
         this._allianceInformationstree = param1.addChild(this._allianceInformationstreeFunc);
         param1.addChild(this._aggressableFunc);
    }

    private void _allianceInformationstreeFunc(ICustomDataInput param1) {
         this.allianceInformations = new AllianceInformations();
         this.allianceInformations.deserializeAsync(this._allianceInformationstree);
    }

    private void _aggressableFunc(ICustomDataInput param1) {
         this.aggressable = param1.readByte();
         if(this.aggressable < 0)
            throw new Exception("Forbidden value (" + this.aggressable + ") on element of HumanOptionAlliance.aggressable.");
    }

}