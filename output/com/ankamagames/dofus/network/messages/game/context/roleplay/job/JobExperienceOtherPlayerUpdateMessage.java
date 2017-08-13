package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobExperience;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class JobExperienceOtherPlayerUpdateMessage extends JobExperienceUpdateMessage implements INetworkMessage {

    private int protocolId = 6599;
    private boolean _isInitialized = false;
    private Number playerId = 0;


    public void serialize(ICustomDataOutput param1) {
         this.experiencesUpdate.serializeAs_JobExperience(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobExperienceUpdateMessage(param1);
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of JobExperienceOtherPlayerUpdateMessage.playerId.");
         }
    }

}