package com.ankamagames.dofus.network.messages.game.context.fight;

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
import java.lang.Exception;

public class GameFightTurnListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 713;
    private boolean _isInitialized = false;
    private Vector<Number> ids;
    private Vector<Number> deadsIds;
    private FuncTree _idstree;
    private FuncTree _deadsIdstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 713;
    }

    public GameFightTurnListMessage initGameFightTurnListMessage(Vector<Number> param1,Vector<Number>  param2) {
         this.ids = param1;
         this.deadsIds = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ids = new Vector.<Number>();
         this.deadsIds = new Vector.<Number>();
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
         this.serializeAs_GameFightTurnListMessage(param1);
    }

    public void serializeAs_GameFightTurnListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.ids.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ids.length)
         {
            if(this.ids[_loc2_] < -9.007199254740992E15 || this.ids[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.ids[_loc2_] + ") on element 1 (starting at 1) of ids.");
            }
            param1.writeDouble(this.ids[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.deadsIds.length);
         int _loc3_ = 0;
         while(_loc3_ < this.deadsIds.length)
         {
            if(this.deadsIds[_loc3_] < -9.007199254740992E15 || this.deadsIds[_loc3_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.deadsIds[_loc3_] + ") on element 2 (starting at 1) of deadsIds.");
            }
            param1.writeDouble(this.deadsIds[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightTurnListMessage(param1);
    }

    public void deserializeAs_GameFightTurnListMessage(ICustomDataInput param1) {
         * _loc6_ = NaN;
         * _loc7_ = NaN;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readDouble();
            if(_loc6_ < -9.007199254740992E15 || _loc6_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of ids.");
            }
            this.ids.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readDouble();
            if(_loc7_ < -9.007199254740992E15 || _loc7_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of deadsIds.");
            }
            this.deadsIds.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightTurnListMessage(param1);
    }

    public void deserializeAsyncAs_GameFightTurnListMessage(FuncTree param1) {
         this._idstree = param1.addChild(this._idstreeFunc);
         this._deadsIdstree = param1.addChild(this._deadsIdstreeFunc);
    }

    private void _idstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._idstree.addChild(this._idsFunc);
            _loc3_++;
         }
    }

    private void _idsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readDouble();
         if(_loc2_ < -9.007199254740992E15 || _loc2_ > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ids.");
         }
         this.ids.push(_loc2_);
    }

    private void _deadsIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._deadsIdstree.addChild(this._deadsIdsFunc);
            _loc3_++;
         }
    }

    private void _deadsIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readDouble();
         if(_loc2_ < -9.007199254740992E15 || _loc2_ > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of deadsIds.");
         }
         this.deadsIds.push(_loc2_);
    }

}