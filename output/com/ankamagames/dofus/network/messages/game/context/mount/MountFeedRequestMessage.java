package package com.ankamagames.dofus.network.messages.game.context.mount;

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

public class MountFeedRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6189;
    private boolean _isInitialized = false;
    private int mountUid = 0;
    private int mountLocation = 0;
    private int mountFoodUid = 0;
    private int quantity = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6189;
    }

    public MountFeedRequestMessage initMountFeedRequestMessage(int param1,int  param2,int  param3,int  param4) {
         this.mountUid = param1;
         this.mountLocation = param2;
         this.mountFoodUid = param3;
         this.quantity = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mountUid = 0;
         this.mountLocation = 0;
         this.mountFoodUid = 0;
         this.quantity = 0;
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
         this.serializeAs_MountFeedRequestMessage(param1);
    }

    public void serializeAs_MountFeedRequestMessage(ICustomDataOutput param1) {
         if(this.mountUid < 0)
            throw new Exception("Forbidden value (" + this.mountUid + ") on element mountUid.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountFeedRequestMessage(param1);
    }

    public void deserializeAs_MountFeedRequestMessage(ICustomDataInput param1) {
         this._mountUidFunc(param1);
         this._mountLocationFunc(param1);
         this._mountFoodUidFunc(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountFeedRequestMessage(param1);
    }

    public void deserializeAsyncAs_MountFeedRequestMessage(FuncTree param1) {
         param1.addChild(this._mountUidFunc);
         param1.addChild(this._mountLocationFunc);
         param1.addChild(this._mountFoodUidFunc);
         param1.addChild(this._quantityFunc);
    }

    private void _mountUidFunc(ICustomDataInput param1) {
         this.mountUid = param1.readVarUhInt();
         if(this.mountUid < 0)
            throw new Exception("Forbidden value (" + this.mountUid + ") on element of MountFeedRequestMessage.mountUid.");
    }

    private void _mountLocationFunc(ICustomDataInput param1) {
         this.mountLocation = param1.readByte();
    }

    private void _mountFoodUidFunc(ICustomDataInput param1) {
         this.mountFoodUid = param1.readVarUhInt();
         if(this.mountFoodUid < 0)
            throw new Exception("Forbidden value (" + this.mountFoodUid + ") on element of MountFeedRequestMessage.mountFoodUid.");
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
            throw new Exception("Forbidden value (" + this.quantity + ") on element of MountFeedRequestMessage.quantity.");
    }

}