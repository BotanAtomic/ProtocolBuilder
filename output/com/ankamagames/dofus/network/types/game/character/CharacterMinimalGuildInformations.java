package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterMinimalGuildInformations extends CharacterMinimalPlusLookInformations implements INetworkType {

    private int protocolId = 445;
    private BasicGuildInformations guild;
    private FuncTree _guildtree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalInformations(param1);
         this.entityLook.serializeAs_EntityLook(param1);
         this.guild.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalPlusLookInformations(param1);
         this.guild = new BasicGuildInformations();
         this.guild.deserialize(param1);
    }

}