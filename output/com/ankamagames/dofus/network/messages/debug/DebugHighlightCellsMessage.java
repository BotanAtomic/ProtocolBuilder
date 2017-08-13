package com.ankamagames.dofus.network.messages.debug;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DebugHighlightCellsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 2001;
    private boolean _isInitialized = false;
    private int color = 0;
    private Vector<uint> cells;
    private FuncTree _cellstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 2001;
    }

    public DebugHighlightCellsMessage initDebugHighlightCellsMessage(int param1,Vector<uint>  param2) {
         this.color = param1;
         this.cells = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.color = 0;
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
         this.serializeAs_DebugHighlightCellsMessage(param1);
    }

    public void serializeAs_DebugHighlightCellsMessage(ICustomDataOutput param1) {
         param1.writeInt(this.color);
         param1.writeShort(this.cells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cells.length)
         {
            if(this.cells[_loc2_] < 0 || this.cells[_loc2_] > 559)
            {
               throw new Exception("Forbidden value (" + this.cells[_loc2_] + ") on element 2 (starting at 1) of cells.");
            }
            param1.writeVarShort(this.cells[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DebugHighlightCellsMessage(param1);
    }

    public void deserializeAs_DebugHighlightCellsMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         this._colorFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0 || _loc4_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of cells.");
            }
            this.cells.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DebugHighlightCellsMessage(param1);
    }

    public void deserializeAsyncAs_DebugHighlightCellsMessage(FuncTree param1) {
         param1.addChild(this._colorFunc);
         this._cellstree = param1.addChild(this._cellstreeFunc);
    }

    private void _colorFunc(ICustomDataInput param1) {
         this.color = param1.readInt();
    }

    private void _cellstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._cellstree.addChild(this._cellsFunc);
            _loc3_++;
         }
    }

    private void _cellsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of cells.");
         }
         this.cells.push(_loc2_);
    }

}