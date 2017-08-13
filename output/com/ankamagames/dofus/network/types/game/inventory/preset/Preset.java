package com.ankamagames.dofus.network.types.game.inventory.preset;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class Preset extends Object implements INetworkType {

    private int protocolId = 355;
    private int presetId = 0;
    private int symbolId = 0;
    private boolean mount = false;
    private Vector<PresetItem> objects;
    private FuncTree _objectstree;


    public int getTypeId() {
         return 355;
    }

    public Preset initPreset(int param1,int  param2,boolean  param3,Vector<PresetItem>  param4) {
         this.presetId = param1;
         this.symbolId = param2;
         this.mount = param3;
         this.objects = param4;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.symbolId = 0;
         this.mount = false;
         this.objects = new Vector.<PresetItem>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_Preset(param1);
    }

    public void serializeAs_Preset(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element symbolId.");
         }
         param1.writeByte(this.symbolId);
         param1.writeBoolean(this.mount);
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
         {
            (this.objects[_loc2_] as PresetItem).serializeAs_PresetItem(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_Preset(param1);
    }

    public void deserializeAs_Preset(ICustomDataInput param1) {
         PresetItem _loc4_ = null;
         this._presetIdFunc(param1);
         this._symbolIdFunc(param1);
         this._mountFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PresetItem();
            _loc4_.deserialize(param1);
            this.objects.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_Preset(param1);
    }

    public void deserializeAsyncAs_Preset(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._symbolIdFunc);
         param1.addChild(this._mountFunc);
         this._objectstree = param1.addChild(this._objectstreeFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of Preset.presetId.");
         }
    }

    private void _symbolIdFunc(ICustomDataInput param1) {
         this.symbolId = param1.readByte();
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element of Preset.symbolId.");
         }
    }

    private void _mountFunc(ICustomDataInput param1) {
         this.mount = param1.readBoolean();
    }

    private void _objectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._objectstree.addChild(this._objectsFunc);
            _loc3_++;
         }
    }

    private void _objectsFunc(ICustomDataInput param1) {
         PresetItem _loc2_ = new PresetItem();
         _loc2_.deserialize(param1);
         this.objects.push(_loc2_);
    }

}