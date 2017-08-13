package com.ankamagames.dofus.network.types.common.basic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatisticData extends Object implements INetworkType {

    private int protocolId = 484;


    public int getTypeId() {
         return 484;
    }

    public StatisticData initStatisticData() {
         return this;
    }

    public void reset() {
    }

    public void serialize(ICustomDataOutput param1) {
    }

    public void serializeAs_StatisticData(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

    public void deserializeAs_StatisticData(ICustomDataInput param1) {
    }

    public void deserializeAsync(FuncTree param1) {
    }

    public void deserializeAsyncAs_StatisticData(FuncTree param1) {
    }

}