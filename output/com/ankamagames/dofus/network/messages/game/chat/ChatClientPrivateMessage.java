package package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatClientPrivateMessage extends ChatAbstractClientMessage implements INetworkMessage {

    private int protocolId = 851;
    private boolean _isInitialized = false;
    private String receiver = "";


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 851;
    }

    public ChatClientPrivateMessage initChatClientPrivateMessage(String param1,String  param2) {
         super.initChatAbstractClientMessage(param1);
         this.receiver = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.receiver = "";
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
         this.serializeAs_ChatClientPrivateMessage(param1);
    }

    public void serializeAs_ChatClientPrivateMessage(ICustomDataOutput param1) {
         super.serializeAs_ChatAbstractClientMessage(param1);
         param1.writeUTF(this.receiver);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatClientPrivateMessage(param1);
    }

    public void deserializeAs_ChatClientPrivateMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._receiverFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatClientPrivateMessage(param1);
    }

    public void deserializeAsyncAs_ChatClientPrivateMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._receiverFunc);
    }

    private void _receiverFunc(ICustomDataInput param1) {
         this.receiver = param1.readUTF();
    }

}