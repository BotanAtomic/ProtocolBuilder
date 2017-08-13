package com.ankamagames.dofus.network.messages.game.finishmoves;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FinishMoveSetRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6703;
    private boolean _isInitialized = false;
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
            throw new Exception("Forbidden value (" + this.finishMoveId + ") on element of FinishMoveSetRequestMessage.finishMoveId.");
         }
         this.finishMoveState = param1.readBoolean();
    }

}