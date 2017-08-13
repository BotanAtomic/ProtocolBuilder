package com.ankamagames.dofus.network.messages.game.context.roleplay.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class StatsUpgradeResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5609;
    private boolean _isInitialized = false;
    private int result = 0;
    private int nbCharacBoost = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.result);
         if(this.nbCharacBoost < 0)
         {
            throw new Exception("Forbidden value (" + this.nbCharacBoost + ") on element nbCharacBoost.");
         }
         param1.writeVarShort(this.nbCharacBoost);
    }

    public void deserialize(ICustomDataInput param1) {
         this.result = param1.readByte();
         this.nbCharacBoost = param1.readVarUhShort();
         if(this.nbCharacBoost < 0)
         {
            throw new Exception("Forbidden value (" + this.nbCharacBoost + ") on element of StatsUpgradeResultMessage.nbCharacBoost.");
         }
    }

}