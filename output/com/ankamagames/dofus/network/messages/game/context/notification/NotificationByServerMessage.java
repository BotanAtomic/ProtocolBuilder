package package com.ankamagames.dofus.network.messages.game.context.notification;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class NotificationByServerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6103;
    private boolean _isInitialized = false;
    private int id = 0;
    private Vector.<String> parameters = ;
    private boolean forceOpen = false;
    private FuncTree _parameterstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6103;
    }

    public NotificationByServerMessage initNotificationByServerMessage(int param1,Vector.<String>  param2,boolean  param3) {
         this.id = param1;
         this.parameters = param2;
         this.forceOpen = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.parameters = new Vector.<String>();
         this.forceOpen = false;
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
         this.serializeAs_NotificationByServerMessage(param1);
    }

    public void serializeAs_NotificationByServerMessage(ICustomDataOutput param1) {
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NotificationByServerMessage(param1);
    }

    public void deserializeAs_NotificationByServerMessage(ICustomDataInput param1) {
         String _loc4_ = null;
         this._idFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUTF();
            this.parameters.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NotificationByServerMessage(param1);
    }

    public void deserializeAsyncAs_NotificationByServerMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
         this._parameterstree = param1.addChild(this._parameterstreeFunc);
         param1.addChild(this._forceOpenFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element of NotificationByServerMessage.id.");
    }

    private void _parameterstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._parameterstree.addChild(this._parametersFunc);
            _loc3_++;
    }

    private void _parametersFunc(ICustomDataInput param1) {
         String _loc2_ = param1.readUTF();
         this.parameters.push(_loc2_);
    }

    private void _forceOpenFunc(ICustomDataInput param1) {
         this.forceOpen = param1.readBoolean();
    }

}