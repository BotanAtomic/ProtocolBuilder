package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyInvitationMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5586;
    private boolean _isInitialized = false;
    private int partyType = 0;
    private String partyName = "";
    private int maxParticipants = 0;
    private Number fromId = 0;
    private String fromName = "";
    private Number toId = 0;


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
    }

    public void deserialize(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.partyType = param1.readByte();
         if(this.partyType < 0)
         {
            throw new Exception("Forbidden value (" + this.partyType + ") on element of PartyInvitationMessage.partyType.");
         }
         this.partyName = param1.readUTF();
         this.maxParticipants = param1.readByte();
         if(this.maxParticipants < 0)
         {
            throw new Exception("Forbidden value (" + this.maxParticipants + ") on element of PartyInvitationMessage.maxParticipants.");
         }
         this.fromId = param1.readVarUhLong();
         if(this.fromId < 0 || this.fromId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fromId + ") on element of PartyInvitationMessage.fromId.");
         }
         this.fromName = param1.readUTF();
         this.toId = param1.readVarUhLong();
         if(this.toId < 0 || this.toId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.toId + ") on element of PartyInvitationMessage.toId.");
         }
    }

}