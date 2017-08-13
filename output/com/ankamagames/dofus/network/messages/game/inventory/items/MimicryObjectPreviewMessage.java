package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MimicryObjectPreviewMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6458;
    private boolean _isInitialized = false;
    private ObjectItem result;
    private FuncTree _resulttree;


    public void serialize(ICustomDataOutput param1) {
         this.result.serializeAs_ObjectItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.result = new ObjectItem();
         this.result.deserialize(param1);
    }

}