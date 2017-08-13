package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectModifiedInBagMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6008;
    private boolean _isInitialized = false;
    private ObjectItem object;
    private FuncTree _objecttree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.remote);
         this.object.serializeAs_ObjectItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.remote = param1.readBoolean();
         this.object = new ObjectItem();
         this.object.deserialize(param1);
    }

}