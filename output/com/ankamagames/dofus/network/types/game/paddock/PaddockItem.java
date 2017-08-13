package package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.dofus.network.types.game.context.roleplay.ObjectItemInRolePlay;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.mount.ItemDurability;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockItem extends ObjectItemInRolePlay implements INetworkType {

    private int protocolId = 185;
    private ItemDurability durability = ;
    private FuncTree _durabilitytree = ;


    public int getTypeId() {
         return 185;
    }

    public PaddockItem initPaddockItem(int param1,int  param2,ItemDurability  param3) {
         super.initObjectItemInRolePlay(param1,param2);
         this.durability = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.durability = new ItemDurability();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PaddockItem(param1);
    }

    public void serializeAs_PaddockItem(ICustomDataOutput param1) {
         super.serializeAs_ObjectItemInRolePlay(param1);
         this.durability.serializeAs_ItemDurability(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockItem(param1);
    }

    public void deserializeAs_PaddockItem(ICustomDataInput param1) {
         super.deserialize(param1);
         this.durability = new ItemDurability();
         this.durability.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockItem(param1);
    }

    public void deserializeAsyncAs_PaddockItem(FuncTree param1) {
         super.deserializeAsync(param1);
         this._durabilitytree = param1.addChild(this._durabilitytreeFunc);
    }

    private void _durabilitytreeFunc(ICustomDataInput param1) {
         this.durability = new ItemDurability();
         this.durability.deserializeAsync(this._durabilitytree);
    }

}