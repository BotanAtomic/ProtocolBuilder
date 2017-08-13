package package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetSaveResultMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetSaveResultMessage extends AbstractPresetSaveResultMessage implements INetworkMessage {

    private int protocolId = 6170;
    private boolean _isInitialized = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6170;
    }

    public InventoryPresetSaveResultMessage initInventoryPresetSaveResultMessage(int param1,int  param2) {
         super.initAbstractPresetSaveResultMessage(param1,param2);
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
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
         this.serializeAs_InventoryPresetSaveResultMessage(param1);
    }

    public void serializeAs_InventoryPresetSaveResultMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPresetSaveResultMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetSaveResultMessage(param1);
    }

    public void deserializeAs_InventoryPresetSaveResultMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetSaveResultMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetSaveResultMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}