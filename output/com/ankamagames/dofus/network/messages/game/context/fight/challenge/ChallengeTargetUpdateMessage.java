package package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ChallengeTargetUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6123;
    private boolean _isInitialized = false;
    private int challengeId = 0;
    private Number targetId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6123;
    }

    public ChallengeTargetUpdateMessage initChallengeTargetUpdateMessage(int param1,Number  param2) {
         this.challengeId = param1;
         this.targetId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.challengeId = 0;
         this.targetId = 0;
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
         this.serializeAs_ChallengeTargetUpdateMessage(param1);
    }

    public void serializeAs_ChallengeTargetUpdateMessage(ICustomDataOutput param1) {
         if(this.challengeId < 0)
            throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChallengeTargetUpdateMessage(param1);
    }

    public void deserializeAs_ChallengeTargetUpdateMessage(ICustomDataInput param1) {
         this._challengeIdFunc(param1);
         this._targetIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChallengeTargetUpdateMessage(param1);
    }

    public void deserializeAsyncAs_ChallengeTargetUpdateMessage(FuncTree param1) {
         param1.addChild(this._challengeIdFunc);
         param1.addChild(this._targetIdFunc);
    }

    private void _challengeIdFunc(ICustomDataInput param1) {
         this.challengeId = param1.readVarUhShort();
         if(this.challengeId < 0)
            throw new Exception("Forbidden value (" + this.challengeId + ") on element of ChallengeTargetUpdateMessage.challengeId.");
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element of ChallengeTargetUpdateMessage.targetId.");
    }

}