package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GoldItem extends Item implements INetworkType {

    private int protocolId = 123;
    private Number sum = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         if(this.sum < 0 || this.sum > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sum + ") on element sum.");
         }
         param1.writeVarLong(this.sum);
    }

    public void deserialize(ICustomDataInput param1) {
         this.oldCellId = param1.readVarUhShort();
         if(this.oldCellId < 0 || this.oldCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.oldCellId + ") on element of PaddockMoveItemRequestMessage.oldCellId.");
         }
         this.newCellId = param1.readVarUhShort();
         if(this.newCellId < 0 || this.newCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.newCellId + ") on element of PaddockMoveItemRequestMessage.newCellId.");
         }
         this.sum = param1.readVarUhLong();
         if(this.sum < 0 || this.sum > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sum + ") on element of GoldItem.sum.");
         }
    }

}