package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InventoryContentMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3016;
    private boolean _isInitialized = false;
    private Vector.<ObjectItem> objects = ;
    private Number kamas = 0;
    private FuncTree _objectstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 3016;
    }

    public InventoryContentMessage initInventoryContentMessage(Vector.<ObjectItem> param1,Number  param2) {
         this.objects = param1;
         this.kamas = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objects = new Vector.<ObjectItem>();
         this.kamas = 0;
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
         this.serializeAs_InventoryContentMessage(param1);
    }

    public void serializeAs_InventoryContentMessage(ICustomDataOutput param1) {
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
            (this.objects[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryContentMessage(param1);
    }

    public void deserializeAs_InventoryContentMessage(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.objects.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryContentMessage(param1);
    }

    public void deserializeAsyncAs_InventoryContentMessage(FuncTree param1) {
         this._objectstree = param1.addChild(this._objectstreeFunc);
         param1.addChild(this._kamasFunc);
    }

    private void _objectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectstree.addChild(this._objectsFunc);
            _loc3_++;
    }

    private void _objectsFunc(ICustomDataInput param1) {
         ObjectItem _loc2_ = new ObjectItem();
         _loc2_.deserialize(param1);
         this.objects.push(_loc2_);
    }

    private void _kamasFunc(ICustomDataInput param1) {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kamas + ") on element of InventoryContentMessage.kamas.");
    }

}