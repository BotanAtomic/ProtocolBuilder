package package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameContextRemoveElementWithEventMessage extends GameContextRemoveElementMessage implements INetworkMessage {

    private int protocolId = 6412;
    private boolean _isInitialized = false;
    private int elementEventId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6412;
    }

    public GameContextRemoveElementWithEventMessage initGameContextRemoveElementWithEventMessage(Number param1,int  param2) {
         super.initGameContextRemoveElementMessage(param1);
         this.elementEventId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.elementEventId = 0;
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
         this.serializeAs_GameContextRemoveElementWithEventMessage(param1);
    }

    public void serializeAs_GameContextRemoveElementWithEventMessage(ICustomDataOutput param1) {
         super.serializeAs_GameContextRemoveElementMessage(param1);
         if(this.elementEventId < 0)
            throw new Exception("Forbidden value (" + this.elementEventId + ") on element elementEventId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextRemoveElementWithEventMessage(param1);
    }

    public void deserializeAs_GameContextRemoveElementWithEventMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._elementEventIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextRemoveElementWithEventMessage(param1);
    }

    public void deserializeAsyncAs_GameContextRemoveElementWithEventMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._elementEventIdFunc);
    }

    private void _elementEventIdFunc(ICustomDataInput param1) {
         this.elementEventId = param1.readByte();
         if(this.elementEventId < 0)
            throw new Exception("Forbidden value (" + this.elementEventId + ") on element of GameContextRemoveElementWithEventMessage.elementEventId.");
    }

}