package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TaxCollectorLootInformations extends TaxCollectorComplementaryInformations implements INetworkType {

    private int protocolId = 372;
    private Number kamas = 0;
    private Number experience = 0;
    private int pods = 0;
    private Number itemsValue = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
         }
         param1.writeVarLong(this.kamas);
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
         }
         param1.writeVarLong(this.experience);
         if(this.pods < 0)
         {
            throw new Exception("Forbidden value (" + this.pods + ") on element pods.");
         }
         param1.writeVarInt(this.pods);
         if(this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.itemsValue + ") on element itemsValue.");
         }
         param1.writeVarLong(this.itemsValue);
    }

    public void deserialize(ICustomDataInput param1) {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element of TaxCollectorLootInformations.kamas.");
         }
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experience + ") on element of TaxCollectorLootInformations.experience.");
         }
         this.pods = param1.readVarUhInt();
         if(this.pods < 0)
         {
            throw new Exception("Forbidden value (" + this.pods + ") on element of TaxCollectorLootInformations.pods.");
         }
         this.itemsValue = param1.readVarUhLong();
         if(this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.itemsValue + ") on element of TaxCollectorLootInformations.itemsValue.");
         }
    }

}