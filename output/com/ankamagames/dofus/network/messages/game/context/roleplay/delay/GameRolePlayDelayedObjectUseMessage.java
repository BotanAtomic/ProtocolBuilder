package com.ankamagames.dofus.network.messages.game.context.roleplay.delay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayDelayedObjectUseMessage extends GameRolePlayDelayedActionMessage implements INetworkMessage {

    private int protocolId = 6425;
    private boolean _isInitialized = false;
    private int objectGID = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6425;
    }

    public GameRolePlayDelayedObjectUseMessage initGameRolePlayDelayedObjectUseMessage(Number param1,int  param2,Number  param3,int  param4) {
         super.initGameRolePlayDelayedActionMessage(param1,param2,param3);
         this.objectGID = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.objectGID = 0;
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
         this.serializeAs_GameRolePlayDelayedObjectUseMessage(param1);
    }

    public void serializeAs_GameRolePlayDelayedObjectUseMessage(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayDelayedActionMessage(param1);
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayDelayedObjectUseMessage(param1);
    }

    public void deserializeAs_GameRolePlayDelayedObjectUseMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._objectGIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayDelayedObjectUseMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayDelayedObjectUseMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._objectGIDFunc);
    }

    private void _objectGIDFunc(ICustomDataInput param1) {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of GameRolePlayDelayedObjectUseMessage.objectGID.");
         }
    }

}