package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeCraftPaymentModifiedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6578;
    private boolean _isInitialized = false;
    private Number goldSum = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.goldSum < 0 || this.goldSum > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.goldSum + ") on element goldSum.");
         }
         param1.writeVarLong(this.goldSum);
    }

    public void deserialize(ICustomDataInput param1) {
         this.goldSum = param1.readVarUhLong();
         if(this.goldSum < 0 || this.goldSum > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.goldSum + ") on element of ExchangeCraftPaymentModifiedMessage.goldSum.");
         }
    }

}