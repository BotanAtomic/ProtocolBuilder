package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightTeamMemberTaxCollectorInformations extends FightTeamMemberInformations implements INetworkType {

    private int protocolId = 177;
    private int firstNameId = 0;
    private int lastNameId = 0;
    private int level = 0;
    private int guildId = 0;
    private int uid = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberInformations(param1);
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
         }
         param1.writeVarShort(this.firstNameId);
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
         }
         param1.writeVarShort(this.lastNameId);
         if(this.level < 1 || this.level > 200)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
         }
         param1.writeVarInt(this.uid);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightTeamMemberInformations.id.");
         }
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of FightTeamMemberTaxCollectorInformations.firstNameId.");
         }
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of FightTeamMemberTaxCollectorInformations.lastNameId.");
         }
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 200)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightTeamMemberTaxCollectorInformations.level.");
         }
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of FightTeamMemberTaxCollectorInformations.guildId.");
         }
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element of FightTeamMemberTaxCollectorInformations.uid.");
         }
    }

}