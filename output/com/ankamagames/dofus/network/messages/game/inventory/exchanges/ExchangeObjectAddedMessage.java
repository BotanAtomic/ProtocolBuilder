package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectAddedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 5516;
    private boolean _isInitialized = false;
    private ObjectItem object;
    private FuncTree _objecttree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.remote);
         this.object.serializeAs_ObjectItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectMessage(param1);
         this.object = new ObjectItem();
         this.object.deserialize(param1);
    }

}