package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInHumanVendorShop;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeStartOkHumanVendorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5767;
    private boolean _isInitialized = false;
    private Number sellerId = 0;
    private ObjectItemToSellInHumanVendorShop[] objectsInfos;
    private FuncTree _objectsInfostree;


    public void serialize(ICustomDataOutput param1) {
         if(this.sellerId < -9.007199254740992E15 || this.sellerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sellerId + ") on element sellerId.");
         }
         param1.writeDouble(this.sellerId);
         param1.writeShort(this.objectsInfos.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectsInfos.length)
         {
            (this.objectsInfos[_loc2_] as ObjectItemToSellInHumanVendorShop).serializeAs_ObjectItemToSellInHumanVendorShop(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         ObjectItemToSellInHumanVendorShop _loc4_ = null;
         this.sellerId = param1.readDouble();
         if(this.sellerId < -9.007199254740992E15 || this.sellerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sellerId + ") on element of ExchangeStartOkHumanVendorMessage.sellerId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemToSellInHumanVendorShop();
            _loc4_.deserialize(param1);
            this.objectsInfos.push(_loc4_);
            _loc3_++;
         }
    }

}