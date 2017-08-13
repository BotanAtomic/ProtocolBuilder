package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetSaveMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetSaveMessage extends AbstractPresetSaveMessage implements INetworkMessage {

    private int protocolId = 6165;
    private boolean _isInitialized = false;
    private boolean saveEquipment = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6165;
    }

    public InventoryPresetSaveMessage initInventoryPresetSaveMessage(int param1,int  param2,boolean  param3) {
         super.initAbstractPresetSaveMessage(param1,param2);
         this.saveEquipment = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.saveEquipment = false;
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
         this.serializeAs_InventoryPresetSaveMessage(param1);
    }

    public void serializeAs_InventoryPresetSaveMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPresetSaveMessage(param1);
         param1.writeBoolean(this.saveEquipment);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetSaveMessage(param1);
    }

    public void deserializeAs_InventoryPresetSaveMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._saveEquipmentFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetSaveMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetSaveMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._saveEquipmentFunc);
    }

    private void _saveEquipmentFunc(ICustomDataInput param1) {
         this.saveEquipment = param1.readBoolean();
    }

}