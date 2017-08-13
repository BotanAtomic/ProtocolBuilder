package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.Preset;
import com.ankamagames.dofus.network.types.game.inventory.preset.IdolsPreset;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryContentAndPresetMessage extends InventoryContentMessage implements INetworkMessage {

    private int protocolId = 6162;
    private boolean _isInitialized = false;
    private Vector<Preset> presets;
    private Vector<IdolsPreset> idolsPresets;
    private FuncTree _presetstree;
    private FuncTree _idolsPresetstree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6162;
    }

    public InventoryContentAndPresetMessage initInventoryContentAndPresetMessage(Vector<ObjectItem> param1,Number  param2,Vector<Preset>  param3,Vector<IdolsPreset>  param4) {
         super.initInventoryContentMessage(param1,param2);
         this.presets = param3;
         this.idolsPresets = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.presets = new Vector.<Preset>();
         this.idolsPresets = new Vector.<IdolsPreset>();
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
         this.serializeAs_InventoryContentAndPresetMessage(param1);
    }

    public void serializeAs_InventoryContentAndPresetMessage(ICustomDataOutput param1) {
         super.serializeAs_InventoryContentMessage(param1);
         param1.writeShort(this.presets.length);
         int _loc2_ = 0;
         while(_loc2_ < this.presets.length)
         {
            (this.presets[_loc2_] as Preset).serializeAs_Preset(param1);
            _loc2_++;
         }
         param1.writeShort(this.idolsPresets.length);
         int _loc3_ = 0;
         while(_loc3_ < this.idolsPresets.length)
         {
            (this.idolsPresets[_loc3_] as IdolsPreset).serializeAs_IdolsPreset(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryContentAndPresetMessage(param1);
    }

    public void deserializeAs_InventoryContentAndPresetMessage(ICustomDataInput param1) {
         Preset _loc6_ = null;
         IdolsPreset _loc7_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new Preset();
            _loc6_.deserialize(param1);
            this.presets.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new IdolsPreset();
            _loc7_.deserialize(param1);
            this.idolsPresets.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryContentAndPresetMessage(param1);
    }

    public void deserializeAsyncAs_InventoryContentAndPresetMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._presetstree = param1.addChild(this._presetstreeFunc);
         this._idolsPresetstree = param1.addChild(this._idolsPresetstreeFunc);
    }

    private void _presetstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._presetstree.addChild(this._presetsFunc);
            _loc3_++;
         }
    }

    private void _presetsFunc(ICustomDataInput param1) {
         Preset _loc2_ = new Preset();
         _loc2_.deserialize(param1);
         this.presets.push(_loc2_);
    }

    private void _idolsPresetstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._idolsPresetstree.addChild(this._idolsPresetsFunc);
            _loc3_++;
         }
    }

    private void _idolsPresetsFunc(ICustomDataInput param1) {
         IdolsPreset _loc2_ = new IdolsPreset();
         _loc2_.deserialize(param1);
         this.idolsPresets.push(_loc2_);
    }

}