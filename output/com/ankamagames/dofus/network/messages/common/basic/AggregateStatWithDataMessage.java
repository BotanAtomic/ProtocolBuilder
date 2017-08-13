package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.common.basic.StatisticData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class AggregateStatWithDataMessage extends AggregateStatMessage implements INetworkMessage {

    private int protocolId = 6662;
    private boolean _isInitialized = false;
    private StatisticData[] datas;
    private FuncTree _datastree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AggregateStatMessage(param1);
         param1.writeShort(this.datas.length);
         int _loc2_ = 0;
         while(_loc2_ < this.datas.length)
         {
            param1.writeShort((this.datas[_loc2_] as StatisticData).getTypeId());
            (this.datas[_loc2_] as StatisticData).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         StatisticData _loc5_ = null;
         this.statId = param1.readVarUhShort();
         if(this.statId < 0)
         {
            throw new Exception("Forbidden value (" + this.statId + ") on element of AggregateStatMessage.statId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(StatisticData,_loc4_);
            _loc5_.deserialize(param1);
            this.datas.push(_loc5_);
            _loc3_++;
         }
    }

}