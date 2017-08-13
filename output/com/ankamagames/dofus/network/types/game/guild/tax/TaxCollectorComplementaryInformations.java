package package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorComplementaryInformations extends Object implements INetworkType {

    private int protocolId = 448;


    public int getTypeId() {
         return 448;
    }

    public TaxCollectorComplementaryInformations initTaxCollectorComplementaryInformations() {
         return this;
    }

    public void reset() {
    }

    public void serialize(ICustomDataOutput param1) {
    }

    public void serializeAs_TaxCollectorComplementaryInformations(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

    public void deserializeAs_TaxCollectorComplementaryInformations(ICustomDataInput param1) {
    }

    public void deserializeAsync(FuncTree param1) {
    }

    public void deserializeAsyncAs_TaxCollectorComplementaryInformations(FuncTree param1) {
    }

}