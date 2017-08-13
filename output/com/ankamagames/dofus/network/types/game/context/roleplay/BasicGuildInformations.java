package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class BasicGuildInformations extends AbstractSocialGroupInfos implements INetworkType {

    private int protocolId = 365;
    private int guildId = 0;
    private String guildName = "";
    private int guildLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
         param1.writeUTF(this.guildName);
         if(this.guildLevel < 0 || this.guildLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
         }
         param1.writeByte(this.guildLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of BasicGuildInformations.guildId.");
         }
         this.guildName = param1.readUTF();
         this.guildLevel = param1.readUnsignedByte();
         if(this.guildLevel < 0 || this.guildLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element of BasicGuildInformations.guildLevel.");
         }
    }

}