package package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DareWonListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6682;
    private boolean _isInitialized = false;
    private Vector.<Number> dareId = ;
    private FuncTree _dareIdtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6682;
    }

    public DareWonListMessage initDareWonListMessage(Vector.<Number> param1) {
         this.dareId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dareId = new Vector.<Number>();
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
         this.serializeAs_DareWonListMessage(param1);
    }

    public void serializeAs_DareWonListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.dareId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dareId.length)
            if(this.dareId[_loc2_] < 0 || this.dareId[_loc2_] > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + this.dareId[_loc2_] + ") on element 1 (starting at 1) of dareId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareWonListMessage(param1);
    }

    public void deserializeAs_DareWonListMessage(ICustomDataInput param1) {
         * _loc4_ = NaN;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readDouble();
            if(_loc4_ < 0 || _loc4_ > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of dareId.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareWonListMessage(param1);
    }

    public void deserializeAsyncAs_DareWonListMessage(FuncTree param1) {
         this._dareIdtree = param1.addChild(this._dareIdtreeFunc);
    }

    private void _dareIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._dareIdtree.addChild(this._dareIdFunc);
            _loc3_++;
    }

    private void _dareIdFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readDouble();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of dareId.");
    }

}