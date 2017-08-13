package package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5634;
    private boolean _isInitialized = false;
    private int reason = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5634;
    }

    public TaxCollectorErrorMessage initTaxCollectorErrorMessage(int param1) {
         this.reason = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.reason = 0;
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
         this.serializeAs_TaxCollectorErrorMessage(param1);
    }

    public void serializeAs_TaxCollectorErrorMessage(ICustomDataOutput param1) {
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorErrorMessage(param1);
    }

    public void deserializeAs_TaxCollectorErrorMessage(ICustomDataInput param1) {
         this._reasonFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorErrorMessage(param1);
    }

    public void deserializeAsyncAs_TaxCollectorErrorMessage(FuncTree param1) {
         param1.addChild(this._reasonFunc);
    }

    private void _reasonFunc(ICustomDataInput param1) {
         this.reason = param1.readByte();
    }

}