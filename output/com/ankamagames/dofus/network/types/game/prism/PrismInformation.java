package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PrismInformation extends Object implements INetworkType {

    private int protocolId = 428;
    private int typeId = 0;
    private int state = 1;
    private int nextVulnerabilityDate = 0;
    private int placementDate = 0;
    private int rewardTokenCount = 0;


    public int getTypeId() {
         return 428;
    }

    public PrismInformation initPrismInformation(int param1,int  param2,int  param3,int  param4,int  param5) {
         this.typeId = param1;
         this.state = param2;
         this.nextVulnerabilityDate = param3;
         this.placementDate = param4;
         this.rewardTokenCount = param5;
         return this;
    }

    public void reset() {
         this.typeId = 0;
         this.state = 1;
         this.nextVulnerabilityDate = 0;
         this.placementDate = 0;
         this.rewardTokenCount = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PrismInformation(param1);
    }

    public void serializeAs_PrismInformation(ICustomDataOutput param1) {
         if(this.typeId < 0)
         {
            throw new Exception("Forbidden value (" + this.typeId + ") on element typeId.");
         }
         param1.writeByte(this.typeId);
         param1.writeByte(this.state);
         if(this.nextVulnerabilityDate < 0)
         {
            throw new Exception("Forbidden value (" + this.nextVulnerabilityDate + ") on element nextVulnerabilityDate.");
         }
         param1.writeInt(this.nextVulnerabilityDate);
         if(this.placementDate < 0)
         {
            throw new Exception("Forbidden value (" + this.placementDate + ") on element placementDate.");
         }
         param1.writeInt(this.placementDate);
         if(this.rewardTokenCount < 0)
         {
            throw new Exception("Forbidden value (" + this.rewardTokenCount + ") on element rewardTokenCount.");
         }
         param1.writeVarInt(this.rewardTokenCount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PrismInformation(param1);
    }

    public void deserializeAs_PrismInformation(ICustomDataInput param1) {
         this._typeIdFunc(param1);
         this._stateFunc(param1);
         this._nextVulnerabilityDateFunc(param1);
         this._placementDateFunc(param1);
         this._rewardTokenCountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PrismInformation(param1);
    }

    public void deserializeAsyncAs_PrismInformation(FuncTree param1) {
         param1.addChild(this._typeIdFunc);
         param1.addChild(this._stateFunc);
         param1.addChild(this._nextVulnerabilityDateFunc);
         param1.addChild(this._placementDateFunc);
         param1.addChild(this._rewardTokenCountFunc);
    }

    private void _typeIdFunc(ICustomDataInput param1) {
         this.typeId = param1.readByte();
         if(this.typeId < 0)
         {
            throw new Exception("Forbidden value (" + this.typeId + ") on element of PrismInformation.typeId.");
         }
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of PrismInformation.state.");
         }
    }

    private void _nextVulnerabilityDateFunc(ICustomDataInput param1) {
         this.nextVulnerabilityDate = param1.readInt();
         if(this.nextVulnerabilityDate < 0)
         {
            throw new Exception("Forbidden value (" + this.nextVulnerabilityDate + ") on element of PrismInformation.nextVulnerabilityDate.");
         }
    }

    private void _placementDateFunc(ICustomDataInput param1) {
         this.placementDate = param1.readInt();
         if(this.placementDate < 0)
         {
            throw new Exception("Forbidden value (" + this.placementDate + ") on element of PrismInformation.placementDate.");
         }
    }

    private void _rewardTokenCountFunc(ICustomDataInput param1) {
         this.rewardTokenCount = param1.readVarUhInt();
         if(this.rewardTokenCount < 0)
         {
            throw new Exception("Forbidden value (" + this.rewardTokenCount + ") on element of PrismInformation.rewardTokenCount.");
         }
    }

}