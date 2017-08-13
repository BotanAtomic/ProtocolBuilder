package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MimicryObjectErrorMessage extends SymbioticObjectErrorMessage implements INetworkMessage {

    private int protocolId = 6461;
    private boolean _isInitialized = false;
    private boolean preview = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6461;
    }

    public MimicryObjectErrorMessage initMimicryObjectErrorMessage(int param1,int  param2,boolean  param3) {
         super.initSymbioticObjectErrorMessage(param1,param2);
         this.preview = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.preview = false;
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
         this.serializeAs_MimicryObjectErrorMessage(param1);
    }

    public void serializeAs_MimicryObjectErrorMessage(ICustomDataOutput param1) {
         super.serializeAs_SymbioticObjectErrorMessage(param1);
         param1.writeBoolean(this.preview);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MimicryObjectErrorMessage(param1);
    }

    public void deserializeAs_MimicryObjectErrorMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._previewFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MimicryObjectErrorMessage(param1);
    }

    public void deserializeAsyncAs_MimicryObjectErrorMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._previewFunc);
    }

    private void _previewFunc(ICustomDataInput param1) {
         this.preview = param1.readBoolean();
    }

}