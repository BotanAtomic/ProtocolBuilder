package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseInListRemovedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5950;
    private boolean _isInitialized = false;
    private int itemUID = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.itemUID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.itemUID = param1.readInt();
    }

}