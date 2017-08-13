package package com.ankamagames.dofus.network.messages.game.chat.smiley;

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

public class ChatSmileyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 801;
    private boolean _isInitialized = false;
    private Number entityId = 0;
    private int smileyId = 0;
    private int accountId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 801;
    }

    public ChatSmileyMessage initChatSmileyMessage(Number param1,int  param2,int  param3) {
         this.entityId = param1;
         this.smileyId = param2;
         this.accountId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.entityId = 0;
         this.smileyId = 0;
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
         this.serializeAs_ChatSmileyMessage(param1);
    }

    public void serializeAs_ChatSmileyMessage(ICustomDataOutput param1) {
         if(this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.entityId + ") on element entityId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatSmileyMessage(param1);
    }

    public void deserializeAs_ChatSmileyMessage(ICustomDataInput param1) {
         this._entityIdFunc(param1);
         this._smileyIdFunc(param1);
         this._accountIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatSmileyMessage(param1);
    }

    public void deserializeAsyncAs_ChatSmileyMessage(FuncTree param1) {
         param1.addChild(this._entityIdFunc);
         param1.addChild(this._smileyIdFunc);
         param1.addChild(this._accountIdFunc);
    }

    private void _entityIdFunc(ICustomDataInput param1) {
         this.entityId = param1.readDouble();
         if(this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.entityId + ") on element of ChatSmileyMessage.entityId.");
    }

    private void _smileyIdFunc(ICustomDataInput param1) {
         this.smileyId = param1.readVarUhShort();
         if(this.smileyId < 0)
            throw new Exception("Forbidden value (" + this.smileyId + ") on element of ChatSmileyMessage.smileyId.");
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element of ChatSmileyMessage.accountId.");
    }

}