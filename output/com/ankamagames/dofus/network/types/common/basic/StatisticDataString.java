package com.ankamagames.dofus.network.types.common.basic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatisticDataString extends StatisticData implements INetworkType {

    private int protocolId = 487;
    private String value = "";


    public int getTypeId() {
         return 487;
    }

    public StatisticDataString initStatisticDataString(String param1) {
         this.value = param1;
         return this;
    }

    public void reset() {
         this.value = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StatisticDataString(param1);
    }

    public void serializeAs_StatisticDataString(ICustomDataOutput param1) {
         super.serializeAs_StatisticData(param1);
         param1.writeUTF(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatisticDataString(param1);
    }

    public void deserializeAs_StatisticDataString(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatisticDataString(param1);
    }

    public void deserializeAsyncAs_StatisticDataString(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readUTF();
    }

}