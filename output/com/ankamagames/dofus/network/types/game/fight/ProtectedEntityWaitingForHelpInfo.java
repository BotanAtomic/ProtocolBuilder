package package com.ankamagames.dofus.network.types.game.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ProtectedEntityWaitingForHelpInfo extends Object implements INetworkType {

    private int protocolId = 186;
    private int timeLeftBeforeFight = 0;
    private int waitTimeForPlacement = 0;
    private int nbPositionForDefensors = 0;


    public int getTypeId() {
         return 186;
    }

    public ProtectedEntityWaitingForHelpInfo initProtectedEntityWaitingForHelpInfo(int param1,int  param2,int  param3) {
         this.timeLeftBeforeFight = param1;
         this.waitTimeForPlacement = param2;
         this.nbPositionForDefensors = param3;
         return this;
    }

    public void reset() {
         this.timeLeftBeforeFight = 0;
         this.waitTimeForPlacement = 0;
         this.nbPositionForDefensors = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ProtectedEntityWaitingForHelpInfo(param1);
    }

    public void serializeAs_ProtectedEntityWaitingForHelpInfo(ICustomDataOutput param1) {
         param1.writeInt(this.timeLeftBeforeFight);
         param1.writeInt(this.waitTimeForPlacement);
         if(this.nbPositionForDefensors < 0)
            throw new Exception("Forbidden value (" + this.nbPositionForDefensors + ") on element nbPositionForDefensors.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ProtectedEntityWaitingForHelpInfo(param1);
    }

    public void deserializeAs_ProtectedEntityWaitingForHelpInfo(ICustomDataInput param1) {
         this._timeLeftBeforeFightFunc(param1);
         this._waitTimeForPlacementFunc(param1);
         this._nbPositionForDefensorsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ProtectedEntityWaitingForHelpInfo(param1);
    }

    public void deserializeAsyncAs_ProtectedEntityWaitingForHelpInfo(FuncTree param1) {
         param1.addChild(this._timeLeftBeforeFightFunc);
         param1.addChild(this._waitTimeForPlacementFunc);
         param1.addChild(this._nbPositionForDefensorsFunc);
    }

    private void _timeLeftBeforeFightFunc(ICustomDataInput param1) {
         this.timeLeftBeforeFight = param1.readInt();
    }

    private void _waitTimeForPlacementFunc(ICustomDataInput param1) {
         this.waitTimeForPlacement = param1.readInt();
    }

    private void _nbPositionForDefensorsFunc(ICustomDataInput param1) {
         this.nbPositionForDefensors = param1.readByte();
         if(this.nbPositionForDefensors < 0)
            throw new Exception("Forbidden value (" + this.nbPositionForDefensors + ") on element of ProtectedEntityWaitingForHelpInfo.nbPositionForDefensors.");
    }

}