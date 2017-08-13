package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaSwitchToGameServerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6574;
    private boolean _isInitialized = false;
    private boolean validToken = false;
    private Vector<int> ticket;
    private int homeServerId = 0;
    private FuncTree _tickettree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6574;
    }

    public GameRolePlayArenaSwitchToGameServerMessage initGameRolePlayArenaSwitchToGameServerMessage(boolean param1,Vector<int>  param2,int  param3) {
         this.validToken = param1;
         this.ticket = param2;
         this.homeServerId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.validToken = false;
         this.ticket = new Vector.<int>();
         this.homeServerId = 0;
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
         this.serializeAs_GameRolePlayArenaSwitchToGameServerMessage(param1);
    }

    public void serializeAs_GameRolePlayArenaSwitchToGameServerMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.validToken);
         param1.writeVarInt(this.ticket.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ticket.length)
         {
            param1.writeByte(this.ticket[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.homeServerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaSwitchToGameServerMessage(param1);
    }

    public void deserializeAs_GameRolePlayArenaSwitchToGameServerMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         this._validTokenFunc(param1);
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readByte();
            this.ticket.push(_loc4_);
            _loc3_++;
         }
         this._homeServerIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayArenaSwitchToGameServerMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayArenaSwitchToGameServerMessage(FuncTree param1) {
         param1.addChild(this._validTokenFunc);
         this._tickettree = param1.addChild(this._tickettreeFunc);
         param1.addChild(this._homeServerIdFunc);
    }

    private void _validTokenFunc(ICustomDataInput param1) {
         this.validToken = param1.readBoolean();
    }

    private void _tickettreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._tickettree.addChild(this._ticketFunc);
            _loc3_++;
         }
    }

    private void _ticketFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.ticket.push(_loc2_);
    }

    private void _homeServerIdFunc(ICustomDataInput param1) {
         this.homeServerId = param1.readShort();
    }

}