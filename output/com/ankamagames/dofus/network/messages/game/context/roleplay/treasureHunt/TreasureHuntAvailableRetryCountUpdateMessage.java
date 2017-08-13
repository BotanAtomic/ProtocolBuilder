package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntAvailableRetryCountUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6491;
    private boolean _isInitialized = false;
    private int questType = 0;
    private int availableRetryCount = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.questType);
         param1.writeInt(this.availableRetryCount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.questType = param1.readByte();
         if(this.questType < 0)
         {
            throw new Exception("Forbidden value (" + this.questType + ") on element of TreasureHuntAvailableRetryCountUpdateMessage.questType.");
         }
         this.availableRetryCount = param1.readInt();
    }

}