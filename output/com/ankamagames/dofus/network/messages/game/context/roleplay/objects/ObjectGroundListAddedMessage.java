package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

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

public class ObjectGroundListAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5925;
    private boolean _isInitialized = false;
    private Vector<uint> cells;
    private Vector<uint> referenceIds;
    private FuncTree _cellstree;
    private FuncTree _referenceIdstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5925;
    }

    public ObjectGroundListAddedMessage initObjectGroundListAddedMessage(Vector<uint> param1,Vector<uint>  param2) {
         this.cells = param1;
         this.referenceIds = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.cells = new Vector.<uint>();
         this.referenceIds = new Vector.<uint>();
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
         this.serializeAs_ObjectGroundListAddedMessage(param1);
    }

    public void serializeAs_ObjectGroundListAddedMessage(ICustomDataOutput param1) {
         param1.writeShort(this.cells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.cells.length)
         {
            if(this.cells[_loc2_] < 0 || this.cells[_loc2_] > 559)
            {
               throw new Exception("Forbidden value (" + this.cells[_loc2_] + ") on element 1 (starting at 1) of cells.");
            }
            param1.writeVarShort(this.cells[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.referenceIds.length);
         int _loc3_ = 0;
         while(_loc3_ < this.referenceIds.length)
         {
            if(this.referenceIds[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.referenceIds[_loc3_] + ") on element 2 (starting at 1) of referenceIds.");
            }
            param1.writeVarShort(this.referenceIds[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectGroundListAddedMessage(param1);
    }

    public void deserializeAs_ObjectGroundListAddedMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0 || _loc6_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of cells.");
            }
            this.cells.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhShort();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of referenceIds.");
            }
            this.referenceIds.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectGroundListAddedMessage(param1);
    }

    public void deserializeAsyncAs_ObjectGroundListAddedMessage(FuncTree param1) {
         this._cellstree = param1.addChild(this._cellstreeFunc);
         this._referenceIdstree = param1.addChild(this._referenceIdstreeFunc);
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

    private void _referenceIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._referenceIdstree.addChild(this._referenceIdsFunc);
            _loc3_++;
         }
    }

    private void _referenceIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of referenceIds.");
         }
         this.referenceIds.push(_loc2_);
    }

}