package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobDescription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class JobLevelUpMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5656;
    private boolean _isInitialized = false;
    private int newLevel = 0;
    private JobDescription jobsDescription;
    private FuncTree _jobsDescriptiontree;


    public void serialize(ICustomDataOutput param1) {
         if(this.newLevel < 0 || this.newLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.newLevel + ") on element newLevel.");
         }
         param1.writeByte(this.newLevel);
         this.jobsDescription.serializeAs_JobDescription(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.newLevel = param1.readUnsignedByte();
         if(this.newLevel < 0 || this.newLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.newLevel + ") on element of JobLevelUpMessage.newLevel.");
         }
         this.jobsDescription = new JobDescription();
         this.jobsDescription.deserialize(param1);
    }

}