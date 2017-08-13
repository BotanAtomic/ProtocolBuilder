package package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareReward;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareRewardsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6677;
    private boolean _isInitialized = false;
    private Vector.<DareReward> rewards = ;
    private FuncTree _rewardstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6677;
    }

    public DareRewardsListMessage initDareRewardsListMessage(Vector.<DareReward> param1) {
         this.rewards = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.rewards = new Vector.<DareReward>();
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
         this.serializeAs_DareRewardsListMessage(param1);
    }

    public void serializeAs_DareRewardsListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.rewards.length);
         int _loc2_ = 0;
         while(_loc2_ < this.rewards.length)
            (this.rewards[_loc2_] as DareReward).serializeAs_DareReward(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DareRewardsListMessage(param1);
    }

    public void deserializeAs_DareRewardsListMessage(ICustomDataInput param1) {
         DareReward _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new DareReward();
            _loc4_.deserialize(param1);
            this.rewards.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DareRewardsListMessage(param1);
    }

    public void deserializeAsyncAs_DareRewardsListMessage(FuncTree param1) {
         this._rewardstree = param1.addChild(this._rewardstreeFunc);
    }

    private void _rewardstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._rewardstree.addChild(this._rewardsFunc);
            _loc3_++;
    }

    private void _rewardsFunc(ICustomDataInput param1) {
         DareReward _loc2_ = new DareReward();
         _loc2_.deserialize(param1);
         this.rewards.push(_loc2_);
    }

}