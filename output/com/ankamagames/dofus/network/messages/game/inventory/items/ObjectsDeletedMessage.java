package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectsDeletedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6034;
    private boolean _isInitialized = false;
    private Vector<uint> objectUID;
    private FuncTree _objectUIDtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6034;
    }

    public ObjectsDeletedMessage initObjectsDeletedMessage(Vector<uint> param1) {
         this.objectUID = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectUID = new Vector.<uint>();
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
         this.serializeAs_ObjectsDeletedMessage(param1);
    }

    public void serializeAs_ObjectsDeletedMessage(ICustomDataOutput param1) {
         param1.writeShort(this.objectUID.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectUID.length)
         {
            if(this.objectUID[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.objectUID[_loc2_] + ") on element 1 (starting at 1) of objectUID.");
            }
            param1.writeVarInt(this.objectUID[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectsDeletedMessage(param1);
    }

    public void deserializeAs_ObjectsDeletedMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhInt();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of objectUID.");
            }
            this.objectUID.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectsDeletedMessage(param1);
    }

    public void deserializeAsyncAs_ObjectsDeletedMessage(FuncTree param1) {
         this._objectUIDtree = param1.addChild(this._objectUIDtreeFunc);
    }

    private void _objectUIDtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._objectUIDtree.addChild(this._objectUIDFunc);
            _loc3_++;
         }
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of objectUID.");
         }
         this.objectUID.push(_loc2_);
    }

}