package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyInvitationDungeonMessage extends PartyInvitationMessage implements INetworkMessage {

    private int protocolId = 6244;
    private boolean _isInitialized = false;
    private int dungeonId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.partyType);
         param1.writeUTF(this.partyName);
         if(this.maxParticipants < 0)
         {
            throw new Exception("Forbidden value (" + this.maxParticipants + ") on element maxParticipants.");
         }
         param1.writeByte(this.maxParticipants);
         if(this.fromId < 0 || this.fromId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fromId + ") on element fromId.");
         }
         param1.writeVarLong(this.fromId);
         param1.writeUTF(this.fromName);
         if(this.toId < 0 || this.toId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.toId + ") on element toId.");
         }
         param1.writeVarLong(this.toId);
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationMessage(param1);
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of PartyInvitationDungeonMessage.dungeonId.");
         }
    }

}