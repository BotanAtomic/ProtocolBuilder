package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HelloConnectMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3;
    private boolean _isInitialized = false;
    private String salt = "";
    private Vector<int> key;
    private FuncTree _keytree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 3;
    }

    public HelloConnectMessage initHelloConnectMessage(String param1,Vector<int>  param2) {
         this.salt = param1;
         this.key = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.salt = "";
         this.key = new Vector.<int>();
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
         this.serializeAs_HelloConnectMessage(param1);
    }

    public void serializeAs_HelloConnectMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.salt);
         param1.writeVarInt(this.key.length);
         int _loc2_ = 0;
         while(_loc2_ < this.key.length)
         {
            param1.writeByte(this.key[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HelloConnectMessage(param1);
    }

    public void deserializeAs_HelloConnectMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         this._saltFunc(param1);
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readByte();
            this.key.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HelloConnectMessage(param1);
    }

    public void deserializeAsyncAs_HelloConnectMessage(FuncTree param1) {
         param1.addChild(this._saltFunc);
         this._keytree = param1.addChild(this._keytreeFunc);
    }

    private void _saltFunc(ICustomDataInput param1) {
         this.salt = param1.readUTF();
    }

    private void _keytreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._keytree.addChild(this._keyFunc);
            _loc3_++;
         }
    }

    private void _keyFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.key.push(_loc2_);
    }

}