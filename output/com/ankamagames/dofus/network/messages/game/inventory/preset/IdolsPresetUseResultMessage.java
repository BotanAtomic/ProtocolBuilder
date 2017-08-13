package package com.ankamagames.dofus.network.messages.game.inventory.preset;

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

public class IdolsPresetUseResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6614;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private int code = 3;
    private Vector.<uint> missingIdols = ;
    private FuncTree _missingIdolstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6614;
    }

    public IdolsPresetUseResultMessage initIdolsPresetUseResultMessage(int param1,int  param2,Vector.<uint>  param3) {
         this.presetId = param1;
         this.code = param2;
         this.missingIdols = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.code = 3;
         this.missingIdols = new Vector.<uint>();
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
         this.serializeAs_IdolsPresetUseResultMessage(param1);
    }

    public void serializeAs_IdolsPresetUseResultMessage(ICustomDataOutput param1) {
         if(this.presetId < 0)
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolsPresetUseResultMessage(param1);
    }

    public void deserializeAs_IdolsPresetUseResultMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         this._presetIdFunc(param1);
         this._codeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of missingIdols.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolsPresetUseResultMessage(param1);
    }

    public void deserializeAsyncAs_IdolsPresetUseResultMessage(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._codeFunc);
         this._missingIdolstree = param1.addChild(this._missingIdolstreeFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
            throw new Exception("Forbidden value (" + this.presetId + ") on element of IdolsPresetUseResultMessage.presetId.");
    }

    private void _codeFunc(ICustomDataInput param1) {
         this.code = param1.readByte();
         if(this.code < 0)
            throw new Exception("Forbidden value (" + this.code + ") on element of IdolsPresetUseResultMessage.code.");
    }

    private void _missingIdolstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._missingIdolstree.addChild(this._missingIdolsFunc);
            _loc3_++;
    }

    private void _missingIdolsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of missingIdols.");
    }

}