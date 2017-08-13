package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountHarnessColorsUpdateRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6697;
    private boolean _isInitialized = false;
    private boolean useHarnessColors = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6697;
    }

    public MountHarnessColorsUpdateRequestMessage initMountHarnessColorsUpdateRequestMessage(boolean param1) {
         this.useHarnessColors = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.useHarnessColors = false;
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
         this.serializeAs_MountHarnessColorsUpdateRequestMessage(param1);
    }

    public void serializeAs_MountHarnessColorsUpdateRequestMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.useHarnessColors);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountHarnessColorsUpdateRequestMessage(param1);
    }

    public void deserializeAs_MountHarnessColorsUpdateRequestMessage(ICustomDataInput param1) {
         this._useHarnessColorsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountHarnessColorsUpdateRequestMessage(param1);
    }

    public void deserializeAsyncAs_MountHarnessColorsUpdateRequestMessage(FuncTree param1) {
         param1.addChild(this._useHarnessColorsFunc);
    }

    private void _useHarnessColorsFunc(ICustomDataInput param1) {
         this.useHarnessColors = param1.readBoolean();
    }

}