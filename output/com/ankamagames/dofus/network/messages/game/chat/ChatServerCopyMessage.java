package package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ChatServerCopyMessage extends ChatAbstractServerMessage implements INetworkMessage {

    private int protocolId = 882;
    private boolean _isInitialized = false;
    private Number receiverId = 0;
    private String receiverName = "";


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 882;
    }

    public ChatServerCopyMessage initChatServerCopyMessage(int param1,String  param2,int  param3,String  param4,Number  param5,String  param6) {
         super.initChatAbstractServerMessage(param1,param2,param3,param4);
         this.receiverId = param5;
         this.receiverName = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.receiverId = 0;
         this.receiverName = "";
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
         this.serializeAs_ChatServerCopyMessage(param1);
    }

    public void serializeAs_ChatServerCopyMessage(ICustomDataOutput param1) {
         super.serializeAs_ChatAbstractServerMessage(param1);
         if(this.receiverId < 0 || this.receiverId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.receiverId + ") on element receiverId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatServerCopyMessage(param1);
    }

    public void deserializeAs_ChatServerCopyMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._receiverIdFunc(param1);
         this._receiverNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatServerCopyMessage(param1);
    }

    public void deserializeAsyncAs_ChatServerCopyMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._receiverIdFunc);
         param1.addChild(this._receiverNameFunc);
    }

    private void _receiverIdFunc(ICustomDataInput param1) {
         this.receiverId = param1.readVarUhLong();
         if(this.receiverId < 0 || this.receiverId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.receiverId + ") on element of ChatServerCopyMessage.receiverId.");
    }

    private void _receiverNameFunc(ICustomDataInput param1) {
         this.receiverName = param1.readUTF();
    }

}