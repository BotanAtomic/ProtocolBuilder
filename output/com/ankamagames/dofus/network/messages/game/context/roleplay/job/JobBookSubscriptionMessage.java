package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobBookSubscription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobBookSubscriptionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6593;
    private boolean _isInitialized = false;
    private Vector<JobBookSubscription> subscriptions;
    private FuncTree _subscriptionstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6593;
    }

    public JobBookSubscriptionMessage initJobBookSubscriptionMessage(Vector<JobBookSubscription> param1) {
         this.subscriptions = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.subscriptions = new Vector.<JobBookSubscription>();
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
         this.serializeAs_JobBookSubscriptionMessage(param1);
    }

    public void serializeAs_JobBookSubscriptionMessage(ICustomDataOutput param1) {
         param1.writeShort(this.subscriptions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.subscriptions.length)
         {
            (this.subscriptions[_loc2_] as JobBookSubscription).serializeAs_JobBookSubscription(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobBookSubscriptionMessage(param1);
    }

    public void deserializeAs_JobBookSubscriptionMessage(ICustomDataInput param1) {
         JobBookSubscription _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new JobBookSubscription();
            _loc4_.deserialize(param1);
            this.subscriptions.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobBookSubscriptionMessage(param1);
    }

    public void deserializeAsyncAs_JobBookSubscriptionMessage(FuncTree param1) {
         this._subscriptionstree = param1.addChild(this._subscriptionstreeFunc);
    }

    private void _subscriptionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._subscriptionstree.addChild(this._subscriptionsFunc);
            _loc3_++;
         }
    }

    private void _subscriptionsFunc(ICustomDataInput param1) {
         JobBookSubscription _loc2_ = new JobBookSubscription();
         _loc2_.deserialize(param1);
         this.subscriptions.push(_loc2_);
    }

}