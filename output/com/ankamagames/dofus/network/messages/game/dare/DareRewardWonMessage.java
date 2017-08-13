package package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareReward;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareRewardWonMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6678;
    private boolean _isInitialized = false;
    private DareReward reward = ;
    private FuncTree _rewardtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6678;
    }

    public DareRewardWonMessage initDareRewardWonMessage(DareReward param1) {
         this.reward = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.reward = new DareReward();
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
         this.serializeAs_DareRewardWonMessage(param1);
    }

    public void serializeAs_DareRewardWonMessage(ICustomDataOutput param1) {
         this.reward.serializeAs_DareReward(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareRewardWonMessage(param1);
    }

    public void deserializeAs_DareRewardWonMessage(ICustomDataInput param1) {
         this.reward = new DareReward();
         this.reward.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareRewardWonMessage(param1);
    }

    public void deserializeAsyncAs_DareRewardWonMessage(FuncTree param1) {
         this._rewardtree = param1.addChild(this._rewardtreeFunc);
    }

    private void _rewardtreeFunc(ICustomDataInput param1) {
         this.reward = new DareReward();
         this.reward.deserializeAsync(this._rewardtree);
    }

}