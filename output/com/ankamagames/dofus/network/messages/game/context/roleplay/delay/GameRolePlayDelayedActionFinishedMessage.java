package com.ankamagames.dofus.network.messages.game.context.roleplay.delay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayDelayedActionFinishedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6150;
    private boolean _isInitialized = false;
    private Number delayedCharacterId = 0;
    private int delayTypeId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6150;
    }

    public GameRolePlayDelayedActionFinishedMessage initGameRolePlayDelayedActionFinishedMessage(Number param1,int  param2) {
         this.delayedCharacterId = param1;
         this.delayTypeId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.delayedCharacterId = 0;
         this.delayTypeId = 0;
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
         this.serializeAs_GameRolePlayDelayedActionFinishedMessage(param1);
    }

    public void serializeAs_GameRolePlayDelayedActionFinishedMessage(ICustomDataOutput param1) {
         if(this.delayedCharacterId < -9.007199254740992E15 || this.delayedCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayedCharacterId + ") on element delayedCharacterId.");
         }
         param1.writeDouble(this.delayedCharacterId);
         param1.writeByte(this.delayTypeId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayDelayedActionFinishedMessage(param1);
    }

    public void deserializeAs_GameRolePlayDelayedActionFinishedMessage(ICustomDataInput param1) {
         this._delayedCharacterIdFunc(param1);
         this._delayTypeIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayDelayedActionFinishedMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayDelayedActionFinishedMessage(FuncTree param1) {
         param1.addChild(this._delayedCharacterIdFunc);
         param1.addChild(this._delayTypeIdFunc);
    }

    private void _delayedCharacterIdFunc(ICustomDataInput param1) {
         this.delayedCharacterId = param1.readDouble();
         if(this.delayedCharacterId < -9.007199254740992E15 || this.delayedCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayedCharacterId + ") on element of GameRolePlayDelayedActionFinishedMessage.delayedCharacterId.");
         }
    }

    private void _delayTypeIdFunc(ICustomDataInput param1) {
         this.delayTypeId = param1.readByte();
         if(this.delayTypeId < 0)
         {
            throw new Exception("Forbidden value (" + this.delayTypeId + ") on element of GameRolePlayDelayedActionFinishedMessage.delayTypeId.");
         }
    }

}