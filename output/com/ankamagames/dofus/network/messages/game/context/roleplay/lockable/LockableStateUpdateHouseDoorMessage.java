package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class LockableStateUpdateHouseDoorMessage extends LockableStateUpdateAbstractMessage implements INetworkMessage {

    private int protocolId = 5668;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean secondHand = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5668;
    }

    public LockableStateUpdateHouseDoorMessage initLockableStateUpdateHouseDoorMessage(boolean param1,int  param2,int  param3,boolean  param4) {
         super.initLockableStateUpdateAbstractMessage(param1);
         this.houseId = param2;
         this.instanceId = param3;
         this.secondHand = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.houseId = 0;
         this.instanceId = 0;
         this.secondHand = false;
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
         this.serializeAs_LockableStateUpdateHouseDoorMessage(param1);
    }

    public void serializeAs_LockableStateUpdateHouseDoorMessage(ICustomDataOutput param1) {
         super.serializeAs_LockableStateUpdateAbstractMessage(param1);
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         param1.writeBoolean(this.secondHand);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LockableStateUpdateHouseDoorMessage(param1);
    }

    public void deserializeAs_LockableStateUpdateHouseDoorMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._houseIdFunc(param1);
         this._instanceIdFunc(param1);
         this._secondHandFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LockableStateUpdateHouseDoorMessage(param1);
    }

    public void deserializeAsyncAs_LockableStateUpdateHouseDoorMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._secondHandFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of LockableStateUpdateHouseDoorMessage.houseId.");
         }
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of LockableStateUpdateHouseDoorMessage.instanceId.");
         }
    }

    private void _secondHandFunc(ICustomDataInput param1) {
         this.secondHand = param1.readBoolean();
    }

}