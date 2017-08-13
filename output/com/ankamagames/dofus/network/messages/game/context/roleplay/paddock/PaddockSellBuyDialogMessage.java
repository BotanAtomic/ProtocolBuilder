package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PaddockSellBuyDialogMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6018;
    private boolean _isInitialized = false;
    private boolean bsell = false;
    private int ownerId = 0;
    private Number price = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.bsell);
         if(this.ownerId < 0)
         {
            throw new Exception("Forbidden value (" + this.ownerId + ") on element ownerId.");
         }
         param1.writeVarInt(this.ownerId);
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         this.bsell = param1.readBoolean();
         this.ownerId = param1.readVarUhInt();
         if(this.ownerId < 0)
         {
            throw new Exception("Forbidden value (" + this.ownerId + ") on element of PaddockSellBuyDialogMessage.ownerId.");
         }
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of PaddockSellBuyDialogMessage.price.");
         }
    }

}