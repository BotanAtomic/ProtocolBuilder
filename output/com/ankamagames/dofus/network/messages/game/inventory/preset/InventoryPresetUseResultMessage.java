package com.ankamagames.dofus.network.messages.game.inventory.preset;

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

public class InventoryPresetUseResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6163;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private int code = 3;
    private Vector<uint> unlinkedPosition;
    private FuncTree _unlinkedPositiontree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6163;
    }

    public InventoryPresetUseResultMessage initInventoryPresetUseResultMessage(int param1,int  param2,Vector<uint>  param3) {
         this.presetId = param1;
         this.code = param2;
         this.unlinkedPosition = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.code = 3;
         this.unlinkedPosition = new Vector.<uint>();
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
         this.serializeAs_InventoryPresetUseResultMessage(param1);
    }

    public void serializeAs_InventoryPresetUseResultMessage(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         param1.writeByte(this.code);
         param1.writeShort(this.unlinkedPosition.length);
         int _loc2_ = 0;
         while(_loc2_ < this.unlinkedPosition.length)
         {
            param1.writeByte(this.unlinkedPosition[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetUseResultMessage(param1);
    }

    public void deserializeAs_InventoryPresetUseResultMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         this._presetIdFunc(param1);
         this._codeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedByte();
            if(_loc4_ < 0 || _loc4_ > 255)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of unlinkedPosition.");
            }
            this.unlinkedPosition.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetUseResultMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetUseResultMessage(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._codeFunc);
         this._unlinkedPositiontree = param1.addChild(this._unlinkedPositiontreeFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of InventoryPresetUseResultMessage.presetId.");
         }
    }

    private void _codeFunc(ICustomDataInput param1) {
         this.code = param1.readByte();
         if(this.code < 0)
         {
            throw new Exception("Forbidden value (" + this.code + ") on element of InventoryPresetUseResultMessage.code.");
         }
    }

    private void _unlinkedPositiontreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._unlinkedPositiontree.addChild(this._unlinkedPositionFunc);
            _loc3_++;
         }
    }

    private void _unlinkedPositionFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedByte();
         if(_loc2_ < 0 || _loc2_ > 255)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of unlinkedPosition.");
         }
         this.unlinkedPosition.push(_loc2_);
    }

}