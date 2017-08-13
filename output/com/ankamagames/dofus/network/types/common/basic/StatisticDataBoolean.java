package com.ankamagames.dofus.network.types.common.basic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatisticDataBoolean extends StatisticData implements INetworkType {

    private int protocolId = 482;
    private boolean value = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.value);
         param1.writeBoolean(this.value);
         super.serializeAs_StatisticData(param1);
         param1.writeBoolean(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.value = param1.readBoolean();
    }

}