package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidHouseBuyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5804;
    private boolean _isInitialized = false;
    private int uid = 0;
    private int qty = 0;
    private Number price = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
         }
         param1.writeVarInt(this.uid);
         if(this.qty < 0)
         {
            throw new Exception("Forbidden value (" + this.qty + ") on element qty.");
         }
         param1.writeVarInt(this.qty);
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element of ExchangeBidHouseBuyMessage.uid.");
         }
         this.qty = param1.readVarUhInt();
         if(this.qty < 0)
         {
            throw new Exception("Forbidden value (" + this.qty + ") on element of ExchangeBidHouseBuyMessage.qty.");
         }
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of ExchangeBidHouseBuyMessage.price.");
         }
    }

}