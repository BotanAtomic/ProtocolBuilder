package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PrismSubareaEmptyInfo extends Object implements INetworkType {

    private int protocolId = 438;
    private int subAreaId = 0;
    private int allianceId = 0;


    public int getTypeId() {
         return 438;
    }

    public PrismSubareaEmptyInfo initPrismSubareaEmptyInfo(int param1,int  param2) {
         this.subAreaId = param1;
         this.allianceId = param2;
         return this;
    }

    public void reset() {
         this.subAreaId = 0;
         this.allianceId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PrismSubareaEmptyInfo(param1);
    }

    public void serializeAs_PrismSubareaEmptyInfo(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
         }
         param1.writeVarInt(this.allianceId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismSubareaEmptyInfo(param1);
    }

    public void deserializeAs_PrismSubareaEmptyInfo(ICustomDataInput param1) {
         this._subAreaIdFunc(param1);
         this._allianceIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismSubareaEmptyInfo(param1);
    }

    public void deserializeAsyncAs_PrismSubareaEmptyInfo(FuncTree param1) {
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._allianceIdFunc);
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismSubareaEmptyInfo.subAreaId.");
         }
    }

    private void _allianceIdFunc(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of PrismSubareaEmptyInfo.allianceId.");
         }
    }

}