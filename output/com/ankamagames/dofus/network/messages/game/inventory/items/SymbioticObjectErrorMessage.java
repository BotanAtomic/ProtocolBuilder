package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SymbioticObjectErrorMessage extends ObjectErrorMessage implements INetworkMessage {

    private int protocolId = 6526;
    private boolean _isInitialized = false;
    private int errorCode = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6526;
    }

    public SymbioticObjectErrorMessage initSymbioticObjectErrorMessage(int param1,int  param2) {
         super.initObjectErrorMessage(param1);
         this.errorCode = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.errorCode = 0;
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
         this.serializeAs_SymbioticObjectErrorMessage(param1);
    }

    public void serializeAs_SymbioticObjectErrorMessage(ICustomDataOutput param1) {
         super.serializeAs_ObjectErrorMessage(param1);
         param1.writeByte(this.errorCode);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SymbioticObjectErrorMessage(param1);
    }

    public void deserializeAs_SymbioticObjectErrorMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._errorCodeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SymbioticObjectErrorMessage(param1);
    }

    public void deserializeAsyncAs_SymbioticObjectErrorMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._errorCodeFunc);
    }

    private void _errorCodeFunc(ICustomDataInput param1) {
         this.errorCode = param1.readByte();
    }

}