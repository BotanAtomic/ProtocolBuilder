package package com.ankamagames.dofus.network.messages.game.approach;

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

public class AccountLoggingKickedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6029;
    private boolean _isInitialized = false;
    private int days = 0;
    private int hours = 0;
    private int minutes = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6029;
    }

    public AccountLoggingKickedMessage initAccountLoggingKickedMessage(int param1,int  param2,int  param3) {
         this.days = param1;
         this.hours = param2;
         this.minutes = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.days = 0;
         this.hours = 0;
         this.minutes = 0;
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
         this.serializeAs_AccountLoggingKickedMessage(param1);
    }

    public void serializeAs_AccountLoggingKickedMessage(ICustomDataOutput param1) {
         if(this.days < 0)
            throw new Exception("Forbidden value (" + this.days + ") on element days.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AccountLoggingKickedMessage(param1);
    }

    public void deserializeAs_AccountLoggingKickedMessage(ICustomDataInput param1) {
         this._daysFunc(param1);
         this._hoursFunc(param1);
         this._minutesFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AccountLoggingKickedMessage(param1);
    }

    public void deserializeAsyncAs_AccountLoggingKickedMessage(FuncTree param1) {
         param1.addChild(this._daysFunc);
         param1.addChild(this._hoursFunc);
         param1.addChild(this._minutesFunc);
    }

    private void _daysFunc(ICustomDataInput param1) {
         this.days = param1.readVarUhShort();
         if(this.days < 0)
            throw new Exception("Forbidden value (" + this.days + ") on element of AccountLoggingKickedMessage.days.");
    }

    private void _hoursFunc(ICustomDataInput param1) {
         this.hours = param1.readByte();
         if(this.hours < 0)
            throw new Exception("Forbidden value (" + this.hours + ") on element of AccountLoggingKickedMessage.hours.");
    }

    private void _minutesFunc(ICustomDataInput param1) {
         this.minutes = param1.readByte();
         if(this.minutes < 0)
            throw new Exception("Forbidden value (" + this.minutes + ") on element of AccountLoggingKickedMessage.minutes.");
    }

}