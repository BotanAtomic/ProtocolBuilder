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


    public int getTypeId() {
         return 445;
    }

    public CharacterMinimalGuildInformations initCharacterMinimalGuildInformations(Number param1,String  param2,int  param3,EntityLook  param4,BasicGuildInformations  param5) {
         super.initCharacterMinimalPlusLookInformations(param1,param2,param3,param4);
         this.guild = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.guild = new BasicGuildInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterMinimalGuildInformations(param1);
    }

    public void serializeAs_CharacterMinimalGuildInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalPlusLookInformations(param1);
         this.guild.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalGuildInformations(param1);
    }

    public void deserializeAs_CharacterMinimalGuildInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.guild = new BasicGuildInformations();
         this.guild.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterMinimalGuildInformations(param1);
    }

    public void deserializeAsyncAs_CharacterMinimalGuildInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._guildtree = param1.addChild(this._guildtreeFunc);
    }

    private void _guildtreeFunc(ICustomDataInput param1) {
         this.guild = new BasicGuildInformations();
         this.guild.deserializeAsync(this._guildtree);
    }

}