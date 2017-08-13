package com.ankamagames.dofus.network.types.common.basic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatisticDataShort extends StatisticData implements INetworkType {

    private int protocolId = 488;
    private int value = 0;


    public int getTypeId() {
         return 488;
    }

    public StatisticDataShort initStatisticDataShort(int param1) {
         this.value = param1;
         return this;
    }

    public void reset() {
         this.value = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StatisticDataShort(param1);
    }

    public void serializeAs_StatisticDataShort(ICustomDataOutput param1) {
         super.serializeAs_StatisticData(param1);
         param1.writeShort(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatisticDataShort(param1);
    }

    public void deserializeAs_StatisticDataShort(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatisticDataShort(param1);
    }

    public void deserializeAsyncAs_StatisticDataShort(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readShort();
    }

}