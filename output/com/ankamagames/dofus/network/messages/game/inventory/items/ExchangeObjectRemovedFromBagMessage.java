package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeObjectRemovedFromBagMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6010;
    private boolean _isInitialized = false;
    private int objectUID = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.remote = param1.readBoolean();
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ExchangeObjectRemovedFromBagMessage.objectUID.");
         }
    }

}