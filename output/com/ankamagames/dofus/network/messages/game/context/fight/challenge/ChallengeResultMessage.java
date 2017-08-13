package package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ChallengeResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6019;
    private boolean _isInitialized = false;
    private int challengeId = 0;
    private boolean success = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6019;
    }

    public ChallengeResultMessage initChallengeResultMessage(int param1,boolean  param2) {
         this.challengeId = param1;
         this.success = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.challengeId = 0;
         this.success = false;
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
         this.serializeAs_ChallengeResultMessage(param1);
    }

    public void serializeAs_ChallengeResultMessage(ICustomDataOutput param1) {
         if(this.challengeId < 0)
            throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChallengeResultMessage(param1);
    }

    public void deserializeAs_ChallengeResultMessage(ICustomDataInput param1) {
         this._challengeIdFunc(param1);
         this._successFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChallengeResultMessage(param1);
    }

    public void deserializeAsyncAs_ChallengeResultMessage(FuncTree param1) {
         param1.addChild(this._challengeIdFunc);
         param1.addChild(this._successFunc);
    }

    private void _challengeIdFunc(ICustomDataInput param1) {
         this.challengeId = param1.readVarUhShort();
         if(this.challengeId < 0)
            throw new Exception("Forbidden value (" + this.challengeId + ") on element of ChallengeResultMessage.challengeId.");
    }

    private void _successFunc(ICustomDataInput param1) {
         this.success = param1.readBoolean();
    }

}