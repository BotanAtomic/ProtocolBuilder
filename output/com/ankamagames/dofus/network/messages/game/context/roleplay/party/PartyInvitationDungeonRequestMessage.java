package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyInvitationDungeonRequestMessage extends PartyInvitationRequestMessage implements INetworkMessage {

    private int protocolId = 6245;
    private boolean _isInitialized = false;
    private int dungeonId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationRequestMessage(param1);
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of PartyInvitationDungeonRequestMessage.dungeonId.");
         }
    }

}