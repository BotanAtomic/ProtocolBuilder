package package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SocialNoticeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6688;
    private boolean _isInitialized = false;
    private String content = "";
    private int timestamp = 0;
    private Number memberId = 0;
    private String memberName = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6688;
    }

    public SocialNoticeMessage initSocialNoticeMessage(String param1,int  param2,Number  param3,String  param4) {
         this.content = param1;
         this.timestamp = param2;
         this.memberId = param3;
         this.memberName = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.content = "";
         this.timestamp = 0;
         this.memberId = 0;
         this.memberName = "";
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
         this.serializeAs_SocialNoticeMessage(param1);
    }

    public void serializeAs_SocialNoticeMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.content);
         if(this.timestamp < 0)
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SocialNoticeMessage(param1);
    }

    public void deserializeAs_SocialNoticeMessage(ICustomDataInput param1) {
         this._contentFunc(param1);
         this._timestampFunc(param1);
         this._memberIdFunc(param1);
         this._memberNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SocialNoticeMessage(param1);
    }

    public void deserializeAsyncAs_SocialNoticeMessage(FuncTree param1) {
         param1.addChild(this._contentFunc);
         param1.addChild(this._timestampFunc);
         param1.addChild(this._memberIdFunc);
         param1.addChild(this._memberNameFunc);
    }

    private void _contentFunc(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

    private void _timestampFunc(ICustomDataInput param1) {
         this.timestamp = param1.readInt();
         if(this.timestamp < 0)
            throw new Exception("Forbidden value (" + this.timestamp + ") on element of SocialNoticeMessage.timestamp.");
    }

    private void _memberIdFunc(ICustomDataInput param1) {
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.memberId + ") on element of SocialNoticeMessage.memberId.");
    }

    private void _memberNameFunc(ICustomDataInput param1) {
         this.memberName = param1.readUTF();
    }

}