package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class BasicAllianceInformations extends AbstractSocialGroupInfos implements INetworkType {

    private int protocolId = 419;
    private int allianceId = 0;
    private String allianceTag = "";


    public void serialize(ICustomDataOutput param1) {
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
         }
         param1.writeVarInt(this.allianceId);
         param1.writeUTF(this.allianceTag);
    }

    public void deserialize(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of BasicAllianceInformations.allianceId.");
         }
         this.allianceTag = param1.readUTF();
    }

}