package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemQuantity;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectsQuantityMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6206;
    private boolean _isInitialized = false;
    private ObjectItemQuantity[] objectsUIDAndQty;
    private FuncTree _objectsUIDAndQtytree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.objectsUIDAndQty.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectsUIDAndQty.length)
         {
            (this.objectsUIDAndQty[_loc2_] as ObjectItemQuantity).serializeAs_ObjectItemQuantity(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         ObjectItemQuantity _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemQuantity();
            _loc4_.deserialize(param1);
            this.objectsUIDAndQty.push(_loc4_);
            _loc3_++;
         }
    }

}