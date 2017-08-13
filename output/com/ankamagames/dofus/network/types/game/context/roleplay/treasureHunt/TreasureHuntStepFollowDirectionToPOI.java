package package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TreasureHuntStepFollowDirectionToPOI extends TreasureHuntStep implements INetworkType {

    private int protocolId = 461;
    private int direction = 1;
    private int poiLabelId = 0;


    public int getTypeId() {
         return 461;
    }

    public TreasureHuntStepFollowDirectionToPOI initTreasureHuntStepFollowDirectionToPOI(int param1,int  param2) {
         this.direction = param1;
         this.poiLabelId = param2;
         return this;
    }

    public void reset() {
         this.direction = 1;
         this.poiLabelId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TreasureHuntStepFollowDirectionToPOI(param1);
    }

    public void serializeAs_TreasureHuntStepFollowDirectionToPOI(ICustomDataOutput param1) {
         super.serializeAs_TreasureHuntStep(param1);
         param1.writeByte(this.direction);
         if(this.poiLabelId < 0)
            throw new Exception("Forbidden value (" + this.poiLabelId + ") on element poiLabelId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntStepFollowDirectionToPOI(param1);
    }

    public void deserializeAs_TreasureHuntStepFollowDirectionToPOI(ICustomDataInput param1) {
         super.deserialize(param1);
         this._directionFunc(param1);
         this._poiLabelIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TreasureHuntStepFollowDirectionToPOI(param1);
    }

    public void deserializeAsyncAs_TreasureHuntStepFollowDirectionToPOI(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._directionFunc);
         param1.addChild(this._poiLabelIdFunc);
    }

    private void _directionFunc(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
            throw new Exception("Forbidden value (" + this.direction + ") on element of TreasureHuntStepFollowDirectionToPOI.direction.");
    }

    private void _poiLabelIdFunc(ICustomDataInput param1) {
         this.poiLabelId = param1.readVarUhShort();
         if(this.poiLabelId < 0)
            throw new Exception("Forbidden value (" + this.poiLabelId + ") on element of TreasureHuntStepFollowDirectionToPOI.poiLabelId.");
    }

}