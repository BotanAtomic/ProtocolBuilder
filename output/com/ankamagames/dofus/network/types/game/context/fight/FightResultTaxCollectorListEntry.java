package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightResultTaxCollectorListEntry extends FightResultFighterListEntry implements INetworkType {

    private int protocolId = 84;
    private int level = 0;
    private BasicGuildInformations guildInfo;
    private int experienceForGuild = 0;
    private FuncTree _guildInfotree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_FightResultFighterListEntry(param1);
         if(this.level < 1 || this.level > 200)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         this.guildInfo.serializeAs_BasicGuildInformations(param1);
         param1.writeInt(this.experienceForGuild);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultListEntry(param1);
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightResultFighterListEntry.id.");
         }
         this.alive = param1.readBoolean();
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 200)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightResultTaxCollectorListEntry.level.");
         }
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserialize(param1);
         this.experienceForGuild = param1.readInt();
    }

}