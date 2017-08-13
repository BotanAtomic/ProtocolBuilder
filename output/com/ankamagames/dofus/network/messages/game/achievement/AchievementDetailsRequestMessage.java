package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AchievementDetailsRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6380;
    private boolean _isInitialized = false;
    private int achievementId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.achievementId < 0)
         {
            throw new Exception("Forbidden value (" + this.achievementId + ") on element achievementId.");
         }
         param1.writeVarShort(this.achievementId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.achievementId = param1.readVarUhShort();
         if(this.achievementId < 0)
         {
            throw new Exception("Forbidden value (" + this.achievementId + ") on element of AchievementDetailsRequestMessage.achievementId.");
         }
    }

}