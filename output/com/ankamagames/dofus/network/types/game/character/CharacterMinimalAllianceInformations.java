package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicAllianceInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterMinimalAllianceInformations extends CharacterMinimalGuildInformations implements INetworkType {

    private int protocolId = 444;
    private BasicAllianceInformations alliance;
    private FuncTree _alliancetree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalPlusLookInformations(param1);
         this.guild.serializeAs_BasicGuildInformations(param1);
         this.alliance.serializeAs_BasicAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalGuildInformations(param1);
         this.alliance = new BasicAllianceInformations();
         this.alliance.deserialize(param1);
    }

}