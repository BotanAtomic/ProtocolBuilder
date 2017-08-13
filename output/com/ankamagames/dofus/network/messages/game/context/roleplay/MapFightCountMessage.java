package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MapFightCountMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 210;
    private boolean _isInitialized = false;
    private int fightCount = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightCount < 0)
         {
            throw new Exception("Forbidden value (" + this.fightCount + ") on element fightCount.");
         }
         param1.writeVarShort(this.fightCount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightCount = param1.readVarUhShort();
         if(this.fightCount < 0)
         {
            throw new Exception("Forbidden value (" + this.fightCount + ") on element of MapFightCountMessage.fightCount.");
         }
    }

}