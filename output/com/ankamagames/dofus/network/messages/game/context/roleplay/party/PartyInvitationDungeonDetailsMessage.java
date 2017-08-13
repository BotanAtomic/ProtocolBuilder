package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyInvitationMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyInvitationDungeonDetailsMessage extends PartyInvitationDetailsMessage implements INetworkMessage {

    private int protocolId = 6262;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private boolean[] playersDungeonReady;
    private FuncTree _playersDungeonReadytree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_PartyInvitationDetailsMessage(param1);
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
         param1.writeShort(this.playersDungeonReady.length);
         int _loc2_ = 0;
         while(_loc2_ < this.playersDungeonReady.length)
         {
            param1.writeBoolean(this.playersDungeonReady[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = false;
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
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of PartyInvitationDungeonDetailsMessage.dungeonId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readBoolean();
            this.playersDungeonReady.push(_loc4_);
            _loc3_++;
         }
    }

}