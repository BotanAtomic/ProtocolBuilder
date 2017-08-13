package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseToSellListRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6139;
    private boolean _isInitialized = false;
    private int pageIndex = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.pageIndex < 0)
         {
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
         }
         param1.writeVarShort(this.pageIndex);
    }

    public void deserialize(ICustomDataInput param1) {
         this.pageIndex = param1.readVarUhShort();
         if(this.pageIndex < 0)
         {
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element of HouseToSellListRequestMessage.pageIndex.");
         }
    }

}