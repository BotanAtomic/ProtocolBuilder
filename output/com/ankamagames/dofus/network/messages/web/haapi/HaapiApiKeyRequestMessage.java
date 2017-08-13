package package com.ankamagames.dofus.network.messages.web.haapi;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HaapiApiKeyRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6648;
    private boolean _isInitialized = false;
    private int keyType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6648;
    }

    public HaapiApiKeyRequestMessage initHaapiApiKeyRequestMessage(int param1) {
         this.keyType = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.keyType = 0;
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
         this.serializeAs_HaapiApiKeyRequestMessage(param1);
    }

    public void serializeAs_HaapiApiKeyRequestMessage(ICustomDataOutput param1) {
         param1.writeByte(this.keyType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HaapiApiKeyRequestMessage(param1);
    }

    public void deserializeAs_HaapiApiKeyRequestMessage(ICustomDataInput param1) {
         this._keyTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HaapiApiKeyRequestMessage(param1);
    }

    public void deserializeAsyncAs_HaapiApiKeyRequestMessage(FuncTree param1) {
         param1.addChild(this._keyTypeFunc);
    }

    private void _keyTypeFunc(ICustomDataInput param1) {
         this.keyType = param1.readByte();
         if(this.keyType < 0)
            throw new Exception("Forbidden value (" + this.keyType + ") on element of HaapiApiKeyRequestMessage.keyType.");
    }

}