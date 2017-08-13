package com.ankamagames.dofus.network.messages.game.pvp;

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

public class UpdateMapPlayersAgressableStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6454;
    private boolean _isInitialized = false;
    private Vector<Number> playerIds;
    private Vector<uint> enable;
    private FuncTree _playerIdstree;
    private FuncTree _enabletree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6454;
    }

    public UpdateMapPlayersAgressableStatusMessage initUpdateMapPlayersAgressableStatusMessage(Vector<Number> param1,Vector<uint>  param2) {
         this.playerIds = param1;
         this.enable = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.playerIds = new Vector.<Number>();
         this.enable = new Vector.<uint>();
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
         this.serializeAs_UpdateMapPlayersAgressableStatusMessage(param1);
    }

    public void serializeAs_UpdateMapPlayersAgressableStatusMessage(ICustomDataOutput param1) {
         param1.writeShort(this.playerIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.playerIds.length)
         {
            if(this.playerIds[_loc2_] < 0 || this.playerIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.playerIds[_loc2_] + ") on element 1 (starting at 1) of playerIds.");
            }
            param1.writeVarLong(this.playerIds[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.enable.length);
         int _loc3_ = 0;
         while(_loc3_ < this.enable.length)
         {
            param1.writeByte(this.enable[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_UpdateMapPlayersAgressableStatusMessage(param1);
    }

    public void deserializeAs_UpdateMapPlayersAgressableStatusMessage(ICustomDataInput param1) {
         * _loc6_ = NaN;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhLong();
            if(_loc6_ < 0 || _loc6_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of playerIds.");
            }
            this.playerIds.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readByte();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of enable.");
            }
            this.enable.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_UpdateMapPlayersAgressableStatusMessage(param1);
    }

    public void deserializeAsyncAs_UpdateMapPlayersAgressableStatusMessage(FuncTree param1) {
         this._playerIdstree = param1.addChild(this._playerIdstreeFunc);
         this._enabletree = param1.addChild(this._enabletreeFunc);
    }

    private void _playerIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._playerIdstree.addChild(this._playerIdsFunc);
            _loc3_++;
         }
    }

    private void _playerIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of playerIds.");
         }
         this.playerIds.push(_loc2_);
    }

    private void _enabletreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._enabletree.addChild(this._enableFunc);
            _loc3_++;
         }
    }

    private void _enableFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of enable.");
         }
         this.enable.push(_loc2_);
    }

}