package package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.version.Version;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationFailedForBadVersionMessage extends IdentificationFailedMessage implements INetworkMessage {

    private int protocolId = 21;
    private boolean _isInitialized = false;
    private Version requiredVersion = ;
    private FuncTree _requiredVersiontree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 21;
    }

    public IdentificationFailedForBadVersionMessage initIdentificationFailedForBadVersionMessage(int param1,Version  param2) {
         super.initIdentificationFailedMessage(param1);
         this.requiredVersion = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.requiredVersion = new Version();
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
         this.serializeAs_IdentificationFailedForBadVersionMessage(param1);
    }

    public void serializeAs_IdentificationFailedForBadVersionMessage(ICustomDataOutput param1) {
         super.serializeAs_IdentificationFailedMessage(param1);
         this.requiredVersion.serializeAs_Version(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationFailedForBadVersionMessage(param1);
    }

    public void deserializeAs_IdentificationFailedForBadVersionMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.requiredVersion = new Version();
         this.requiredVersion.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdentificationFailedForBadVersionMessage(param1);
    }

    public void deserializeAsyncAs_IdentificationFailedForBadVersionMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._requiredVersiontree = param1.addChild(this._requiredVersiontreeFunc);
    }

    private void _requiredVersiontreeFunc(ICustomDataInput param1) {
         this.requiredVersion = new Version();
         this.requiredVersion.deserializeAsync(this._requiredVersiontree);
    }

}