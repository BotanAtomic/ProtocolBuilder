package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ChatServerMessage extends ChatAbstractServerMessage implements INetworkMessage {

    private int protocolId = 881;
    private boolean _isInitialized = false;
    private Number senderId = 0;
    private String senderName = "";
    private int senderAccountId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 881;
    }

    public ChatServerMessage initChatServerMessage(int param1,String  param2,int  param3,String  param4,Number  param5,String  param6,int  param7) {
         super.initChatAbstractServerMessage(param1,param2,param3,param4);
         this.senderId = param5;
         this.senderName = param6;
         this.senderAccountId = param7;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.senderId = 0;
         this.senderName = "";
         this.senderAccountId = 0;
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
         this.serializeAs_ChatServerMessage(param1);
    }

    public void serializeAs_ChatServerMessage(ICustomDataOutput param1) {
         super.serializeAs_ChatAbstractServerMessage(param1);
         if(this.senderId < -9.007199254740992E15 || this.senderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.senderId + ") on element senderId.");
         }
         param1.writeDouble(this.senderId);
         param1.writeUTF(this.senderName);
         if(this.senderAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.senderAccountId + ") on element senderAccountId.");
         }
         param1.writeInt(this.senderAccountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatServerMessage(param1);
    }

    public void deserializeAs_ChatServerMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._senderIdFunc(param1);
         this._senderNameFunc(param1);
         this._senderAccountIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatServerMessage(param1);
    }

    public void deserializeAsyncAs_ChatServerMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._senderIdFunc);
         param1.addChild(this._senderNameFunc);
         param1.addChild(this._senderAccountIdFunc);
    }

    private void _senderIdFunc(ICustomDataInput param1) {
         this.senderId = param1.readDouble();
         if(this.senderId < -9.007199254740992E15 || this.senderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.senderId + ") on element of ChatServerMessage.senderId.");
         }
    }

    private void _senderNameFunc(ICustomDataInput param1) {
         this.senderName = param1.readUTF();
    }

    private void _senderAccountIdFunc(ICustomDataInput param1) {
         this.senderAccountId = param1.readInt();
         if(this.senderAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.senderAccountId + ") on element of ChatServerMessage.senderAccountId.");
         }
    }

}