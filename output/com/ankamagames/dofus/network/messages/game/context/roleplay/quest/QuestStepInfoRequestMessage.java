package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class QuestStepInfoRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5622;
    private boolean _isInitialized = false;
    private int questId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.questId < 0)
         {
            throw new Exception("Forbidden value (" + this.questId + ") on element questId.");
         }
         param1.writeVarShort(this.questId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.questId = param1.readVarUhShort();
         if(this.questId < 0)
         {
            throw new Exception("Forbidden value (" + this.questId + ") on element of QuestStepInfoRequestMessage.questId.");
         }
    }

}