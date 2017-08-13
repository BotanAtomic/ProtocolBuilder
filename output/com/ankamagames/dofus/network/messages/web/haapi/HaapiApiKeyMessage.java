package package com.ankamagames.dofus.network.messages.web.haapi;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class HaapiApiKeyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6649;
    private boolean _isInitialized = false;
    private int returnType = 0;
    private int keyType = 0;
    private String token = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6649;
    }

    public HaapiApiKeyMessage initHaapiApiKeyMessage(int param1,int  param2,String  param3) {
         this.returnType = param1;
         this.keyType = param2;
         this.token = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.returnType = 0;
         this.keyType = 0;
         this.token = "";
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
         this.serializeAs_HaapiApiKeyMessage(param1);
    }

    public void serializeAs_HaapiApiKeyMessage(ICustomDataOutput param1) {
         param1.writeByte(this.returnType);
         param1.writeByte(this.keyType);
         param1.writeUTF(this.token);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HaapiApiKeyMessage(param1);
    }

    public void deserializeAs_HaapiApiKeyMessage(ICustomDataInput param1) {
         this._returnTypeFunc(param1);
         this._keyTypeFunc(param1);
         this._tokenFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HaapiApiKeyMessage(param1);
    }

    public void deserializeAsyncAs_HaapiApiKeyMessage(FuncTree param1) {
         param1.addChild(this._returnTypeFunc);
         param1.addChild(this._keyTypeFunc);
         param1.addChild(this._tokenFunc);
    }

    private void _returnTypeFunc(ICustomDataInput param1) {
         this.returnType = param1.readByte();
         if(this.returnType < 0)
            throw new Exception("Forbidden value (" + this.returnType + ") on element of HaapiApiKeyMessage.returnType.");
    }

    private void _keyTypeFunc(ICustomDataInput param1) {
         this.keyType = param1.readByte();
         if(this.keyType < 0)
            throw new Exception("Forbidden value (" + this.keyType + ") on element of HaapiApiKeyMessage.keyType.");
    }

    private void _tokenFunc(ICustomDataInput param1) {
         this.token = param1.readUTF();
    }

}