package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CheckIntegrityMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6372;
    private boolean _isInitialized = false;
    private Vector<int> data;
    private FuncTree _datatree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6372;
    }

    public CheckIntegrityMessage initCheckIntegrityMessage(Vector<int> param1) {
         this.data = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.data = new Vector.<int>();
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
         this.serializeAs_CheckIntegrityMessage(param1);
    }

    public void serializeAs_CheckIntegrityMessage(ICustomDataOutput param1) {
         param1.writeVarInt(this.data.length);
         int _loc2_ = 0;
         while(_loc2_ < this.data.length)
         {
            param1.writeByte(this.data[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CheckIntegrityMessage(param1);
    }

    public void deserializeAs_CheckIntegrityMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readByte();
            this.data.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CheckIntegrityMessage(param1);
    }

    public void deserializeAsyncAs_CheckIntegrityMessage(FuncTree param1) {
         this._datatree = param1.addChild(this._datatreeFunc);
    }

    private void _datatreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._datatree.addChild(this._dataFunc);
            _loc3_++;
         }
    }

    private void _dataFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.data.push(_loc2_);
    }

}