package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class OnConnectionEventMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5726;
    private boolean _isInitialized = false;
    private int eventType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5726;
    }

    public OnConnectionEventMessage initOnConnectionEventMessage(int param1) {
         this.eventType = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.eventType = 0;
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
         this.serializeAs_OnConnectionEventMessage(param1);
    }

    public void serializeAs_OnConnectionEventMessage(ICustomDataOutput param1) {
         param1.writeByte(this.eventType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_OnConnectionEventMessage(param1);
    }

    public void deserializeAs_OnConnectionEventMessage(ICustomDataInput param1) {
         this._eventTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_OnConnectionEventMessage(param1);
    }

    public void deserializeAsyncAs_OnConnectionEventMessage(FuncTree param1) {
         param1.addChild(this._eventTypeFunc);
    }

    private void _eventTypeFunc(ICustomDataInput param1) {
         this.eventType = param1.readByte();
         if(this.eventType < 0)
         {
            throw new Exception("Forbidden value (" + this.eventType + ") on element of OnConnectionEventMessage.eventType.");
         }
    }

}