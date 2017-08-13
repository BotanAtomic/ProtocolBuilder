package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AllianceFactSheetInformations extends AllianceInformations implements INetworkType {

    private int protocolId = 421;
    private int creationDate = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AllianceInformations(param1);
         if(this.creationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.creationDate + ") on element creationDate.");
         }
         param1.writeInt(this.creationDate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalGuildInformations(param1);
         this.alliance = new BasicAllianceInformations();
         this.alliance.deserialize(param1);
         this.creationDate = param1.readInt();
         if(this.creationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.creationDate + ") on element of AllianceFactSheetInformations.creationDate.");
         }
    }

}