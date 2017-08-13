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
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayDelayedActionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6153;
    private boolean _isInitialized = false;
    private Number delayedCharacterId = 0;
    private int delayTypeId = 0;
    private Number delayEndTime = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6153;
    }

    public GameRolePlayDelayedActionMessage initGameRolePlayDelayedActionMessage(Number param1,int  param2,Number  param3) {
         this.delayedCharacterId = param1;
         this.delayTypeId = param2;
         this.delayEndTime = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.delayedCharacterId = 0;
         this.delayTypeId = 0;
         this.delayEndTime = 0;
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
         this.serializeAs_GameRolePlayDelayedActionMessage(param1);
    }

    public void serializeAs_GameRolePlayDelayedActionMessage(ICustomDataOutput param1) {
         if(this.delayedCharacterId < -9.007199254740992E15 || this.delayedCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayedCharacterId + ") on element delayedCharacterId.");
         }
         param1.writeDouble(this.delayedCharacterId);
         param1.writeByte(this.delayTypeId);
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
         }
         param1.writeDouble(this.delayEndTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayDelayedActionMessage(param1);
    }

    public void deserializeAs_GameRolePlayDelayedActionMessage(ICustomDataInput param1) {
         this._delayedCharacterIdFunc(param1);
         this._delayTypeIdFunc(param1);
         this._delayEndTimeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayDelayedActionMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayDelayedActionMessage(FuncTree param1) {
         param1.addChild(this._delayedCharacterIdFunc);
         param1.addChild(this._delayTypeIdFunc);
         param1.addChild(this._delayEndTimeFunc);
    }

    private void _delayedCharacterIdFunc(ICustomDataInput param1) {
         this.delayedCharacterId = param1.readDouble();
         if(this.delayedCharacterId < -9.007199254740992E15 || this.delayedCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayedCharacterId + ") on element of GameRolePlayDelayedActionMessage.delayedCharacterId.");
         }
    }

    private void _delayTypeIdFunc(ICustomDataInput param1) {
         this.delayTypeId = param1.readByte();
         if(this.delayTypeId < 0)
         {
            throw new Exception("Forbidden value (" + this.delayTypeId + ") on element of GameRolePlayDelayedActionMessage.delayTypeId.");
         }
    }

    private void _delayEndTimeFunc(ICustomDataInput param1) {
         this.delayEndTime = param1.readDouble();
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element of GameRolePlayDelayedActionMessage.delayEndTime.");
         }
    }

}