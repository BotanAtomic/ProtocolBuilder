package package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class EmotePlayAbstractMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5690;
    private boolean _isInitialized = false;
    private int emoteId = 0;
    private Number emoteStartTime = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5690;
    }

    public EmotePlayAbstractMessage initEmotePlayAbstractMessage(int param1,Number  param2) {
         this.emoteId = param1;
         this.emoteStartTime = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.emoteId = 0;
         this.emoteStartTime = 0;
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
         this.serializeAs_EmotePlayAbstractMessage(param1);
    }

    public void serializeAs_EmotePlayAbstractMessage(ICustomDataOutput param1) {
         if(this.emoteId < 0 || this.emoteId > 255)
            throw new Exception("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EmotePlayAbstractMessage(param1);
    }

    public void deserializeAs_EmotePlayAbstractMessage(ICustomDataInput param1) {
         this._emoteIdFunc(param1);
         this._emoteStartTimeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EmotePlayAbstractMessage(param1);
    }

    public void deserializeAsyncAs_EmotePlayAbstractMessage(FuncTree param1) {
         param1.addChild(this._emoteIdFunc);
         param1.addChild(this._emoteStartTimeFunc);
    }

    private void _emoteIdFunc(ICustomDataInput param1) {
         this.emoteId = param1.readUnsignedByte();
         if(this.emoteId < 0 || this.emoteId > 255)
            throw new Exception("Forbidden value (" + this.emoteId + ") on element of EmotePlayAbstractMessage.emoteId.");
    }

    private void _emoteStartTimeFunc(ICustomDataInput param1) {
         this.emoteStartTime = param1.readDouble();
         if(this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.emoteStartTime + ") on element of EmotePlayAbstractMessage.emoteStartTime.");
    }

}