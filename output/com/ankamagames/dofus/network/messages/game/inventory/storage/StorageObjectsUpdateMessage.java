package com.ankamagames.dofus.network.messages.game.inventory.storage;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StorageObjectsUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6036;
    private boolean _isInitialized = false;
    private ObjectItem[] objectList;
    private FuncTree _objectListtree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.objectList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectList.length)
         {
            (this.objectList[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.objectList.push(_loc4_);
            _loc3_++;
         }
    }

}