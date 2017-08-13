package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SpellItem extends Item implements INetworkType {

    private int protocolId = 49;
    private int spellId = 0;
    private int spellLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         param1.writeInt(this.spellId);
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
         }
         param1.writeShort(this.spellLevel);
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
         this.spellId = param1.readInt();
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element of SpellItem.spellLevel.");
         }
    }

}