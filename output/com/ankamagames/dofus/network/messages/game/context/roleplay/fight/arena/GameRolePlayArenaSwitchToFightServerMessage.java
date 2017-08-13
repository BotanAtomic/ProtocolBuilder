package package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayArenaSwitchToFightServerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6575;
    private boolean _isInitialized = false;
    private String address = "";
    private Vector.<uint> ports = ;
    private Vector.<int> ticket = ;
    private FuncTree _portstree = ;
    private FuncTree _tickettree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private * _loc7_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readVarInt();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6575;
    }

    public GameRolePlayArenaSwitchToFightServerMessage initGameRolePlayArenaSwitchToFightServerMessage(String param1,Vector.<uint>  param2,Vector.<int>  param3) {
         this.address = param1;
         this.ports = param2;
         this.ticket = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.address = "";
         this.ports = new Vector.<uint>();
         this.ticket = new Vector.<int>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
            HASH_FUNCTION(_loc2_);
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
         this.serializeAs_GameRolePlayArenaSwitchToFightServerMessage(param1);
    }

    public void serializeAs_GameRolePlayArenaSwitchToFightServerMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.address);
         param1.writeShort(this.ports.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ports.length)
            if(this.ports[_loc2_] < 0 || this.ports[_loc2_] > 65535)
               throw new Exception("Forbidden value (" + this.ports[_loc2_] + ") on element 2 (starting at 1) of ports.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaSwitchToFightServerMessage(param1);
    }

    public void deserializeAs_GameRolePlayArenaSwitchToFightServerMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         * _loc7_ = 0;
         this._addressFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            if(_loc6_ < 0 || _loc6_ > 65535)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of ports.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayArenaSwitchToFightServerMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayArenaSwitchToFightServerMessage(FuncTree param1) {
         param1.addChild(this._addressFunc);
         this._portstree = param1.addChild(this._portstreeFunc);
         this._tickettree = param1.addChild(this._tickettreeFunc);
    }

    private void _addressFunc(ICustomDataInput param1) {
         this.address = param1.readUTF();
    }

    private void _portstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._portstree.addChild(this._portsFunc);
            _loc3_++;
    }

    private void _portsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         if(_loc2_ < 0 || _loc2_ > 65535)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ports.");
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