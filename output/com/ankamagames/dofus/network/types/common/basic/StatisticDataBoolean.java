package package com.ankamagames.dofus.network.types.common.basic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatisticDataBoolean extends StatisticData implements INetworkType {

    private int protocolId = 482;
    private boolean value = false;


    public int getTypeId() {
         return 482;
    }

    public StatisticDataBoolean initStatisticDataBoolean(boolean param1) {
         this.value = param1;
         return this;
    }

    public void reset() {
         this.value = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StatisticDataBoolean(param1);
    }

    public void serializeAs_StatisticDataBoolean(ICustomDataOutput param1) {
         super.serializeAs_StatisticData(param1);
         param1.writeBoolean(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatisticDataBoolean(param1);
    }

    public void deserializeAs_StatisticDataBoolean(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatisticDataBoolean(param1);
    }

    public void deserializeAsyncAs_StatisticDataBoolean(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readBoolean();
    }

}