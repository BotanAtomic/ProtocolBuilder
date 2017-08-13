package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamMemberWithAllianceCharacterInformations extends FightTeamMemberCharacterInformations implements INetworkType {

    private int protocolId = 426;
    private BasicAllianceInformations allianceInfos;
    private FuncTree _allianceInfostree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberCharacterInformations(param1);
         this.allianceInfos.serializeAs_BasicAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamMemberInformations(param1);
         this.name = param1.readUTF();
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightTeamMemberCharacterInformations.level.");
         }
         this.allianceInfos = new BasicAllianceInformations();
         this.allianceInfos.deserialize(param1);
    }

}