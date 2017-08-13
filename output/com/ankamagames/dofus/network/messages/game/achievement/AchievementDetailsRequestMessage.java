package package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AchievementDetailsRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6380;
    private boolean _isInitialized = false;
    private int achievementId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6380;
    }

    public AchievementDetailsRequestMessage initAchievementDetailsRequestMessage(int param1) {
         this.achievementId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.achievementId = 0;
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
         this.serializeAs_AchievementDetailsRequestMessage(param1);
    }

    public void serializeAs_AchievementDetailsRequestMessage(ICustomDataOutput param1) {
         if(this.achievementId < 0)
            throw new Exception("Forbidden value (" + this.achievementId + ") on element achievementId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementDetailsRequestMessage(param1);
    }

    public void deserializeAs_AchievementDetailsRequestMessage(ICustomDataInput param1) {
         this._achievementIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementDetailsRequestMessage(param1);
    }

    public void deserializeAsyncAs_AchievementDetailsRequestMessage(FuncTree param1) {
         param1.addChild(this._achievementIdFunc);
    }

    private void _achievementIdFunc(ICustomDataInput param1) {
         this.achievementId = param1.readVarUhShort();
         if(this.achievementId < 0)
            throw new Exception("Forbidden value (" + this.achievementId + ") on element of AchievementDetailsRequestMessage.achievementId.");
    }

}