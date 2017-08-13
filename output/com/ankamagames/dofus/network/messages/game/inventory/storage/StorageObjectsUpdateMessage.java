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
    private Vector<ObjectItem> objectList;
    private FuncTree _objectListtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6036;
    }

    public StorageObjectsUpdateMessage initStorageObjectsUpdateMessage(Vector<ObjectItem> param1) {
         this.objectList = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectList = new Vector.<ObjectItem>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StorageObjectsUpdateMessage(param1);
    }

    public void serializeAs_StorageObjectsUpdateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.objectList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectList.length)
         {
            (this.objectList[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StorageObjectsUpdateMessage(param1);
    }

    public void deserializeAs_StorageObjectsUpdateMessage(ICustomDataInput param1) {
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

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StorageObjectsUpdateMessage(param1);
    }

    public void deserializeAsyncAs_StorageObjectsUpdateMessage(FuncTree param1) {
         this._objectListtree = param1.addChild(this._objectListtreeFunc);
    }

    private void _objectListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._objectListtree.addChild(this._objectListFunc);
            _loc3_++;
         }
    }

    private void _objectListFunc(ICustomDataInput param1) {
         ObjectItem _loc2_ = new ObjectItem();
         _loc2_.deserialize(param1);
         this.objectList.push(_loc2_);
    }

}