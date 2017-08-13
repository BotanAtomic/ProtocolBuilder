package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PaddockBuyResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6516;
    private boolean _isInitialized = false;
    private int paddockId = 0;
    private boolean bought = false;
    private Number realPrice = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.paddockId);
         param1.writeBoolean(this.bought);
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element realPrice.");
         }
         param1.writeVarLong(this.realPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.paddockId = param1.readInt();
         this.bought = param1.readBoolean();
         this.realPrice = param1.readVarUhLong();
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element of PaddockBuyResultMessage.realPrice.");
         }
    }

}