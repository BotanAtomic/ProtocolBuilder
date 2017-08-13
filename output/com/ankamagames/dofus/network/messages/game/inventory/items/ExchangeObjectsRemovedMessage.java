package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeObjectsRemovedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6532;
    private boolean _isInitialized = false;
    private Vector.<uint> objectUID = ;
    private FuncTree _objectUIDtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6532;
    }

    public ExchangeObjectsRemovedMessage initExchangeObjectsRemovedMessage(boolean param1,Vector.<uint>  param2) {
         super.initExchangeObjectMessage(param1);
         this.objectUID = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
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
         this.serializeAs_ExchangeObjectsRemovedMessage(param1);
    }

    public void serializeAs_ExchangeObjectsRemovedMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         param1.writeShort(this.objectUID.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectUID.length)
            if(this.objectUID[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.objectUID[_loc2_] + ") on element 1 (starting at 1) of objectUID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectsRemovedMessage(param1);
    }

    public void deserializeAs_ExchangeObjectsRemovedMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhInt();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of objectUID.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectsRemovedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectsRemovedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._objectUIDtree = param1.addChild(this._objectUIDtreeFunc);
    }

    private void _objectUIDtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectUIDtree.addChild(this._objectUIDFunc);
            _loc3_++;
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of objectUID.");
    }

}