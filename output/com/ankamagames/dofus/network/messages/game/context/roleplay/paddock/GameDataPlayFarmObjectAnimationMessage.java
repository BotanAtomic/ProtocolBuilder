package package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameDataPlayFarmObjectAnimationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6026;
    private boolean _isInitialized = false;
    private Vector.<uint> cellId = ;
    private FuncTree _cellIdtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6026;
    }

    public GameDataPlayFarmObjectAnimationMessage initGameDataPlayFarmObjectAnimationMessage(Vector.<uint> param1) {
         this.cellId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cellId = new Vector.<uint>();
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
         this.serializeAs_GameDataPlayFarmObjectAnimationMessage(param1);
    }

    public void serializeAs_GameDataPlayFarmObjectAnimationMessage(ICustomDataOutput param1) {
         param1.writeShort(this.cellId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cellId.length)
            if(this.cellId[_loc2_] < 0 || this.cellId[_loc2_] > 559)
               throw new Exception("Forbidden value (" + this.cellId[_loc2_] + ") on element 1 (starting at 1) of cellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameDataPlayFarmObjectAnimationMessage(param1);
    }

    public void deserializeAs_GameDataPlayFarmObjectAnimationMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0 || _loc4_ > 559)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of cellId.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameDataPlayFarmObjectAnimationMessage(param1);
    }

    public void deserializeAsyncAs_GameDataPlayFarmObjectAnimationMessage(FuncTree param1) {
         this._cellIdtree = param1.addChild(this._cellIdtreeFunc);
    }

    private void _cellIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._cellIdtree.addChild(this._cellIdFunc);
            _loc3_++;
    }

    private void _cellIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of cellId.");
    }

}