package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectModifyPricedMessage extends ExchangeObjectMovePricedMessage implements INetworkMessage {

    private int protocolId = 6238;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMoveMessage(param1);
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectMovePricedMessage(param1);
    }

}