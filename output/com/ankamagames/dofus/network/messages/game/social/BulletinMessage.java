package package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class BulletinMessage extends SocialNoticeMessage implements INetworkMessage {

    private int protocolId = 6695;
    private boolean _isInitialized = false;
    private int lastNotifiedTimestamp = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6695;
    }

    public BulletinMessage initBulletinMessage(String param1,int  param2,Number  param3,String  param4,int  param5) {
         super.initSocialNoticeMessage(param1,param2,param3,param4);
         this.lastNotifiedTimestamp = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.lastNotifiedTimestamp = 0;
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
         this.serializeAs_BulletinMessage(param1);
    }

    public void serializeAs_BulletinMessage(ICustomDataOutput param1) {
         super.serializeAs_SocialNoticeMessage(param1);
         if(this.lastNotifiedTimestamp < 0)
            throw new Exception("Forbidden value (" + this.lastNotifiedTimestamp + ") on element lastNotifiedTimestamp.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BulletinMessage(param1);
    }

    public void deserializeAs_BulletinMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._lastNotifiedTimestampFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BulletinMessage(param1);
    }

    public void deserializeAsyncAs_BulletinMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._lastNotifiedTimestampFunc);
    }

    private void _lastNotifiedTimestampFunc(ICustomDataInput param1) {
         this.lastNotifiedTimestamp = param1.readInt();
         if(this.lastNotifiedTimestamp < 0)
            throw new Exception("Forbidden value (" + this.lastNotifiedTimestamp + ") on element of BulletinMessage.lastNotifiedTimestamp.");
    }

}