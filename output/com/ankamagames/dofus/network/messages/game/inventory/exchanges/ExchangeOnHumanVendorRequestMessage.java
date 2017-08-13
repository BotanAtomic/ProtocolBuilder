package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeOnHumanVendorRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5772;
    private boolean _isInitialized = false;
    private Number humanVendorId = 0;
    private int humanVendorCell = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.humanVendorId < 0 || this.humanVendorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.humanVendorId + ") on element humanVendorId.");
         }
         param1.writeVarLong(this.humanVendorId);
         if(this.humanVendorCell < 0 || this.humanVendorCell > 559)
         {
            throw new Exception("Forbidden value (" + this.humanVendorCell + ") on element humanVendorCell.");
         }
         param1.writeVarShort(this.humanVendorCell);
    }

    public void deserialize(ICustomDataInput param1) {
         this.humanVendorId = param1.readVarUhLong();
         if(this.humanVendorId < 0 || this.humanVendorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.humanVendorId + ") on element of ExchangeOnHumanVendorRequestMessage.humanVendorId.");
         }
         this.humanVendorCell = param1.readVarUhShort();
         if(this.humanVendorCell < 0 || this.humanVendorCell > 559)
         {
            throw new Exception("Forbidden value (" + this.humanVendorCell + ") on element of ExchangeOnHumanVendorRequestMessage.humanVendorCell.");
         }
    }

}