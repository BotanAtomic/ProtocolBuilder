package package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

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

public class ChallengeTargetsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5613;
    private boolean _isInitialized = false;
    private Vector.<Number> targetIds = ;
    private Vector.<int> targetCells = ;
    private FuncTree _targetIdstree = ;
    private FuncTree _targetCellstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private * _loc7_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5613;
    }

    public ChallengeTargetsListMessage initChallengeTargetsListMessage(Vector.<Number> param1,Vector.<int>  param2) {
         this.targetIds = param1;
         this.targetCells = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.targetIds = new Vector.<Number>();
         this.targetCells = new Vector.<int>();
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
         this.serializeAs_ChallengeTargetsListMessage(param1);
    }

    public void serializeAs_ChallengeTargetsListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.targetIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.targetIds.length)
            if(this.targetIds[_loc2_] < -9.007199254740992E15 || this.targetIds[_loc2_] > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + this.targetIds[_loc2_] + ") on element 1 (starting at 1) of targetIds.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChallengeTargetsListMessage(param1);
    }

    public void deserializeAs_ChallengeTargetsListMessage(ICustomDataInput param1) {
         * _loc6_ = NaN;
         * _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readDouble();
            if(_loc6_ < -9.007199254740992E15 || _loc6_ > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of targetIds.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChallengeTargetsListMessage(param1);
    }

    public void deserializeAsyncAs_ChallengeTargetsListMessage(FuncTree param1) {
         this._targetIdstree = param1.addChild(this._targetIdstreeFunc);
         this._targetCellstree = param1.addChild(this._targetCellstreeFunc);
    }

    private void _targetIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._targetIdstree.addChild(this._targetIdsFunc);
            _loc3_++;
    }

    private void _targetIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readDouble();
         if(_loc2_ < -9.007199254740992E15 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of targetIds.");
    }

    private void _targetCellstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._targetCellstree.addChild(this._targetCellsFunc);
            _loc3_++;
    }

    private void _targetCellsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readShort();
         if(_loc2_ < -1 || _loc2_ > 559)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of targetCells.");
    }

}