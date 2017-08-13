package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HouseInformations extends Object implements INetworkType {

    private int protocolId = 111;
    private int houseId = 0;
    private int modelId = 0;


    public int getTypeId() {
         return 111;
    }

    public HouseInformations initHouseInformations(int param1,int  param2) {
         this.houseId = param1;
         this.modelId = param2;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.modelId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseInformations(param1);
    }

    public void serializeAs_HouseInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_HouseInformations(param1);
    }

    public void deserializeAs_HouseInformations(ICustomDataInput param1) {
         this._houseIdFunc(param1);
         this._modelIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseInformations(param1);
    }

    public void deserializeAsyncAs_HouseInformations(FuncTree param1) {
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._modelIdFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseInformations.houseId.");
         }
    }

    private void _modelIdFunc(ICustomDataInput param1) {
         this.modelId = param1.readVarUhShort();
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element of HouseInformations.modelId.");
         }
    }

}