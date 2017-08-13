package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class WrapperObjectAssociatedMessage extends SymbioticObjectAssociatedMessage implements INetworkMessage {

    private int protocolId = 6523;
    private boolean _isInitialized = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6523;
    }

    public WrapperObjectAssociatedMessage initWrapperObjectAssociatedMessage(int param1) {
         super.initSymbioticObjectAssociatedMessage(param1);
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
         this.serializeAs_WrapperObjectAssociatedMessage(param1);
    }

    public void serializeAs_WrapperObjectAssociatedMessage(ICustomDataOutput param1) {
         super.serializeAs_SymbioticObjectAssociatedMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_WrapperObjectAssociatedMessage(param1);
    }

    public void deserializeAs_WrapperObjectAssociatedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_WrapperObjectAssociatedMessage(param1);
    }

    public void deserializeAsyncAs_WrapperObjectAssociatedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}