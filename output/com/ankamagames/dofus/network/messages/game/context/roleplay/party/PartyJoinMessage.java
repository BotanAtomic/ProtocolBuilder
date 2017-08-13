package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class PartyJoinMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5576;
    private boolean _isInitialized = false;
    private int partyType = 0;
    private Number partyLeaderId = 0;
    private int maxParticipants = 0;
    private PartyMemberInformations[] members;
    private PartyGuestInformations[] guests;
    private boolean restricted = false;
    private String partyName = "";
    private FuncTree _memberstree;
    private FuncTree _gueststree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.partyType);
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element partyLeaderId.");
         }
         param1.writeVarLong(this.partyLeaderId);
         if(this.maxParticipants < 0)
         {
            throw new Exception("Forbidden value (" + this.maxParticipants + ") on element maxParticipants.");
         }
         param1.writeByte(this.maxParticipants);
         param1.writeShort(this.members.length);
         int _loc2_ = 0;
         while(_loc2_ < this.members.length)
         {
            param1.writeShort((this.members[_loc2_] as PartyMemberInformations).getTypeId());
            (this.members[_loc2_] as PartyMemberInformations).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.guests.length);
         int _loc3_ = 0;
         while(_loc3_ < this.guests.length)
         {
            (this.guests[_loc3_] as PartyGuestInformations).serializeAs_PartyGuestInformations(param1);
            _loc3_++;
         }
         param1.writeBoolean(this.restricted);
         param1.writeUTF(this.partyName);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         PartyMemberInformations _loc7_ = null;
         PartyGuestInformations _loc8_ = null;
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.partyType = param1.readByte();
         if(this.partyType < 0)
         {
            throw new Exception("Forbidden value (" + this.partyType + ") on element of PartyJoinMessage.partyType.");
         }
         this.partyLeaderId = param1.readVarUhLong();
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element of PartyJoinMessage.partyLeaderId.");
         }
         this.maxParticipants = param1.readByte();
         if(this.maxParticipants < 0)
         {
            throw new Exception("Forbidden value (" + this.maxParticipants + ") on element of PartyJoinMessage.maxParticipants.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(PartyMemberInformations,_loc6_);
            _loc7_.deserialize(param1);
            this.members.push(_loc7_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc8_ = new PartyGuestInformations();
            _loc8_.deserialize(param1);
            this.guests.push(_loc8_);
            _loc5_++;
         }
         this.restricted = param1.readBoolean();
         this.partyName = param1.readUTF();
    }

}