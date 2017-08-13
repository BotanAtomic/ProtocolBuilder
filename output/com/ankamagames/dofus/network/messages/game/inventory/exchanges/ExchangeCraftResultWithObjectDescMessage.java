package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemNotInContainer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftResultWithObjectDescMessage extends ExchangeCraftResultMessage implements INetworkMessage {

    private int protocolId = 5999;
    private boolean _isInitialized = false;
    private ObjectItemNotInContainer objectInfo;
    private FuncTree _objectInfotree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultMessage(param1);
         this.objectInfo.serializeAs_ObjectItemNotInContainer(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.craftResult = param1.readByte();
         if(this.craftResult < 0)
         {
            throw new Exception("Forbidden value (" + this.craftResult + ") on element of ExchangeCraftResultMessage.craftResult.");
         }
         this.objectInfo = new ObjectItemNotInContainer();
         this.objectInfo.deserialize(param1);
    }

}