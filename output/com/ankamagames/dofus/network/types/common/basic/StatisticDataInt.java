package com.ankamagames.dofus.network.types.common.basic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatisticDataInt extends StatisticData implements INetworkType {

    private int protocolId = 485;
    private int value = 0;


    public int getTypeId() {
         return 485;
    }

    public StatisticDataInt initStatisticDataInt(int param1) {
         this.value = param1;
         return this;
    }

    public void reset() {
         this.value = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StatisticDataInt(param1);
    }

    public void serializeAs_StatisticDataInt(ICustomDataOutput param1) {
         super.serializeAs_StatisticData(param1);
         param1.writeInt(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatisticDataInt(param1);
    }

    public void deserializeAs_StatisticDataInt(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatisticDataInt(param1);
    }

    public void deserializeAsyncAs_StatisticDataInt(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readInt();
    }

}