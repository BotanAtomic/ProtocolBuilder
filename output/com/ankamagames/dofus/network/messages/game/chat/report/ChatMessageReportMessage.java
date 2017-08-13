package com.ankamagames.dofus.network.messages.game.chat.report;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ChatMessageReportMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 821;
    private boolean _isInitialized = false;
    private String senderName = "";
    private String content = "";
    private int timestamp = 0;
    private int channel = 0;
    private String fingerprint = "";
    private int reason = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 821;
    }

    public ChatMessageReportMessage initChatMessageReportMessage(String param1,String  param2,int  param3,int  param4,String  param5,int  param6) {
         this.senderName = param1;
         this.content = param2;
         this.timestamp = param3;
         this.channel = param4;
         this.fingerprint = param5;
         this.reason = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.senderName = "";
         this.content = "";
         this.timestamp = 0;
         this.channel = 0;
         this.fingerprint = "";
         this.reason = 0;
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
         this.serializeAs_ChatMessageReportMessage(param1);
    }

    public void serializeAs_ChatMessageReportMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.senderName);
         param1.writeUTF(this.content);
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
         }
         param1.writeInt(this.timestamp);
         param1.writeByte(this.channel);
         param1.writeUTF(this.fingerprint);
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element reason.");
         }
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatMessageReportMessage(param1);
    }

    public void deserializeAs_ChatMessageReportMessage(ICustomDataInput param1) {
         this._senderNameFunc(param1);
         this._contentFunc(param1);
         this._timestampFunc(param1);
         this._channelFunc(param1);
         this._fingerprintFunc(param1);
         this._reasonFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatMessageReportMessage(param1);
    }

    public void deserializeAsyncAs_ChatMessageReportMessage(FuncTree param1) {
         param1.addChild(this._senderNameFunc);
         param1.addChild(this._contentFunc);
         param1.addChild(this._timestampFunc);
         param1.addChild(this._channelFunc);
         param1.addChild(this._fingerprintFunc);
         param1.addChild(this._reasonFunc);
    }

    private void _senderNameFunc(ICustomDataInput param1) {
         this.senderName = param1.readUTF();
    }

    private void _contentFunc(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

    private void _timestampFunc(ICustomDataInput param1) {
         this.timestamp = param1.readInt();
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element of ChatMessageReportMessage.timestamp.");
         }
    }

    private void _channelFunc(ICustomDataInput param1) {
         this.channel = param1.readByte();
         if(this.channel < 0)
         {
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChatMessageReportMessage.channel.");
         }
    }

    private void _fingerprintFunc(ICustomDataInput param1) {
         this.fingerprint = param1.readUTF();
    }

    private void _reasonFunc(ICustomDataInput param1) {
         this.reason = param1.readByte();
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element of ChatMessageReportMessage.reason.");
         }
    }

}