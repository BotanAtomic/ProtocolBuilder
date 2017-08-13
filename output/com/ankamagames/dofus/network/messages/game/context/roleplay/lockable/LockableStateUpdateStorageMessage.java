package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class LockableStateUpdateStorageMessage extends LockableStateUpdateAbstractMessage implements INetworkMessage {

    private int protocolId = 5669;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private int elementId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5669;
    }

    public LockableStateUpdateStorageMessage initLockableStateUpdateStorageMessage(boolean param1,int  param2,int  param3) {
         super.initLockableStateUpdateAbstractMessage(param1);
         this.mapId = param2;
         this.elementId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.mapId = 0;
         this.elementId = 0;
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
         this.serializeAs_LockableStateUpdateStorageMessage(param1);
    }

    public void serializeAs_LockableStateUpdateStorageMessage(ICustomDataOutput param1) {
         super.serializeAs_LockableStateUpdateAbstractMessage(param1);
         param1.writeInt(this.mapId);
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
         }
         param1.writeVarInt(this.elementId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LockableStateUpdateStorageMessage(param1);
    }

    public void deserializeAs_LockableStateUpdateStorageMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._mapIdFunc(param1);
         this._elementIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LockableStateUpdateStorageMessage(param1);
    }

    public void deserializeAsyncAs_LockableStateUpdateStorageMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._elementIdFunc);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _elementIdFunc(ICustomDataInput param1) {
         this.elementId = param1.readVarUhInt();
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element of LockableStateUpdateStorageMessage.elementId.");
         }
    }

}