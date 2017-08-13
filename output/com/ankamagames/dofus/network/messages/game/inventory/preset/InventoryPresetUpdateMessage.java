package package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.Preset;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6171;
    private boolean _isInitialized = false;
    private Preset preset = ;
    private FuncTree _presettree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6171;
    }

    public InventoryPresetUpdateMessage initInventoryPresetUpdateMessage(Preset param1) {
         this.preset = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.preset = new Preset();
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
         this.serializeAs_InventoryPresetUpdateMessage(param1);
    }

    public void serializeAs_InventoryPresetUpdateMessage(ICustomDataOutput param1) {
         this.preset.serializeAs_Preset(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetUpdateMessage(param1);
    }

    public void deserializeAs_InventoryPresetUpdateMessage(ICustomDataInput param1) {
         this.preset = new Preset();
         this.preset.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetUpdateMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetUpdateMessage(FuncTree param1) {
         this._presettree = param1.addChild(this._presettreeFunc);
    }

    private void _presettreeFunc(ICustomDataInput param1) {
         this.preset = new Preset();
         this.preset.deserializeAsync(this._presettree);
    }

}