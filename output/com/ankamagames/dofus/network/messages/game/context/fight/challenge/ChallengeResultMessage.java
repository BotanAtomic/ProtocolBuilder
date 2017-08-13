package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChallengeResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6019;
    private boolean _isInitialized = false;
    private int challengeId = 0;
    private boolean success = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.challengeId < 0)
         {
            throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
         }
         param1.writeVarShort(this.challengeId);
         param1.writeBoolean(this.success);
    }

    public void deserialize(ICustomDataInput param1) {
         this.challengeId = param1.readVarUhShort();
         if(this.challengeId < 0)
         {
            throw new Exception("Forbidden value (" + this.challengeId + ") on element of ChallengeResultMessage.challengeId.");
         }
         this.success = param1.readBoolean();
    }

}