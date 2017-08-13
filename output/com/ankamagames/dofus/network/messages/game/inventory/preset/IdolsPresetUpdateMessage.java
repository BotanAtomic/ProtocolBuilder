package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.IdolsPreset;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolsPresetUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6606;
    private boolean _isInitialized = false;
    private IdolsPreset idolsPreset;
    private FuncTree _idolsPresettree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6606;
    }

    public IdolsPresetUpdateMessage initIdolsPresetUpdateMessage(IdolsPreset param1) {
         this.idolsPreset = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.idolsPreset = new IdolsPreset();
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
         this.serializeAs_IdolsPresetUpdateMessage(param1);
    }

    public void serializeAs_IdolsPresetUpdateMessage(ICustomDataOutput param1) {
         this.idolsPreset.serializeAs_IdolsPreset(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolsPresetUpdateMessage(param1);
    }

    public void deserializeAs_IdolsPresetUpdateMessage(ICustomDataInput param1) {
         this.idolsPreset = new IdolsPreset();
         this.idolsPreset.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolsPresetUpdateMessage(param1);
    }

    public void deserializeAsyncAs_IdolsPresetUpdateMessage(FuncTree param1) {
         this._idolsPresettree = param1.addChild(this._idolsPresettreeFunc);
    }

    private void _idolsPresettreeFunc(ICustomDataInput param1) {
         this.idolsPreset = new IdolsPreset();
         this.idolsPreset.deserializeAsync(this._idolsPresettree);
    }

}