package package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectGroundRemovedMultipleMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5944;
    private boolean _isInitialized = false;
    private Vector.<uint> cells = ;
    private FuncTree _cellstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5944;
    }

    public ObjectGroundRemovedMultipleMessage initObjectGroundRemovedMultipleMessage(Vector.<uint> param1) {
         this.cells = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cells = new Vector.<uint>();
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
         this.serializeAs_ObjectGroundRemovedMultipleMessage(param1);
    }

    public void serializeAs_ObjectGroundRemovedMultipleMessage(ICustomDataOutput param1) {
         param1.writeShort(this.cells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cells.length)
            if(this.cells[_loc2_] < 0 || this.cells[_loc2_] > 559)
               throw new Exception("Forbidden value (" + this.cells[_loc2_] + ") on element 1 (starting at 1) of cells.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectGroundRemovedMultipleMessage(param1);
    }

    public void deserializeAs_ObjectGroundRemovedMultipleMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0 || _loc4_ > 559)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of cells.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectGroundRemovedMultipleMessage(param1);
    }

    public void deserializeAsyncAs_ObjectGroundRemovedMultipleMessage(FuncTree param1) {
         this._cellstree = param1.addChild(this._cellstreeFunc);
    }

    private void _cellstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._cellstree.addChild(this._cellsFunc);
            _loc3_++;
    }

    private void _cellsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of cells.");
    }

}