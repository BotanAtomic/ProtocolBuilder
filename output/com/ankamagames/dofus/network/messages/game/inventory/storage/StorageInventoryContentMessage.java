package com.ankamagames.dofus.network.messages.game.inventory.storage;

import com.ankamagames.dofus.network.messages.game.inventory.items.InventoryContentMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StorageInventoryContentMessage extends InventoryContentMessage implements INetworkMessage {

    private int protocolId = 5646;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_InventoryContentMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.objects.push(_loc4_);
            _loc3_++;
         }
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element of InventoryContentMessage.kamas.");
         }
    }

}