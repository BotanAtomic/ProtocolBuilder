package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyInvitationMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyInvitationDetailsMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6263;
    private boolean _isInitialized = false;
    private int partyType = 0;
    private String partyName = "";
    private Number fromId = 0;
    private String fromName = "";
    private Number leaderId = 0;
    private PartyInvitationMemberInformations[] members;
    private PartyGuestInformations[] guests;
    private FuncTree _memberstree;
    private FuncTree _gueststree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.partyType);
         param1.writeUTF(this.partyName);
         if(this.fromId < 0 || this.fromId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fromId + ") on element fromId.");
         }
         param1.writeVarLong(this.fromId);
         param1.writeUTF(this.fromName);
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
         }
         param1.writeVarLong(this.leaderId);
         param1.writeShort(this.members.length);
         int _loc2_ = 0;
         while(_loc2_ < this.members.length)
         {
            (this.members[_loc2_] as PartyInvitationMemberInformations).serializeAs_PartyInvitationMemberInformations(param1);
            _loc2_++;
         }
         param1.writeShort(this.guests.length);
         int _loc3_ = 0;
         while(_loc3_ < this.guests.length)
         {
            (this.guests[_loc3_] as PartyGuestInformations).serializeAs_PartyGuestInformations(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PartyInvitationMemberInformations _loc6_ = null;
         PartyGuestInformations _loc7_ = null;
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.partyType = param1.readByte();
         if(this.partyType < 0)
         {
            throw new Exception("Forbidden value (" + this.partyType + ") on element of PartyInvitationDetailsMessage.partyType.");
         }
         this.partyName = param1.readUTF();
         this.fromId = param1.readVarUhLong();
         if(this.fromId < 0 || this.fromId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fromId + ") on element of PartyInvitationDetailsMessage.fromId.");
         }
         this.fromName = param1.readUTF();
         this.leaderId = param1.readVarUhLong();
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of PartyInvitationDetailsMessage.leaderId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new PartyInvitationMemberInformations();
            _loc6_.deserialize(param1);
            this.members.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new PartyGuestInformations();
            _loc7_.deserialize(param1);
            this.guests.push(_loc7_);
            _loc5_++;
         }
    }

}