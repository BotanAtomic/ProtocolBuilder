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


    public int getTypeId() {
         return 444;
    }

    public CharacterMinimalAllianceInformations initCharacterMinimalAllianceInformations(Number param1,String  param2,int  param3,EntityLook  param4,BasicGuildInformations  param5,BasicAllianceInformations  param6) {
         super.initCharacterMinimalGuildInformations(param1,param2,param3,param4,param5);
         this.alliance = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.alliance = new BasicAllianceInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterMinimalAllianceInformations(param1);
    }

    public void serializeAs_CharacterMinimalAllianceInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalGuildInformations(param1);
         this.alliance.serializeAs_BasicAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalAllianceInformations(param1);
    }

    public void deserializeAs_CharacterMinimalAllianceInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.alliance = new BasicAllianceInformations();
         this.alliance.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterMinimalAllianceInformations(param1);
    }

    public void deserializeAsyncAs_CharacterMinimalAllianceInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._alliancetree = param1.addChild(this._alliancetreeFunc);
    }

    private void _alliancetreeFunc(ICustomDataInput param1) {
         this.alliance = new BasicAllianceInformations();
         this.alliance.deserializeAsync(this._alliancetree);
    }

}