package package com.ankamagames.dofus.network.types.game.inventory.preset;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class IdolsPreset extends Object implements INetworkType {

    private int protocolId = 491;
    private int presetId = 0;
    private int symbolId = 0;
    private Vector.<uint> idolId = ;
    private FuncTree _idolIdtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 491;
    }

    public IdolsPreset initIdolsPreset(int param1,int  param2,Vector.<uint>  param3) {
         this.presetId = param1;
         this.symbolId = param2;
         this.idolId = param3;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.symbolId = 0;
         this.idolId = new Vector.<uint>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_IdolsPreset(param1);
    }

    public void serializeAs_IdolsPreset(ICustomDataOutput param1) {
         if(this.presetId < 0)
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolsPreset(param1);
    }

    public void deserializeAs_IdolsPreset(ICustomDataInput param1) {
         int _loc4_ = 0;
         this._presetIdFunc(param1);
         this._symbolIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of idolId.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolsPreset(param1);
    }

    public void deserializeAsyncAs_IdolsPreset(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._symbolIdFunc);
         this._idolIdtree = param1.addChild(this._idolIdtreeFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
            throw new Exception("Forbidden value (" + this.presetId + ") on element of IdolsPreset.presetId.");
    }

    private void _symbolIdFunc(ICustomDataInput param1) {
         this.symbolId = param1.readByte();
         if(this.symbolId < 0)
            throw new Exception("Forbidden value (" + this.symbolId + ") on element of IdolsPreset.symbolId.");
    }

    private void _idolIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._idolIdtree.addChild(this._idolIdFunc);
            _loc3_++;
    }

    private void _idolIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of idolId.");
    }

}