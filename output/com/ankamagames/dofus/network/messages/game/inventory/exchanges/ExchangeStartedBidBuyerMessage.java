package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.SellerBuyerDescriptor;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartedBidBuyerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5904;
    private boolean _isInitialized = false;
    private SellerBuyerDescriptor buyerDescriptor;
    private FuncTree _buyerDescriptortree;


    public void serialize(ICustomDataOutput param1) {
         this.buyerDescriptor.serializeAs_SellerBuyerDescriptor(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.buyerDescriptor = new SellerBuyerDescriptor();
         this.buyerDescriptor.deserialize(param1);
    }

}