package com.ankamagames.dofus.network.messages.game.inventory.preset;

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

public class InventoryPresetItemUpdateRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6210;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private int position = 63;
    private int objUid = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6210;
    }

    public InventoryPresetItemUpdateRequestMessage initInventoryPresetItemUpdateRequestMessage(int param1,int  param2,int  param3) {
         this.presetId = param1;
         this.position = param2;
         this.objUid = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.position = 63;
         this.objUid = 0;
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
         this.serializeAs_InventoryPresetItemUpdateRequestMessage(param1);
    }

    public void serializeAs_InventoryPresetItemUpdateRequestMessage(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         param1.writeByte(this.position);
         if(this.objUid < 0)
         {
            throw new Exception("Forbidden value (" + this.objUid + ") on element objUid.");
         }
         param1.writeVarInt(this.objUid);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryPresetItemUpdateRequestMessage(param1);
    }

    public void deserializeAs_InventoryPresetItemUpdateRequestMessage(ICustomDataInput param1) {
         this._presetIdFunc(param1);
         this._positionFunc(param1);
         this._objUidFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryPresetItemUpdateRequestMessage(param1);
    }

    public void deserializeAsyncAs_InventoryPresetItemUpdateRequestMessage(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._positionFunc);
         param1.addChild(this._objUidFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of InventoryPresetItemUpdateRequestMessage.presetId.");
         }
    }

    private void _positionFunc(ICustomDataInput param1) {
         this.position = param1.readUnsignedByte();
         if(this.position < 0 || this.position > 255)
         {
            throw new Exception("Forbidden value (" + this.position + ") on element of InventoryPresetItemUpdateRequestMessage.position.");
         }
    }

    private void _objUidFunc(ICustomDataInput param1) {
         this.objUid = param1.readVarUhInt();
         if(this.objUid < 0)
         {
            throw new Exception("Forbidden value (" + this.objUid + ") on element of InventoryPresetItemUpdateRequestMessage.objUid.");
         }
    }

}