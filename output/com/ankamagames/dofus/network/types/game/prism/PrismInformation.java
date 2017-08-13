package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PrismInformation extends Object implements INetworkType {

    private int protocolId = 428;
    private int typeId = 0;
    private int state = 1;
    private int nextVulnerabilityDate = 0;
    private int placementDate = 0;
    private int rewardTokenCount = 0;


    public void serialize(ICustomDataOutput param1) {
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
         this.typeId = param1.readByte();
         if(this.typeId < 0)
         {
            throw new Exception("Forbidden value (" + this.typeId + ") on element of PrismInformation.typeId.");
         }
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of PrismInformation.state.");
         }
         this.nextVulnerabilityDate = param1.readInt();
         if(this.nextVulnerabilityDate < 0)
         {
            throw new Exception("Forbidden value (" + this.nextVulnerabilityDate + ") on element of PrismInformation.nextVulnerabilityDate.");
         }
         this.placementDate = param1.readInt();
         if(this.placementDate < 0)
         {
            throw new Exception("Forbidden value (" + this.placementDate + ") on element of PrismInformation.placementDate.");
         }
         this.rewardTokenCount = param1.readVarUhInt();
         if(this.rewardTokenCount < 0)
         {
            throw new Exception("Forbidden value (" + this.rewardTokenCount + ") on element of PrismInformation.rewardTokenCount.");
         }
    }

}