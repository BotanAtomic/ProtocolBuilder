package package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ChallengeTargetsListRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5614;
    private boolean _isInitialized = false;
    private int challengeId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5614;
    }

    public ChallengeTargetsListRequestMessage initChallengeTargetsListRequestMessage(int param1) {
         this.challengeId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.challengeId = 0;
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
         this.serializeAs_ChallengeTargetsListRequestMessage(param1);
    }

    public void serializeAs_ChallengeTargetsListRequestMessage(ICustomDataOutput param1) {
         if(this.challengeId < 0)
            throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChallengeTargetsListRequestMessage(param1);
    }

    public void deserializeAs_ChallengeTargetsListRequestMessage(ICustomDataInput param1) {
         this._challengeIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChallengeTargetsListRequestMessage(param1);
    }

    public void deserializeAsyncAs_ChallengeTargetsListRequestMessage(FuncTree param1) {
         param1.addChild(this._challengeIdFunc);
    }

    private void _challengeIdFunc(ICustomDataInput param1) {
         this.challengeId = param1.readVarUhShort();
         if(this.challengeId < 0)
            throw new Exception("Forbidden value (" + this.challengeId + ") on element of ChallengeTargetsListRequestMessage.challengeId.");
    }

}