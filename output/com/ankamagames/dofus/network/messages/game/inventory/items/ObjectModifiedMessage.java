package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectModifiedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3029;
    private boolean _isInitialized = false;
    private ObjectItem object;
    private FuncTree _objecttree;


    public void serialize(ICustomDataOutput param1) {
         this.object.serializeAs_ObjectItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.object = new ObjectItem();
         this.object.deserialize(param1);
    }

}