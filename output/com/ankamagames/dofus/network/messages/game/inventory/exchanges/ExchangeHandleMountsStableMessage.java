package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeHandleMountsStableMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6562;
    private boolean _isInitialized = false;
    private int actionType = 0;
    private Vector.<uint> ridesId = ;
    private FuncTree _ridesIdtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6562;
    }

    public ExchangeHandleMountsStableMessage initExchangeHandleMountsStableMessage(int param1,Vector.<uint>  param2) {
         this.actionType = param1;
         this.ridesId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.actionType = 0;
         this.ridesId = new Vector.<uint>();
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
         this.serializeAs_ExchangeHandleMountsStableMessage(param1);
    }

    public void serializeAs_ExchangeHandleMountsStableMessage(ICustomDataOutput param1) {
         param1.writeByte(this.actionType);
         param1.writeShort(this.ridesId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ridesId.length)
            if(this.ridesId[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.ridesId[_loc2_] + ") on element 2 (starting at 1) of ridesId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeHandleMountsStableMessage(param1);
    }

    public void deserializeAs_ExchangeHandleMountsStableMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         this._actionTypeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhInt();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of ridesId.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeHandleMountsStableMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeHandleMountsStableMessage(FuncTree param1) {
         param1.addChild(this._actionTypeFunc);
         this._ridesIdtree = param1.addChild(this._ridesIdtreeFunc);
    }

    private void _actionTypeFunc(ICustomDataInput param1) {
         this.actionType = param1.readByte();
    }

    private void _ridesIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._ridesIdtree.addChild(this._ridesIdFunc);
            _loc3_++;
    }

    private void _ridesIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ridesId.");
    }

}