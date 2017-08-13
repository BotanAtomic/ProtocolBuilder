package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ChallengeInfoMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6022;
    private boolean _isInitialized = false;
    private int challengeId = 0;
    private Number targetId = 0;
    private int xpBonus = 0;
    private int dropBonus = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6022;
    }

    public ChallengeInfoMessage initChallengeInfoMessage(int param1,Number  param2,int  param3,int  param4) {
         this.challengeId = param1;
         this.targetId = param2;
         this.xpBonus = param3;
         this.dropBonus = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.challengeId = 0;
         this.targetId = 0;
         this.xpBonus = 0;
         this.dropBonus = 0;
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
         this.serializeAs_ChallengeInfoMessage(param1);
    }

    public void serializeAs_ChallengeInfoMessage(ICustomDataOutput param1) {
         if(this.challengeId < 0)
         {
            throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
         }
         param1.writeVarShort(this.challengeId);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         if(this.xpBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBonus + ") on element xpBonus.");
         }
         param1.writeVarInt(this.xpBonus);
         if(this.dropBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBonus + ") on element dropBonus.");
         }
         param1.writeVarInt(this.dropBonus);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChallengeInfoMessage(param1);
    }

    public void deserializeAs_ChallengeInfoMessage(ICustomDataInput param1) {
         this._challengeIdFunc(param1);
         this._targetIdFunc(param1);
         this._xpBonusFunc(param1);
         this._dropBonusFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChallengeInfoMessage(param1);
    }

    public void deserializeAsyncAs_ChallengeInfoMessage(FuncTree param1) {
         param1.addChild(this._challengeIdFunc);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._xpBonusFunc);
         param1.addChild(this._dropBonusFunc);
    }

    private void _challengeIdFunc(ICustomDataInput param1) {
         this.challengeId = param1.readVarUhShort();
         if(this.challengeId < 0)
         {
            throw new Exception("Forbidden value (" + this.challengeId + ") on element of ChallengeInfoMessage.challengeId.");
         }
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of ChallengeInfoMessage.targetId.");
         }
    }

    private void _xpBonusFunc(ICustomDataInput param1) {
         this.xpBonus = param1.readVarUhInt();
         if(this.xpBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.xpBonus + ") on element of ChallengeInfoMessage.xpBonus.");
         }
    }

    private void _dropBonusFunc(ICustomDataInput param1) {
         this.dropBonus = param1.readVarUhInt();
         if(this.dropBonus < 0)
         {
            throw new Exception("Forbidden value (" + this.dropBonus + ") on element of ChallengeInfoMessage.dropBonus.");
         }
    }

}