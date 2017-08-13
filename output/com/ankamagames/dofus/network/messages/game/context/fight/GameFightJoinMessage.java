package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightJoinMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 702;
    private boolean _isInitialized = false;
    private boolean isTeamPhase = false;
    private boolean canBeCancelled = false;
    private boolean canSayReady = false;
    private boolean isFightStarted = false;
    private int timeMaxBeforeFightStart = 0;
    private int fightType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 702;
    }

    public GameFightJoinMessage initGameFightJoinMessage(boolean param1,boolean  param2,boolean  param3,boolean  param4,int  param5,int  param6) {
         this.isTeamPhase = param1;
         this.canBeCancelled = param2;
         this.canSayReady = param3;
         this.isFightStarted = param4;
         this.timeMaxBeforeFightStart = param5;
         this.fightType = param6;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.isTeamPhase = false;
         this.canBeCancelled = false;
         this.canSayReady = false;
         this.isFightStarted = false;
         this.timeMaxBeforeFightStart = 0;
         this.fightType = 0;
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
         this.serializeAs_GameFightJoinMessage(param1);
    }

    public void serializeAs_GameFightJoinMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.isTeamPhase);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.canBeCancelled);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.canSayReady);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.isFightStarted);
         param1.writeByte(_loc2_);
         if(this.timeMaxBeforeFightStart < 0)
            throw new Exception("Forbidden value (" + this.timeMaxBeforeFightStart + ") on element timeMaxBeforeFightStart.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightJoinMessage(param1);
    }

    public void deserializeAs_GameFightJoinMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._timeMaxBeforeFightStartFunc(param1);
         this._fightTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightJoinMessage(param1);
    }

    public void deserializeAsyncAs_GameFightJoinMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._timeMaxBeforeFightStartFunc);
         param1.addChild(this._fightTypeFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.isTeamPhase = BooleanByteWrapper.getFlag(_loc2_,0);
         this.canBeCancelled = BooleanByteWrapper.getFlag(_loc2_,1);
         this.canSayReady = BooleanByteWrapper.getFlag(_loc2_,2);
         this.isFightStarted = BooleanByteWrapper.getFlag(_loc2_,3);
    }

    private void _timeMaxBeforeFightStartFunc(ICustomDataInput param1) {
         this.timeMaxBeforeFightStart = param1.readShort();
         if(this.timeMaxBeforeFightStart < 0)
            throw new Exception("Forbidden value (" + this.timeMaxBeforeFightStart + ") on element of GameFightJoinMessage.timeMaxBeforeFightStart.");
    }

    private void _fightTypeFunc(ICustomDataInput param1) {
         this.fightType = param1.readByte();
         if(this.fightType < 0)
            throw new Exception("Forbidden value (" + this.fightType + ") on element of GameFightJoinMessage.fightType.");
    }

}