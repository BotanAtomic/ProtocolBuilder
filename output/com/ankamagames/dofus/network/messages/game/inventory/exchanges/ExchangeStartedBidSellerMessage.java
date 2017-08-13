package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.SellerBuyerDescriptor;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInBid;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartedBidSellerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5905;
    private boolean _isInitialized = false;
    private SellerBuyerDescriptor sellerDescriptor;
    private ObjectItemToSellInBid[] objectsInfos;
    private FuncTree _sellerDescriptortree;
    private FuncTree _objectsInfostree;


    public void serialize(ICustomDataOutput param1) {
         this.sellerDescriptor.serializeAs_SellerBuyerDescriptor(param1);
         param1.writeShort(this.objectsInfos.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectsInfos.length)
         {
            (this.objectsInfos[_loc2_] as ObjectItemToSellInBid).serializeAs_ObjectItemToSellInBid(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         ObjectItemToSellInBid _loc4_ = null;
         this.sellerDescriptor = new SellerBuyerDescriptor();
         this.sellerDescriptor.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemToSellInBid();
            _loc4_.deserialize(param1);
            this.objectsInfos.push(_loc4_);
            _loc3_++;
         }
    }

}