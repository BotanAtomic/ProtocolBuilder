package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChallengeInfoMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6022;
    private boolean _isInitialized = false;
    private int challengeId = 0;
    private Number targetId = 0;
    private int xpBonus = 0;
    private int dropBonus = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.challengeId < 0)
         {
            throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
         }
         param1.writeVarShort(this.challengeId);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.xpBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBonus + ") on element xpBonus.");
         }
         param1.writeVarInt(this.xpBonus);
         if(this.dropBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBonus + ") on element dropBonus.");
         }
         param1.writeVarInt(this.dropBonus);
    }

    public void deserialize(ICustomDataInput param1) {
         this.challengeId = param1.readVarUhShort();
         if(this.challengeId < 0)
         {
            throw new Exception("Forbidden value (" + this.challengeId + ") on element of ChallengeInfoMessage.challengeId.");
         }
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of ChallengeInfoMessage.targetId.");
         }
         this.xpBonus = param1.readVarUhInt();
         if(this.xpBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBonus + ") on element of ChallengeInfoMessage.xpBonus.");
         }
         this.dropBonus = param1.readVarUhInt();
         if(this.dropBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBonus + ") on element of ChallengeInfoMessage.dropBonus.");
         }
    }

}