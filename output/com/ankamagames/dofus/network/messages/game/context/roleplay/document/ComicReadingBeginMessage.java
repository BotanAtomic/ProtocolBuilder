package package com.ankamagames.dofus.network.messages.game.context.roleplay.document;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ComicReadingBeginMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6536;
    private boolean _isInitialized = false;
    private int comicId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6536;
    }

    public ComicReadingBeginMessage initComicReadingBeginMessage(int param1) {
         this.comicId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.comicId = 0;
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
         this.serializeAs_ComicReadingBeginMessage(param1);
    }

    public void serializeAs_ComicReadingBeginMessage(ICustomDataOutput param1) {
         if(this.comicId < 0)
            throw new Exception("Forbidden value (" + this.comicId + ") on element comicId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ComicReadingBeginMessage(param1);
    }

    public void deserializeAs_ComicReadingBeginMessage(ICustomDataInput param1) {
         this._comicIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ComicReadingBeginMessage(param1);
    }

    public void deserializeAsyncAs_ComicReadingBeginMessage(FuncTree param1) {
         param1.addChild(this._comicIdFunc);
    }

    private void _comicIdFunc(ICustomDataInput param1) {
         this.comicId = param1.readVarUhShort();
         if(this.comicId < 0)
            throw new Exception("Forbidden value (" + this.comicId + ") on element of ComicReadingBeginMessage.comicId.");
    }

}