package package com.ankamagames.dofus.network.messages.game.chat.smiley;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class LocalizedChatSmileyMessage extends ChatSmileyMessage implements INetworkMessage {

    private int protocolId = 6185;
    private boolean _isInitialized = false;
    private int cellId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6185;
    }

    public LocalizedChatSmileyMessage initLocalizedChatSmileyMessage(Number param1,int  param2,int  param3,int  param4) {
         super.initChatSmileyMessage(param1,param2,param3);
         this.cellId = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.cellId = 0;
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
         this.serializeAs_LocalizedChatSmileyMessage(param1);
    }

    public void serializeAs_LocalizedChatSmileyMessage(ICustomDataOutput param1) {
         super.serializeAs_ChatSmileyMessage(param1);
         if(this.cellId < 0 || this.cellId > 559)
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LocalizedChatSmileyMessage(param1);
    }

    public void deserializeAs_LocalizedChatSmileyMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._cellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LocalizedChatSmileyMessage(param1);
    }

    public void deserializeAsyncAs_LocalizedChatSmileyMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._cellIdFunc);
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
            throw new Exception("Forbidden value (" + this.cellId + ") on element of LocalizedChatSmileyMessage.cellId.");
    }

}