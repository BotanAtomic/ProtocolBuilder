package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightResultTaxCollectorListEntry extends FightResultFighterListEntry implements INetworkType {

    private int protocolId = 84;
    private int level = 0;
    private BasicGuildInformations guildInfo = ;
    private int experienceForGuild = 0;
    private FuncTree _guildInfotree = ;


    public int getTypeId() {
         return 84;
    }

    public FightResultTaxCollectorListEntry initFightResultTaxCollectorListEntry(int param1,int  param2,FightLoot  param3,Number  param4,boolean  param5,int  param6,BasicGuildInformations  param7,int  param8) {
         super.initFightResultFighterListEntry(param1,param2,param3,param4,param5);
         this.level = param6;
         this.guildInfo = param7;
         this.experienceForGuild = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.level = 0;
         this.guildInfo = new BasicGuildInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightResultTaxCollectorListEntry(param1);
    }

    public void serializeAs_FightResultTaxCollectorListEntry(ICustomDataOutput param1) {
         super.serializeAs_FightResultFighterListEntry(param1);
         if(this.level < 1 || this.level > 200)
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultTaxCollectorListEntry(param1);
    }

    public void deserializeAs_FightResultTaxCollectorListEntry(ICustomDataInput param1) {
         super.deserialize(param1);
         this._levelFunc(param1);
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserialize(param1);
         this._experienceForGuildFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightResultTaxCollectorListEntry(param1);
    }

    public void deserializeAsyncAs_FightResultTaxCollectorListEntry(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._levelFunc);
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
         param1.addChild(this._experienceForGuildFunc);
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 200)
            throw new Exception("Forbidden value (" + this.level + ") on element of FightResultTaxCollectorListEntry.level.");
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

    private void _experienceForGuildFunc(ICustomDataInput param1) {
         this.experienceForGuild = param1.readInt();
    }

}