package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobExperience;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobExperienceUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5654;
    private boolean _isInitialized = false;
    private JobExperience experiencesUpdate;
    private FuncTree _experiencesUpdatetree;


    public void serialize(ICustomDataOutput param1) {
         this.experiencesUpdate.serializeAs_JobExperience(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.experiencesUpdate = new JobExperience();
         this.experiencesUpdate.deserialize(param1);
    }

}