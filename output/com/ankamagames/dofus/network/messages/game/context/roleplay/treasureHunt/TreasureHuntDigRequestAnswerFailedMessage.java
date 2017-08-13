package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntDigRequestAnswerFailedMessage extends TreasureHuntDigRequestAnswerMessage implements INetworkMessage {

    private int protocolId = 6509;
    private boolean _isInitialized = false;
    private int wrongFlagCount = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.questType);
         param1.writeByte(this.result);
         if(this.wrongFlagCount < 0)
         {
            throw new Exception("Forbidden value (" + this.wrongFlagCount + ") on element wrongFlagCount.");
         }
         param1.writeByte(this.wrongFlagCount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntDigRequestAnswerMessage(param1);
         this.wrongFlagCount = param1.readByte();
         if(this.wrongFlagCount < 0)
         {
            throw new Exception("Forbidden value (" + this.wrongFlagCount + ") on element of TreasureHuntDigRequestAnswerFailedMessage.wrongFlagCount.");
         }
    }

}