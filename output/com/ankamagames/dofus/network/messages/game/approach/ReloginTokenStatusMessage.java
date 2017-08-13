package package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ReloginTokenStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6539;
    private boolean _isInitialized = false;
    private boolean validToken = false;
    private Vector.<int> ticket = ;
    private FuncTree _tickettree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readVarInt();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6539;
    }

    public ReloginTokenStatusMessage initReloginTokenStatusMessage(boolean param1,Vector.<int>  param2) {
         this.validToken = param1;
         this.ticket = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.validToken = false;
         this.ticket = new Vector.<int>();
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
         this.serializeAs_ReloginTokenStatusMessage(param1);
    }

    public void serializeAs_ReloginTokenStatusMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.validToken);
         param1.writeVarInt(this.ticket.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ticket.length)
            param1.writeByte(this.ticket[_loc2_]);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ReloginTokenStatusMessage(param1);
    }

    public void deserializeAs_ReloginTokenStatusMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         this._validTokenFunc(param1);
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readByte();
            this.ticket.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ReloginTokenStatusMessage(param1);
    }

    public void deserializeAsyncAs_ReloginTokenStatusMessage(FuncTree param1) {
         param1.addChild(this._validTokenFunc);
         this._tickettree = param1.addChild(this._tickettreeFunc);
    }

    private void _validTokenFunc(ICustomDataInput param1) {
         this.validToken = param1.readBoolean();
    }

    private void _tickettreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._tickettree.addChild(this._ticketFunc);
            _loc3_++;
    }

    private void _ticketFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.ticket.push(_loc2_);
    }

}