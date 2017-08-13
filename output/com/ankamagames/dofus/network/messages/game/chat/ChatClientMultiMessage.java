package package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChatClientMultiMessage extends ChatAbstractClientMessage implements INetworkMessage {

    private int protocolId = 861;
    private boolean _isInitialized = false;
    private int channel = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 861;
    }

    public ChatClientMultiMessage initChatClientMultiMessage(String param1,int  param2) {
         super.initChatAbstractClientMessage(param1);
         this.channel = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.channel = 0;
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
         this.serializeAs_ChatClientMultiMessage(param1);
    }

    public void serializeAs_ChatClientMultiMessage(ICustomDataOutput param1) {
         super.serializeAs_ChatAbstractClientMessage(param1);
         param1.writeByte(this.channel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatClientMultiMessage(param1);
    }

    public void deserializeAs_ChatClientMultiMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._channelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatClientMultiMessage(param1);
    }

    public void deserializeAsyncAs_ChatClientMultiMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._channelFunc);
    }

    private void _channelFunc(ICustomDataInput param1) {
         this.channel = param1.readByte();
         if(this.channel < 0)
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChatClientMultiMessage.channel.");
    }

}