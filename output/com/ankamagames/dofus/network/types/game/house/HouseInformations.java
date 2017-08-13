package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseInformations extends Object implements INetworkType {

    private int protocolId = 111;
    private int houseId = 0;
    private int modelId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element modelId.");
         }
         param1.writeVarShort(this.modelId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseInformations.houseId.");
         }
         this.modelId = param1.readVarUhShort();
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element of HouseInformations.modelId.");
         }
    }

}