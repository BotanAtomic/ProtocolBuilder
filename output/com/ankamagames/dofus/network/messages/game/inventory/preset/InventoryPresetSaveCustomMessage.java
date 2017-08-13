package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetSaveMessage;
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

public class InventoryPresetSaveCustomMessage extends AbstractPresetSaveMessage implements INetworkMessage {

    private int protocolId = 6329;
    private boolean _isInitialized = false;
    private Vector<uint> itemsPositions;
    private Vector<uint> itemsUids;
    private FuncTree _itemsPositionstree;
    private FuncTree _itemsUidstree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6329;
    }

    public InventoryPresetSaveCustomMessage initInventoryPresetSaveCustomMessage(int param1,int  param2,Vector<uint>  param3,Vector<uint>  param4) {
         super.initAbstractPresetSaveMessage(param1,param2);
         this.itemsPositions = param3;
         this.itemsUids = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.itemsPositions = new Vector.<uint>();
         this.itemsUids = new Vector.<uint>();
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
         this.serializeAs_InventoryPresetSaveCustomMessage(param1);
    }

    public void serializeAs_InventoryPresetSaveCustomMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPresetSaveMessage(param1);
         param1.writeShort(this.itemsPositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.itemsPositions.length)
         {
            param1.writeByte(this.itemsPositions[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.itemsUids.length);
         int _loc3_ = 0;
         while(_loc3_ < this.itemsUids.length)
         {
            if(this.itemsUids[_loc3_] < 0)
            {
               throw new Exception("Forbidden value (" + this.itemsUids[_loc3_] + ") on element 2 (starting at 1) of itemsUids.");
            }
            param1.writeVarInt(this.itemsUids[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetSaveCustomMessage(param1);
    }

    public void deserializeAs_InventoryPresetSaveCustomMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedByte();
            if(_loc6_ < 0 || _loc6_ > 255)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of itemsPositions.");
            }
            this.itemsPositions.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhInt();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of itemsUids.");
            }
            this.itemsUids.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetSaveCustomMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetSaveCustomMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._itemsPositionstree = param1.addChild(this._itemsPositionstreeFunc);
         this._itemsUidstree = param1.addChild(this._itemsUidstreeFunc);
    }

    private void _itemsPositionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._itemsPositionstree.addChild(this._itemsPositionsFunc);
            _loc3_++;
         }
    }

    private void _itemsPositionsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedByte();
         if(_loc2_ < 0 || _loc2_ > 255)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of itemsPositions.");
         }
         this.itemsPositions.push(_loc2_);
    }

    private void _itemsUidstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._itemsUidstree.addChild(this._itemsUidsFunc);
            _loc3_++;
         }
    }

    private void _itemsUidsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of itemsUids.");
         }
         this.itemsUids.push(_loc2_);
    }

}