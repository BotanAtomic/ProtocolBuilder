package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightTurnResumeMessage extends GameFightTurnStartMessage implements INetworkMessage {

    private int protocolId = 6307;
    private boolean _isInitialized = false;
    private int remainingTime = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6307;
    }

    public GameFightTurnResumeMessage initGameFightTurnResumeMessage(Number param1,int  param2,int  param3) {
         super.initGameFightTurnStartMessage(param1,param2);
         this.remainingTime = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.remainingTime = 0;
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
         this.serializeAs_GameFightTurnResumeMessage(param1);
    }

    public void serializeAs_GameFightTurnResumeMessage(ICustomDataOutput param1) {
         super.serializeAs_GameFightTurnStartMessage(param1);
         if(this.remainingTime < 0)
            throw new Exception("Forbidden value (" + this.remainingTime + ") on element remainingTime.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightTurnResumeMessage(param1);
    }

    public void deserializeAs_GameFightTurnResumeMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._remainingTimeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightTurnResumeMessage(param1);
    }

    public void deserializeAsyncAs_GameFightTurnResumeMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._remainingTimeFunc);
    }

    private void _remainingTimeFunc(ICustomDataInput param1) {
         this.remainingTime = param1.readVarUhInt();
         if(this.remainingTime < 0)
            throw new Exception("Forbidden value (" + this.remainingTime + ") on element of GameFightTurnResumeMessage.remainingTime.");
    }

}