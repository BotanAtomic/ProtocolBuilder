package com.ankamagames.dofus.network.types.game.finishmoves;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FinishMoveInformations extends Object implements INetworkType {

    private int protocolId = 506;
    private int finishMoveId = 0;
    private boolean finishMoveState = false;


    public int getTypeId() {
         return 506;
    }

    public FinishMoveInformations initFinishMoveInformations(int param1,boolean  param2) {
         this.finishMoveId = param1;
         this.finishMoveState = param2;
         return this;
    }

    public void reset() {
         this.finishMoveId = 0;
         this.finishMoveState = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FinishMoveInformations(param1);
    }

    public void serializeAs_FinishMoveInformations(ICustomDataOutput param1) {
         if(this.finishMoveId < 0)
         {
            throw new Exception("Forbidden value (" + this.finishMoveId + ") on element finishMoveId.");
         }
         param1.writeInt(this.finishMoveId);
         param1.writeBoolean(this.finishMoveState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FinishMoveInformations(param1);
    }

    public void deserializeAs_FinishMoveInformations(ICustomDataInput param1) {
         this._finishMoveIdFunc(param1);
         this._finishMoveStateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FinishMoveInformations(param1);
    }

    public void deserializeAsyncAs_FinishMoveInformations(FuncTree param1) {
         param1.addChild(this._finishMoveIdFunc);
         param1.addChild(this._finishMoveStateFunc);
    }

    private void _finishMoveIdFunc(ICustomDataInput param1) {
         this.finishMoveId = param1.readInt();
         if(this.finishMoveId < 0)
         {
            throw new Exception("Forbidden value (" + this.finishMoveId + ") on element of FinishMoveInformations.finishMoveId.");
         }
    }

    private void _finishMoveStateFunc(ICustomDataInput param1) {
         this.finishMoveState = param1.readBoolean();
    }

}