package package com.ankamagames.dofus.network.messages.game.basic;

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

public class BasicDateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 177;
    private boolean _isInitialized = false;
    private int day = 0;
    private int month = 0;
    private int year = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 177;
    }

    public BasicDateMessage initBasicDateMessage(int param1,int  param2,int  param3) {
         this.day = param1;
         this.month = param2;
         this.year = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.day = 0;
         this.month = 0;
         this.year = 0;
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
         this.serializeAs_BasicDateMessage(param1);
    }

    public void serializeAs_BasicDateMessage(ICustomDataOutput param1) {
         if(this.day < 0)
            throw new Exception("Forbidden value (" + this.day + ") on element day.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicDateMessage(param1);
    }

    public void deserializeAs_BasicDateMessage(ICustomDataInput param1) {
         this._dayFunc(param1);
         this._monthFunc(param1);
         this._yearFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicDateMessage(param1);
    }

    public void deserializeAsyncAs_BasicDateMessage(FuncTree param1) {
         param1.addChild(this._dayFunc);
         param1.addChild(this._monthFunc);
         param1.addChild(this._yearFunc);
    }

    private void _dayFunc(ICustomDataInput param1) {
         this.day = param1.readByte();
         if(this.day < 0)
            throw new Exception("Forbidden value (" + this.day + ") on element of BasicDateMessage.day.");
    }

    private void _monthFunc(ICustomDataInput param1) {
         this.month = param1.readByte();
         if(this.month < 0)
            throw new Exception("Forbidden value (" + this.month + ") on element of BasicDateMessage.month.");
    }

    private void _yearFunc(ICustomDataInput param1) {
         this.year = param1.readShort();
         if(this.year < 0)
            throw new Exception("Forbidden value (" + this.year + ") on element of BasicDateMessage.year.");
    }

}