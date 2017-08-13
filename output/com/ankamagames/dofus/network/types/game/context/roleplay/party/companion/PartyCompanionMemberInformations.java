package com.ankamagames.dofus.network.types.game.context.roleplay.party.companion;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyCompanionMemberInformations extends PartyCompanionBaseInformations implements INetworkType {

    private int protocolId = 452;
    private int initiative = 0;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int prospecting = 0;
    private int regenRate = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.indexId < 0)
         {
            throw new Exception("Forbidden value (" + this.indexId + ") on element indexId.");
         }
         param1.writeByte(this.indexId);
         if(this.companionGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionGenericId + ") on element companionGenericId.");
         }
         param1.writeByte(this.companionGenericId);
         this.entityLook.serializeAs_EntityLook(param1);
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
         }
         param1.writeVarShort(this.initiative);
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
    }

    public void deserialize(ICustomDataInput param1) {
         this.indexId = param1.readByte();
         if(this.indexId < 0)
         {
            throw new Exception("Forbidden value (" + this.indexId + ") on element of PartyCompanionBaseInformations.indexId.");
         }
         this.companionGenericId = param1.readByte();
         if(this.companionGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionGenericId + ") on element of PartyCompanionBaseInformations.companionGenericId.");
         }
         this.entityLook = new EntityLook();
         this.entityLook.deserialize(param1);
         this.initiative = param1.readVarUhShort();
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element of PartyCompanionMemberInformations.initiative.");
         }
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of PartyCompanionMemberInformations.lifePoints.");
         }
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of PartyCompanionMemberInformations.maxLifePoints.");
         }
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of PartyCompanionMemberInformations.prospecting.");
         }
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of PartyCompanionMemberInformations.regenRate.");
         }
    }

}