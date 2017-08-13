package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildFactSheetInformations extends GuildInformations implements INetworkType {

    private int protocolId = 424;
    private Number leaderId = 0;
    private int nbMembers = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.abandonnedPaddock);
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         if(this.expLevelFloor < 0 || this.expLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.expLevelFloor + ") on element expLevelFloor.");
         }
         param1.writeVarLong(this.expLevelFloor);
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
         }
         param1.writeVarLong(this.experience);
         if(this.expNextLevelFloor < 0 || this.expNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.expNextLevelFloor + ") on element expNextLevelFloor.");
         }
         param1.writeVarLong(this.expNextLevelFloor);
         if(this.creationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.creationDate + ") on element creationDate.");
         }
         param1.writeInt(this.creationDate);
         if(this.nbTotalMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbTotalMembers + ") on element nbTotalMembers.");
         }
         param1.writeVarShort(this.nbTotalMembers);
         if(this.nbConnectedMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbConnectedMembers + ") on element nbConnectedMembers.");
         }
         param1.writeVarShort(this.nbConnectedMembers);
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
         }
         param1.writeVarLong(this.leaderId);
         if(this.nbMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
         }
         param1.writeVarShort(this.nbMembers);
    }

    public void deserialize(ICustomDataInput param1) {
         this.abandonnedPaddock = param1.readBoolean();
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GuildInformationsGeneralMessage.level.");
         }
         this.expLevelFloor = param1.readVarUhLong();
         if(this.expLevelFloor < 0 || this.expLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.expLevelFloor + ") on element of GuildInformationsGeneralMessage.expLevelFloor.");
         }
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element of GuildInformationsGeneralMessage.experience.");
         }
         this.expNextLevelFloor = param1.readVarUhLong();
         if(this.expNextLevelFloor < 0 || this.expNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.expNextLevelFloor + ") on element of GuildInformationsGeneralMessage.expNextLevelFloor.");
         }
         this.creationDate = param1.readInt();
         if(this.creationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.creationDate + ") on element of GuildInformationsGeneralMessage.creationDate.");
         }
         this.nbTotalMembers = param1.readVarUhShort();
         if(this.nbTotalMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbTotalMembers + ") on element of GuildInformationsGeneralMessage.nbTotalMembers.");
         }
         this.nbConnectedMembers = param1.readVarUhShort();
         if(this.nbConnectedMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbConnectedMembers + ") on element of GuildInformationsGeneralMessage.nbConnectedMembers.");
         }
         this.leaderId = param1.readVarUhLong();
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of GuildFactSheetInformations.leaderId.");
         }
         this.nbMembers = param1.readVarUhShort();
         if(this.nbMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element of GuildFactSheetInformations.nbMembers.");
         }
    }

}