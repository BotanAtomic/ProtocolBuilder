package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PortalUseRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6492;
    private boolean _isInitialized = false;
    private int portalId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.portalId < 0)
         {
            throw new Exception("Forbidden value (" + this.portalId + ") on element portalId.");
         }
         param1.writeVarInt(this.portalId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.portalId = param1.readVarUhInt();
         if(this.portalId < 0)
         {
            throw new Exception("Forbidden value (" + this.portalId + ") on element of PortalUseRequestMessage.portalId.");
         }
    }

}