package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildInAllianceInformations extends GuildInformations implements INetworkType {

    private int protocolId = 420;
    private int nbMembers = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GuildInformations(param1);
         if(this.nbMembers < 1 || this.nbMembers > 240)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
         }
         param1.writeByte(this.nbMembers);
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
         this.nbMembers = param1.readUnsignedByte();
         if(this.nbMembers < 1 || this.nbMembers > 240)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element of GuildInAllianceInformations.nbMembers.");
         }
    }

}