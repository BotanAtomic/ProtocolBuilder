package package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ClientKeyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5607;
    private boolean _isInitialized = false;
    private String key = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5607;
    }

    public ClientKeyMessage initClientKeyMessage(String param1) {
         this.key = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.key = "";
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
            HASH_FUNCTION(_loc2_);
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
         this.serializeAs_ClientKeyMessage(param1);
    }

    public void serializeAs_ClientKeyMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.key);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ClientKeyMessage(param1);
    }

    public void deserializeAs_ClientKeyMessage(ICustomDataInput param1) {
         this._keyFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ClientKeyMessage(param1);
    }

    public void deserializeAsyncAs_ClientKeyMessage(FuncTree param1) {
         param1.addChild(this._keyFunc);
    }

    private void _keyFunc(ICustomDataInput param1) {
         this.key = param1.readUTF();
    }

}