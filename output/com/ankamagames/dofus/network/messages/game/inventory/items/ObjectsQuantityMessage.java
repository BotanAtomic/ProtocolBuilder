package package com.ankamagames.dofus.network.messages.game.inventory.items;

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
    private Vector.<ObjectItemQuantity> objectsUIDAndQty = ;
    private FuncTree _objectsUIDAndQtytree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6206;
    }

    public ObjectsQuantityMessage initObjectsQuantityMessage(Vector.<ObjectItemQuantity> param1) {
         this.objectsUIDAndQty = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectsUIDAndQty = new Vector.<ObjectItemQuantity>();
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
         this.serializeAs_ObjectsQuantityMessage(param1);
    }

    public void serializeAs_ObjectsQuantityMessage(ICustomDataOutput param1) {
         param1.writeShort(this.objectsUIDAndQty.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectsUIDAndQty.length)
            (this.objectsUIDAndQty[_loc2_] as ObjectItemQuantity).serializeAs_ObjectItemQuantity(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectsQuantityMessage(param1);
    }

    public void deserializeAs_ObjectsQuantityMessage(ICustomDataInput param1) {
         ObjectItemQuantity _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItemQuantity();
            _loc4_.deserialize(param1);
            this.objectsUIDAndQty.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectsQuantityMessage(param1);
    }

    public void deserializeAsyncAs_ObjectsQuantityMessage(FuncTree param1) {
         this._objectsUIDAndQtytree = param1.addChild(this._objectsUIDAndQtytreeFunc);
    }

    private void _objectsUIDAndQtytreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectsUIDAndQtytree.addChild(this._objectsUIDAndQtyFunc);
            _loc3_++;
    }

    private void _objectsUIDAndQtyFunc(ICustomDataInput param1) {
         ObjectItemQuantity _loc2_ = new ObjectItemQuantity();
         _loc2_.deserialize(param1);
         this.objectsUIDAndQty.push(_loc2_);
    }

}