package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountDataMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5973;
    private boolean _isInitialized = false;
    private MountClientData mountData;
    private FuncTree _mountDatatree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5973;
    }

    public MountDataMessage initMountDataMessage(MountClientData param1) {
         this.mountData = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mountData = new MountClientData();
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
         this.serializeAs_MountDataMessage(param1);
    }

    public void serializeAs_MountDataMessage(ICustomDataOutput param1) {
         this.mountData.serializeAs_MountClientData(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountDataMessage(param1);
    }

    public void deserializeAs_MountDataMessage(ICustomDataInput param1) {
         this.mountData = new MountClientData();
         this.mountData.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountDataMessage(param1);
    }

    public void deserializeAsyncAs_MountDataMessage(FuncTree param1) {
         this._mountDatatree = param1.addChild(this._mountDatatreeFunc);
    }

    private void _mountDatatreeFunc(ICustomDataInput param1) {
         this.mountData = new MountClientData();
         this.mountData.deserializeAsync(this._mountDatatree);
    }

}