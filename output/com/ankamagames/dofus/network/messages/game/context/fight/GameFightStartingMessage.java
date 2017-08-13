package package com.ankamagames.dofus.network.messages.game.context.fight;

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

public class GameFightStartingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 700;
    private boolean _isInitialized = false;
    private int fightType = 0;
    private Number attackerId = 0;
    private Number defenderId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 700;
    }

    public GameFightStartingMessage initGameFightStartingMessage(int param1,Number  param2,Number  param3) {
         this.fightType = param1;
         this.attackerId = param2;
         this.defenderId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightType = 0;
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
         this.serializeAs_GameFightStartingMessage(param1);
    }

    public void serializeAs_GameFightStartingMessage(ICustomDataOutput param1) {
         param1.writeByte(this.fightType);
         if(this.attackerId < -9.007199254740992E15 || this.attackerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.attackerId + ") on element attackerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightStartingMessage(param1);
    }

    public void deserializeAs_GameFightStartingMessage(ICustomDataInput param1) {
         this._fightTypeFunc(param1);
         this._attackerIdFunc(param1);
         this._defenderIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightStartingMessage(param1);
    }

    public void deserializeAsyncAs_GameFightStartingMessage(FuncTree param1) {
         param1.addChild(this._fightTypeFunc);
         param1.addChild(this._attackerIdFunc);
         param1.addChild(this._defenderIdFunc);
    }

    private void _fightTypeFunc(ICustomDataInput param1) {
         this.fightType = param1.readByte();
         if(this.fightType < 0)
            throw new Exception("Forbidden value (" + this.fightType + ") on element of GameFightStartingMessage.fightType.");
    }

    private void _attackerIdFunc(ICustomDataInput param1) {
         this.attackerId = param1.readDouble();
         if(this.attackerId < -9.007199254740992E15 || this.attackerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.attackerId + ") on element of GameFightStartingMessage.attackerId.");
    }

    private void _defenderIdFunc(ICustomDataInput param1) {
         this.defenderId = param1.readDouble();
         if(this.defenderId < -9.007199254740992E15 || this.defenderId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.defenderId + ") on element of GameFightStartingMessage.defenderId.");
    }

}