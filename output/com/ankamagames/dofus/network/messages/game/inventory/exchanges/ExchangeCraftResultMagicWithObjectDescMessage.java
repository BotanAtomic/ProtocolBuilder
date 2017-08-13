package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemNotInContainer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftResultMagicWithObjectDescMessage extends ExchangeCraftResultWithObjectDescMessage implements INetworkMessage {

    private int protocolId = 6188;
    private boolean _isInitialized = false;
    private int magicPoolStatus = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultMessage(param1);
         this.objectInfo.serializeAs_ObjectItemNotInContainer(param1);
         param1.writeByte(this.magicPoolStatus);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftResultWithObjectDescMessage(param1);
         this.magicPoolStatus = param1.readByte();
    }

}