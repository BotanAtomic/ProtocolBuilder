package package com.ankamagames.dofus.network.messages.game.interactive;

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
import java.lang.Exception;

public class InteractiveUsedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5745;
    private boolean _isInitialized = false;
    private Number entityId = 0;
    private int elemId = 0;
    private int skillId = 0;
    private int duration = 0;
    private boolean canMove = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5745;
    }

    public InteractiveUsedMessage initInteractiveUsedMessage(Number param1,int  param2,int  param3,int  param4,boolean  param5) {
         this.entityId = param1;
         this.elemId = param2;
         this.skillId = param3;
         this.duration = param4;
         this.canMove = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.entityId = 0;
         this.elemId = 0;
         this.skillId = 0;
         this.duration = 0;
         this.canMove = false;
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
         this.serializeAs_InteractiveUsedMessage(param1);
    }

    public void serializeAs_InteractiveUsedMessage(ICustomDataOutput param1) {
         if(this.entityId < 0 || this.entityId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.entityId + ") on element entityId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveUsedMessage(param1);
    }

    public void deserializeAs_InteractiveUsedMessage(ICustomDataInput param1) {
         this._entityIdFunc(param1);
         this._elemIdFunc(param1);
         this._skillIdFunc(param1);
         this._durationFunc(param1);
         this._canMoveFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveUsedMessage(param1);
    }

    public void deserializeAsyncAs_InteractiveUsedMessage(FuncTree param1) {
         param1.addChild(this._entityIdFunc);
         param1.addChild(this._elemIdFunc);
         param1.addChild(this._skillIdFunc);
         param1.addChild(this._durationFunc);
         param1.addChild(this._canMoveFunc);
    }

    private void _entityIdFunc(ICustomDataInput param1) {
         this.entityId = param1.readVarUhLong();
         if(this.entityId < 0 || this.entityId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.entityId + ") on element of InteractiveUsedMessage.entityId.");
    }

    private void _elemIdFunc(ICustomDataInput param1) {
         this.elemId = param1.readVarUhInt();
         if(this.elemId < 0)
            throw new Exception("Forbidden value (" + this.elemId + ") on element of InteractiveUsedMessage.elemId.");
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhShort();
         if(this.skillId < 0)
            throw new Exception("Forbidden value (" + this.skillId + ") on element of InteractiveUsedMessage.skillId.");
    }

    private void _durationFunc(ICustomDataInput param1) {
         this.duration = param1.readVarUhShort();
         if(this.duration < 0)
            throw new Exception("Forbidden value (" + this.duration + ") on element of InteractiveUsedMessage.duration.");
    }

    private void _canMoveFunc(ICustomDataInput param1) {
         this.canMove = param1.readBoolean();
    }

}