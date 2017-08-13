package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionBaseInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyInvitationMemberInformations extends CharacterBaseInformations implements INetworkType {

    private int protocolId = 376;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private PartyCompanionBaseInformations[] companions;
    private FuncTree _companionstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterBaseInformations(param1);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         param1.writeShort(this.companions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.companions.length)
         {
            (this.companions[_loc2_] as PartyCompanionBaseInformations).serializeAs_PartyCompanionBaseInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PartyCompanionBaseInformations _loc4_ = null;
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AbstractCharacterInformation.id.");
         }
         this.name = param1.readUTF();
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of CharacterMinimalInformations.level.");
         }
         this.entityLook = new EntityLook();
         this.entityLook.deserialize(param1);
         this.breed = param1.readByte();
         this.sex = param1.readBoolean();
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PartyInvitationMemberInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PartyInvitationMemberInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PartyInvitationMemberInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PartyCompanionBaseInformations();
            _loc4_.deserialize(param1);
            this.companions.push(_loc4_);
            _loc3_++;
         }
    }

}