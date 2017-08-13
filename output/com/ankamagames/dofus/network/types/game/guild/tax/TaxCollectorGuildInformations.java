package package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorGuildInformations extends TaxCollectorComplementaryInformations implements INetworkType {

    private int protocolId = 446;
    private BasicGuildInformations guild = ;
    private FuncTree _guildtree = ;


    public int getTypeId() {
         return 446;
    }

    public TaxCollectorGuildInformations initTaxCollectorGuildInformations(BasicGuildInformations param1) {
         this.guild = param1;
         return this;
    }

    public void reset() {
         this.guild = new BasicGuildInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorGuildInformations(param1);
    }

    public void serializeAs_TaxCollectorGuildInformations(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorComplementaryInformations(param1);
         this.guild.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorGuildInformations(param1);
    }

    public void deserializeAs_TaxCollectorGuildInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.guild = new BasicGuildInformations();
         this.guild.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorGuildInformations(param1);
    }

    public void deserializeAsyncAs_TaxCollectorGuildInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._guildtree = param1.addChild(this._guildtreeFunc);
    }

    private void _guildtreeFunc(ICustomDataInput param1) {
         this.guild = new BasicGuildInformations();
         this.guild.deserializeAsync(this._guildtree);
    }

}