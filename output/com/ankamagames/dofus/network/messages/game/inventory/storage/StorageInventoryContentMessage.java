package package com.ankamagames.dofus.network.messages.game.inventory.storage;

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


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5646;
    }

    public StorageInventoryContentMessage initStorageInventoryContentMessage(Vector.<ObjectItem> param1,Number  param2) {
         super.initInventoryContentMessage(param1,param2);
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
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
         this.serializeAs_StorageInventoryContentMessage(param1);
    }

    public void serializeAs_StorageInventoryContentMessage(ICustomDataOutput param1) {
         super.serializeAs_InventoryContentMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StorageInventoryContentMessage(param1);
    }

    public void deserializeAs_StorageInventoryContentMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StorageInventoryContentMessage(param1);
    }

    public void deserializeAsyncAs_StorageInventoryContentMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}