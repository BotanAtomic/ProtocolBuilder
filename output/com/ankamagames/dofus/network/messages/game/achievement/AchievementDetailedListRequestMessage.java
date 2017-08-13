package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AchievementDetailedListRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6357;
    private boolean _isInitialized = false;
    private int categoryId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.categoryId < 0)
         {
            throw new Exception("Forbidden value (" + this.categoryId + ") on element categoryId.");
         }
         param1.writeVarShort(this.categoryId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.categoryId = param1.readVarUhShort();
         if(this.categoryId < 0)
         {
            throw new Exception("Forbidden value (" + this.categoryId + ") on element of AchievementDetailedListRequestMessage.categoryId.");
         }
    }

}