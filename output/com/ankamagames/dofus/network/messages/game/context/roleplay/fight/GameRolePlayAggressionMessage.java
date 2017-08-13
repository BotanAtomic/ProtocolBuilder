package package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayAggressionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6073;
    private boolean _isInitialized = false;
    private Number attackerId = 0;
    private Number defenderId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6073;
    }

    public GameRolePlayAggressionMessage initGameRolePlayAggressionMessage(Number param1,Number  param2) {
         this.attackerId = param1;
         this.defenderId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.attackerId = 0;
         this.defenderId = 0;
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
         this.serializeAs_GameRolePlayAggressionMessage(param1);
    }

    public void serializeAs_GameRolePlayAggressionMessage(ICustomDataOutput param1) {
         if(this.attackerId < 0 || this.attackerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.attackerId + ") on element attackerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayAggressionMessage(param1);
    }

    public void deserializeAs_GameRolePlayAggressionMessage(ICustomDataInput param1) {
         this._attackerIdFunc(param1);
         this._defenderIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayAggressionMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayAggressionMessage(FuncTree param1) {
         param1.addChild(this._attackerIdFunc);
         param1.addChild(this._defenderIdFunc);
    }

    private void _attackerIdFunc(ICustomDataInput param1) {
         this.attackerId = param1.readVarUhLong();
         if(this.attackerId < 0 || this.attackerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.attackerId + ") on element of GameRolePlayAggressionMessage.attackerId.");
    }

    private void _defenderIdFunc(ICustomDataInput param1) {
         this.defenderId = param1.readVarUhLong();
         if(this.defenderId < 0 || this.defenderId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.defenderId + ") on element of GameRolePlayAggressionMessage.defenderId.");
    }

}