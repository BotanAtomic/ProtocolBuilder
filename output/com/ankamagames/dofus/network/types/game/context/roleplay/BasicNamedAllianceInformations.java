package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicNamedAllianceInformations extends BasicAllianceInformations implements INetworkType {

    private int protocolId = 418;
    private String allianceName = "";


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractSocialGroupInfos(param1);
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
         }
         param1.writeVarInt(this.allianceId);
         param1.writeUTF(this.allianceTag);
         param1.writeUTF(this.allianceName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of BasicAllianceInformations.allianceId.");
         }
         this.allianceTag = param1.readUTF();
         this.allianceName = param1.readUTF();
    }

}