package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInBid;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseItemAddOkMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5945;
    private boolean _isInitialized = false;
    private ObjectItemToSellInBid itemInfo;
    private FuncTree _itemInfotree;


    public void serialize(ICustomDataOutput param1) {
         this.itemInfo.serializeAs_ObjectItemToSellInBid(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.itemInfo = new ObjectItemToSellInBid();
         this.itemInfo.deserialize(param1);
    }

}