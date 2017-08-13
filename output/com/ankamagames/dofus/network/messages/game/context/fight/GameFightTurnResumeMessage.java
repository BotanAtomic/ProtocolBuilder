package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightTurnResumeMessage extends GameFightTurnStartMessage implements INetworkMessage {

    private int protocolId = 6307;
    private boolean _isInitialized = false;
    private int remainingTime = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.waitTime < 0)
         {
            throw new Exception("Forbidden value (" + this.waitTime + ") on element waitTime.");
         }
         param1.writeVarInt(this.waitTime);
         if(this.remainingTime < 0)
         {
            throw new Exception("Forbidden value (" + this.remainingTime + ") on element remainingTime.");
         }
         param1.writeVarInt(this.remainingTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightTurnStartMessage(param1);
         this.remainingTime = param1.readVarUhInt();
         if(this.remainingTime < 0)
         {
            throw new Exception("Forbidden value (" + this.remainingTime + ") on element of GameFightTurnResumeMessage.remainingTime.");
         }
    }

}