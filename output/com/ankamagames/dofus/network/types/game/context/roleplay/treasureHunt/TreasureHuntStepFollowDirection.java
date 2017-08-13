package package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TreasureHuntStepFollowDirection extends TreasureHuntStep implements INetworkType {

    private int protocolId = 468;
    private int direction = 1;
    private int mapCount = 0;


    public int getTypeId() {
         return 468;
    }

    public TreasureHuntStepFollowDirection initTreasureHuntStepFollowDirection(int param1,int  param2) {
         this.direction = param1;
         this.mapCount = param2;
         return this;
    }

    public void reset() {
         this.direction = 1;
         this.mapCount = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TreasureHuntStepFollowDirection(param1);
    }

    public void serializeAs_TreasureHuntStepFollowDirection(ICustomDataOutput param1) {
         super.serializeAs_TreasureHuntStep(param1);
         param1.writeByte(this.direction);
         if(this.mapCount < 0)
            throw new Exception("Forbidden value (" + this.mapCount + ") on element mapCount.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntStepFollowDirection(param1);
    }

    public void deserializeAs_TreasureHuntStepFollowDirection(ICustomDataInput param1) {
         super.deserialize(param1);
         this._directionFunc(param1);
         this._mapCountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TreasureHuntStepFollowDirection(param1);
    }

    public void deserializeAsyncAs_TreasureHuntStepFollowDirection(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._directionFunc);
         param1.addChild(this._mapCountFunc);
    }

    private void _directionFunc(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
            throw new Exception("Forbidden value (" + this.direction + ") on element of TreasureHuntStepFollowDirection.direction.");
    }

    private void _mapCountFunc(ICustomDataInput param1) {
         this.mapCount = param1.readVarUhShort();
         if(this.mapCount < 0)
            throw new Exception("Forbidden value (" + this.mapCount + ") on element of TreasureHuntStepFollowDirection.mapCount.");
    }

}