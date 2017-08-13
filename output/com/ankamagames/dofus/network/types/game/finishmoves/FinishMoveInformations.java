package com.ankamagames.dofus.network.types.game.finishmoves;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FinishMoveInformations extends Object implements INetworkType {

    private int protocolId = 506;
    private int finishMoveId = 0;
    private boolean finishMoveState = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.finishMoveId < 0)
         {
            throw new Exception("Forbidden value (" + this.finishMoveId + ") on element finishMoveId.");
         }
         param1.writeInt(this.finishMoveId);
         param1.writeBoolean(this.finishMoveState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.finishMoveId = param1.readInt();
         if(this.finishMoveId < 0)
         {
            throw new Exception("Forbidden value (" + this.finishMoveId + ") on element of FinishMoveInformations.finishMoveId.");
         }
         this.finishMoveState = param1.readBoolean();
    }

}