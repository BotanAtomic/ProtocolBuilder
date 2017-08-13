package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeReplyTaxVendorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5787;
    private boolean _isInitialized = false;
    private Number objectValue = 0;
    private Number totalTaxValue = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.objectValue < 0 || this.objectValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectValue + ") on element objectValue.");
         }
         param1.writeVarLong(this.objectValue);
         if(this.totalTaxValue < 0 || this.totalTaxValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.totalTaxValue + ") on element totalTaxValue.");
         }
         param1.writeVarLong(this.totalTaxValue);
    }

    public void deserialize(ICustomDataInput param1) {
         this.objectValue = param1.readVarUhLong();
         if(this.objectValue < 0 || this.objectValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.objectValue + ") on element of ExchangeReplyTaxVendorMessage.objectValue.");
         }
         this.totalTaxValue = param1.readVarUhLong();
         if(this.totalTaxValue < 0 || this.totalTaxValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.totalTaxValue + ") on element of ExchangeReplyTaxVendorMessage.totalTaxValue.");
         }
    }

}