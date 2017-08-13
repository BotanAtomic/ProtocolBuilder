package com.ankamagames.dofus.network.types.common.basic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatisticDataByte extends StatisticData implements INetworkType {

    private int protocolId = 486;
    private int value = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.value);
         param1.writeByte(this.value);
         super.serializeAs_StatisticData(param1);
         param1.writeByte(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.value = param1.readByte();
    }

}