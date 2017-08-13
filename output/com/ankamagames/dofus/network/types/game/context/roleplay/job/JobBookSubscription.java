package package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class JobBookSubscription extends Object implements INetworkType {

    private int protocolId = 500;
    private int jobId = 0;
    private boolean subscribed = false;


    public int getTypeId() {
         return 500;
    }

    public JobBookSubscription initJobBookSubscription(int param1,boolean  param2) {
         this.jobId = param1;
         this.subscribed = param2;
         return this;
    }

    public void reset() {
         this.jobId = 0;
         this.subscribed = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_JobBookSubscription(param1);
    }

    public void serializeAs_JobBookSubscription(ICustomDataOutput param1) {
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobBookSubscription(param1);
    }

    public void deserializeAs_JobBookSubscription(ICustomDataInput param1) {
         this._jobIdFunc(param1);
         this._subscribedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobBookSubscription(param1);
    }

    public void deserializeAsyncAs_JobBookSubscription(FuncTree param1) {
         param1.addChild(this._jobIdFunc);
         param1.addChild(this._subscribedFunc);
    }

    private void _jobIdFunc(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element of JobBookSubscription.jobId.");
    }

    private void _subscribedFunc(ICustomDataInput param1) {
         this.subscribed = param1.readBoolean();
    }

}