package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntLegendaryRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6499;
    private boolean _isInitialized = false;
    private int legendaryId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.legendaryId < 0)
         {
            throw new Exception("Forbidden value (" + this.legendaryId + ") on element legendaryId.");
         }
         param1.writeVarShort(this.legendaryId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.legendaryId = param1.readVarUhShort();
         if(this.legendaryId < 0)
         {
            throw new Exception("Forbidden value (" + this.legendaryId + ") on element of TreasureHuntLegendaryRequestMessage.legendaryId.");
         }
    }

}