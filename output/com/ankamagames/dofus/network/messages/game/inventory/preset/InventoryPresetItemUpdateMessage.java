package package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.PresetItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class InventoryPresetItemUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6168;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private PresetItem presetItem = ;
    private FuncTree _presetItemtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6168;
    }

    public InventoryPresetItemUpdateMessage initInventoryPresetItemUpdateMessage(int param1,PresetItem  param2) {
         this.presetId = param1;
         this.presetItem = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.presetItem = new PresetItem();
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
         this.serializeAs_InventoryPresetItemUpdateMessage(param1);
    }

    public void serializeAs_InventoryPresetItemUpdateMessage(ICustomDataOutput param1) {
         if(this.presetId < 0)
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetItemUpdateMessage(param1);
    }

    public void deserializeAs_InventoryPresetItemUpdateMessage(ICustomDataInput param1) {
         this._presetIdFunc(param1);
         this.presetItem = new PresetItem();
         this.presetItem.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetItemUpdateMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetItemUpdateMessage(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         this._presetItemtree = param1.addChild(this._presetItemtreeFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
            throw new Exception("Forbidden value (" + this.presetId + ") on element of InventoryPresetItemUpdateMessage.presetId.");
    }

    private void _presetItemtreeFunc(ICustomDataInput param1) {
         this.presetItem = new PresetItem();
         this.presetItem.deserializeAsync(this._presetItemtree);
    }

}