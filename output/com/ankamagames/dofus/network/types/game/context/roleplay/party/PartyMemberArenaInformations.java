package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyMemberArenaInformations extends PartyMemberInformations implements INetworkType {

    private int protocolId = 391;
    private int rank = 0;


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
         if(this.rank < 0 || this.rank > 20000)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
         }
         param1.writeVarShort(this.rank);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyMemberInformations(param1);
         this.rank = param1.readVarUhShort();
         if(this.rank < 0 || this.rank > 20000)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element of PartyMemberArenaInformations.rank.");
         }
    }

}