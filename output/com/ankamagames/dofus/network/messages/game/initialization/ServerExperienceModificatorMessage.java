package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ServerExperienceModificatorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6237;
    private boolean _isInitialized = false;
    private int experiencePercent = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.experiencePercent < 0)
         {
            throw new Exception("Forbidden value (" + this.experiencePercent + ") on element experiencePercent.");
         }
         param1.writeVarShort(this.experiencePercent);
    }

    public void deserialize(ICustomDataInput param1) {
         this.experiencePercent = param1.readVarUhShort();
         if(this.experiencePercent < 0)
         {
            throw new Exception("Forbidden value (" + this.experiencePercent + ") on element of ServerExperienceModificatorMessage.experiencePercent.");
         }
    }

}