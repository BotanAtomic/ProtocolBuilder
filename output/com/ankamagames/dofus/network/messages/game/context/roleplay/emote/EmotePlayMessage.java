package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class EmotePlayMessage extends EmotePlayAbstractMessage implements INetworkMessage {

    private int protocolId = 5683;
    private boolean _isInitialized = false;
    private Number actorId = 0;
    private int accountId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5683;
    }

    public EmotePlayMessage initEmotePlayMessage(int param1,Number  param2,Number  param3,int  param4) {
         super.initEmotePlayAbstractMessage(param1,param2);
         this.actorId = param3;
         this.accountId = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.actorId = 0;
         this.accountId = 0;
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
         this.serializeAs_EmotePlayMessage(param1);
    }

    public void serializeAs_EmotePlayMessage(ICustomDataOutput param1) {
         super.serializeAs_EmotePlayAbstractMessage(param1);
         if(this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.actorId + ") on element actorId.");
         }
         param1.writeDouble(this.actorId);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EmotePlayMessage(param1);
    }

    public void deserializeAs_EmotePlayMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._actorIdFunc(param1);
         this._accountIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EmotePlayMessage(param1);
    }

    public void deserializeAsyncAs_EmotePlayMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._actorIdFunc);
         param1.addChild(this._accountIdFunc);
    }

    private void _actorIdFunc(ICustomDataInput param1) {
         this.actorId = param1.readDouble();
         if(this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.actorId + ") on element of EmotePlayMessage.actorId.");
         }
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of EmotePlayMessage.accountId.");
         }
    }

}