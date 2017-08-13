package package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InventoryPresetItemUpdateErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6211;
    private boolean _isInitialized = false;
    private int code = 1;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6211;
    }

    public InventoryPresetItemUpdateErrorMessage initInventoryPresetItemUpdateErrorMessage(int param1) {
         this.code = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.code = 1;
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
         this.serializeAs_InventoryPresetItemUpdateErrorMessage(param1);
    }

    public void serializeAs_InventoryPresetItemUpdateErrorMessage(ICustomDataOutput param1) {
         param1.writeByte(this.code);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetItemUpdateErrorMessage(param1);
    }

    public void deserializeAs_InventoryPresetItemUpdateErrorMessage(ICustomDataInput param1) {
         this._codeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetItemUpdateErrorMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetItemUpdateErrorMessage(FuncTree param1) {
         param1.addChild(this._codeFunc);
    }

    private void _codeFunc(ICustomDataInput param1) {
         this.code = param1.readByte();
         if(this.code < 0)
            throw new Exception("Forbidden value (" + this.code + ") on element of InventoryPresetItemUpdateErrorMessage.code.");
    }

}