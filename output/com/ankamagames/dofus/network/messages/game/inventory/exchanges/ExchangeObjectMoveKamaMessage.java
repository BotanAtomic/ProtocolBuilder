package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeObjectMoveKamaMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5520;
    private boolean _isInitialized = false;
    private Number quantity = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.quantity < -9.007199254740992E15 || this.quantity > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarLong(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.quantity = param1.readVarLong();
         if(this.quantity < -9.007199254740992E15 || this.quantity > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ExchangeObjectMoveKamaMessage.quantity.");
         }
    }

}