package package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.updater.ContentPart;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartInfoMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1508;
    private boolean _isInitialized = false;
    private ContentPart part = ;
    private Number installationPercent = 0;
    private FuncTree _parttree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1508;
    }

    public PartInfoMessage initPartInfoMessage(ContentPart param1,Number  param2) {
         this.part = param1;
         this.installationPercent = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.part = new ContentPart();
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
         this.serializeAs_PartInfoMessage(param1);
    }

    public void serializeAs_PartInfoMessage(ICustomDataOutput param1) {
         this.part.serializeAs_ContentPart(param1);
         param1.writeFloat(this.installationPercent);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartInfoMessage(param1);
    }

    public void deserializeAs_PartInfoMessage(ICustomDataInput param1) {
         this.part = new ContentPart();
         this.part.deserialize(param1);
         this._installationPercentFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartInfoMessage(param1);
    }

    public void deserializeAsyncAs_PartInfoMessage(FuncTree param1) {
         this._parttree = param1.addChild(this._parttreeFunc);
         param1.addChild(this._installationPercentFunc);
    }

    private void _parttreeFunc(ICustomDataInput param1) {
         this.part = new ContentPart();
         this.part.deserializeAsync(this._parttree);
    }

    private void _installationPercentFunc(ICustomDataInput param1) {
         this.installationPercent = param1.readFloat();
    }

}