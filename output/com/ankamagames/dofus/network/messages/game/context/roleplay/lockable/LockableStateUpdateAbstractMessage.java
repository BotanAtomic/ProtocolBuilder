package package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LockableStateUpdateAbstractMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5671;
    private boolean _isInitialized = false;
    private boolean locked = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5671;
    }

    public LockableStateUpdateAbstractMessage initLockableStateUpdateAbstractMessage(boolean param1) {
         this.locked = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.locked = false;
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
         this.serializeAs_LockableStateUpdateAbstractMessage(param1);
    }

    public void serializeAs_LockableStateUpdateAbstractMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.locked);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LockableStateUpdateAbstractMessage(param1);
    }

    public void deserializeAs_LockableStateUpdateAbstractMessage(ICustomDataInput param1) {
         this._lockedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LockableStateUpdateAbstractMessage(param1);
    }

    public void deserializeAsyncAs_LockableStateUpdateAbstractMessage(FuncTree param1) {
         param1.addChild(this._lockedFunc);
    }

    private void _lockedFunc(ICustomDataInput param1) {
         this.locked = param1.readBoolean();
    }

}