package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.dofus.network.types.game.context.roleplay.ObjectItemInRolePlay;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.mount.ItemDurability;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockItem extends ObjectItemInRolePlay implements INetworkType {

    private int protocolId = 185;
    private ItemDurability durability;
    private FuncTree _durabilitytree;


    public void serialize(ICustomDataOutput param1) {
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
         this.durability.serializeAs_ItemDurability(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of ObjectItemInRolePlay.cellId.");
         }
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of ObjectItemInRolePlay.objectGID.");
         }
         this.durability = new ItemDurability();
         this.durability.deserialize(param1);
    }

}