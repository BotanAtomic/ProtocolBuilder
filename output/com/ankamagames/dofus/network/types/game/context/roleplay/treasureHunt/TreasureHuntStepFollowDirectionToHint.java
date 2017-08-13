package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TreasureHuntStepFollowDirectionToHint extends TreasureHuntStep implements INetworkType {

    private int protocolId = 472;
    private int direction = 1;
    private int npcId = 0;


    public int getTypeId() {
         return 472;
    }

    public TreasureHuntStepFollowDirectionToHint initTreasureHuntStepFollowDirectionToHint(int param1,int  param2) {
         this.direction = param1;
         this.npcId = param2;
         return this;
    }

    public void reset() {
         this.direction = 1;
         this.npcId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TreasureHuntStepFollowDirectionToHint(param1);
    }

    public void serializeAs_TreasureHuntStepFollowDirectionToHint(ICustomDataOutput param1) {
         super.serializeAs_TreasureHuntStep(param1);
         param1.writeByte(this.direction);
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
         }
         param1.writeVarShort(this.npcId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntStepFollowDirectionToHint(param1);
    }

    public void deserializeAs_TreasureHuntStepFollowDirectionToHint(ICustomDataInput param1) {
         super.deserialize(param1);
         this._directionFunc(param1);
         this._npcIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TreasureHuntStepFollowDirectionToHint(param1);
    }

    public void deserializeAsyncAs_TreasureHuntStepFollowDirectionToHint(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._directionFunc);
         param1.addChild(this._npcIdFunc);
    }

    private void _directionFunc(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of TreasureHuntStepFollowDirectionToHint.direction.");
         }
    }

    private void _npcIdFunc(ICustomDataInput param1) {
         this.npcId = param1.readVarUhShort();
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element of TreasureHuntStepFollowDirectionToHint.npcId.");
         }
    }

}