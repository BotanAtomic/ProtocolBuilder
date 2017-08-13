package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class JobBookSubscription extends Object implements INetworkType {

    private int protocolId = 500;
    private int jobId = 0;
    private boolean subscribed = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
         }
         param1.writeByte(this.jobId);
         param1.writeBoolean(this.subscribed);
    }

    public void deserialize(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element of JobBookSubscription.jobId.");
         }
         this.subscribed = param1.readBoolean();
    }

}