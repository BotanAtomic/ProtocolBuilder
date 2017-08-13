package package com.ankamagames.dofus.network.messages.game.interactive.meeting;

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
import java.lang.Exception;

public class TeleportBuddiesRequestedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6302;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private Number inviterId = 0;
    private Vector.<Number> invalidBuddiesIds = ;
    private FuncTree _invalidBuddiesIdstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6302;
    }

    public TeleportBuddiesRequestedMessage initTeleportBuddiesRequestedMessage(int param1,Number  param2,Vector.<Number>  param3) {
         this.dungeonId = param1;
         this.inviterId = param2;
         this.invalidBuddiesIds = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dungeonId = 0;
         this.inviterId = 0;
         this.invalidBuddiesIds = new Vector.<Number>();
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
         this.serializeAs_TeleportBuddiesRequestedMessage(param1);
    }

    public void serializeAs_TeleportBuddiesRequestedMessage(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TeleportBuddiesRequestedMessage(param1);
    }

    public void deserializeAs_TeleportBuddiesRequestedMessage(ICustomDataInput param1) {
         * _loc4_ = NaN;
         this._dungeonIdFunc(param1);
         this._inviterIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhLong();
            if(_loc4_ < 0 || _loc4_ > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of invalidBuddiesIds.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TeleportBuddiesRequestedMessage(param1);
    }

    public void deserializeAsyncAs_TeleportBuddiesRequestedMessage(FuncTree param1) {
         param1.addChild(this._dungeonIdFunc);
         param1.addChild(this._inviterIdFunc);
         this._invalidBuddiesIdstree = param1.addChild(this._invalidBuddiesIdstreeFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of TeleportBuddiesRequestedMessage.dungeonId.");
    }

    private void _inviterIdFunc(ICustomDataInput param1) {
         this.inviterId = param1.readVarUhLong();
         if(this.inviterId < 0 || this.inviterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.inviterId + ") on element of TeleportBuddiesRequestedMessage.inviterId.");
    }

    private void _invalidBuddiesIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._invalidBuddiesIdstree.addChild(this._invalidBuddiesIdsFunc);
            _loc3_++;
    }

    private void _invalidBuddiesIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of invalidBuddiesIds.");
    }

}