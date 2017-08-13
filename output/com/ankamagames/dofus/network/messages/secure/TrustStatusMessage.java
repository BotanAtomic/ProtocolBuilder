package package com.ankamagames.dofus.network.messages.secure;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class TrustStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6267;
    private boolean _isInitialized = false;
    private boolean trusted = false;
    private boolean certified = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6267;
    }

    public TrustStatusMessage initTrustStatusMessage(boolean param1,boolean  param2) {
         this.trusted = param1;
         this.certified = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.trusted = false;
         this.certified = false;
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
         this.serializeAs_TrustStatusMessage(param1);
    }

    public void serializeAs_TrustStatusMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.trusted);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.certified);
         param1.writeByte(_loc2_);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TrustStatusMessage(param1);
    }

    public void deserializeAs_TrustStatusMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TrustStatusMessage(param1);
    }

    public void deserializeAsyncAs_TrustStatusMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.trusted = BooleanByteWrapper.getFlag(_loc2_,0);
         this.certified = BooleanByteWrapper.getFlag(_loc2_,1);
    }

}