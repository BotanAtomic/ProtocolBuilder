package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyMemberInformations extends CharacterBaseInformations implements INetworkType {

    private int protocolId = 90;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int prospecting = 0;
    private int regenRate = 0;
    private int initiative = 0;
    private int alignmentSide = 0;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;
    private PlayerStatus status;
    private PartyCompanionMemberInformations[] companions;
    private FuncTree _statustree;
    private FuncTree _companionstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterBaseInformations(param1);
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
         }
         param1.writeVarInt(this.lifePoints);
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
         }
         param1.writeVarInt(this.maxLifePoints);
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
         }
         param1.writeVarShort(this.prospecting);
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
         }
         param1.writeByte(this.regenRate);
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
         }
         param1.writeVarShort(this.initiative);
         param1.writeByte(this.alignmentSide);
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
         param1.writeShort(this.status.getTypeId());
         this.status.serialize(param1);
         param1.writeShort(this.companions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.companions.length)
         {
            (this.companions[_loc2_] as PartyCompanionMemberInformations).serializeAs_PartyCompanionMemberInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PartyCompanionMemberInformations _loc5_ = null;
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
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of PartyMemberInformations.lifePoints.");
         }
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of PartyMemberInformations.maxLifePoints.");
         }
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of PartyMemberInformations.prospecting.");
         }
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of PartyMemberInformations.regenRate.");
         }
         this.initiative = param1.readVarUhShort();
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element of PartyMemberInformations.initiative.");
         }
         this.alignmentSide = param1.readByte();
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Exception("Forbidden value (" + this.worldX + ") on element of PartyMemberInformations.worldX.");
         }
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Exception("Forbidden value (" + this.worldY + ") on element of PartyMemberInformations.worldY.");
         }
         this.mapId = param1.readInt();
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PartyMemberInformations.subAreaId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
         {
            _loc5_ = new PartyCompanionMemberInformations();
            _loc5_.deserialize(param1);
            this.companions.push(_loc5_);
            _loc4_++;
         }
    }

}