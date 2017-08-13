package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobDescription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobDescriptionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5655;
    private boolean _isInitialized = false;
    private JobDescription[] jobsDescription;
    private FuncTree _jobsDescriptiontree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.jobsDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.jobsDescription.length)
         {
            (this.jobsDescription[_loc2_] as JobDescription).serializeAs_JobDescription(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         JobDescription _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new JobDescription();
            _loc4_.deserialize(param1);
            this.jobsDescription.push(_loc4_);
            _loc3_++;
         }
    }

}