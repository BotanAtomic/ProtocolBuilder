package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class BasicTimeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 175;
    private boolean _isInitialized = false;
    private Number timestamp = 0;
    private int timezoneOffset = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 175;
    }

    public BasicTimeMessage initBasicTimeMessage(Number param1,int  param2) {
         this.timestamp = param1;
         this.timezoneOffset = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.timestamp = 0;
         this.timezoneOffset = 0;
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
         this.serializeAs_BasicTimeMessage(param1);
    }

    public void serializeAs_BasicTimeMessage(ICustomDataOutput param1) {
         if(this.timestamp < 0 || this.timestamp > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
         }
         param1.writeDouble(this.timestamp);
         param1.writeShort(this.timezoneOffset);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicTimeMessage(param1);
    }

    public void deserializeAs_BasicTimeMessage(ICustomDataInput param1) {
         this._timestampFunc(param1);
         this._timezoneOffsetFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicTimeMessage(param1);
    }

    public void deserializeAsyncAs_BasicTimeMessage(FuncTree param1) {
         param1.addChild(this._timestampFunc);
         param1.addChild(this._timezoneOffsetFunc);
    }

    private void _timestampFunc(ICustomDataInput param1) {
         this.timestamp = param1.readDouble();
         if(this.timestamp < 0 || this.timestamp > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element of BasicTimeMessage.timestamp.");
         }
    }

    private void _timezoneOffsetFunc(ICustomDataInput param1) {
         this.timezoneOffset = param1.readShort();
    }

}