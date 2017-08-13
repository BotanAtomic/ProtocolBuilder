package com.ankamagames.dofus.network.messages.game.context.notification;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NotificationListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6087;
    private boolean _isInitialized = false;
    private Vector<int> flags;
    private FuncTree _flagstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6087;
    }

    public NotificationListMessage initNotificationListMessage(Vector<int> param1) {
         this.flags = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.flags = new Vector.<int>();
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
         this.serializeAs_NotificationListMessage(param1);
    }

    public void serializeAs_NotificationListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.flags.length);
         int _loc2_ = 0;
         while(_loc2_ < this.flags.length)
         {
            param1.writeVarInt(this.flags[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NotificationListMessage(param1);
    }

    public void deserializeAs_NotificationListMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarInt();
            this.flags.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NotificationListMessage(param1);
    }

    public void deserializeAsyncAs_NotificationListMessage(FuncTree param1) {
         this._flagstree = param1.addChild(this._flagstreeFunc);
    }

    private void _flagstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._flagstree.addChild(this._flagsFunc);
            _loc3_++;
         }
    }

    private void _flagsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         this.flags.push(_loc2_);
    }

}