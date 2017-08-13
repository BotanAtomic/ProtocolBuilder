package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeReadyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5511;
    private boolean _isInitialized = false;
    private boolean ready = false;
    private int step = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.ready);
         if(this.step < 0)
         {
            throw new Exception("Forbidden value (" + this.step + ") on element step.");
         }
         param1.writeVarShort(this.step);
    }

    public void deserialize(ICustomDataInput param1) {
         this.ready = param1.readBoolean();
         this.step = param1.readVarUhShort();
         if(this.step < 0)
         {
            throw new Exception("Forbidden value (" + this.step + ") on element of ExchangeReadyMessage.step.");
         }
    }

}