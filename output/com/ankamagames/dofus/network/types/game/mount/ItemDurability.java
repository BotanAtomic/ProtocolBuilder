package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ItemDurability extends Object implements INetworkType {

    private int protocolId = 168;
    private int durability = 0;
    private int durabilityMax = 0;


    public int getTypeId() {
         return 168;
    }

    public ItemDurability initItemDurability(int param1,int  param2) {
         this.durability = param1;
         this.durabilityMax = param2;
         return this;
    }

    public void reset() {
         this.durability = 0;
         this.durabilityMax = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ItemDurability(param1);
    }

    public void serializeAs_ItemDurability(ICustomDataOutput param1) {
         param1.writeShort(this.durability);
         param1.writeShort(this.durabilityMax);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ItemDurability(param1);
    }

    public void deserializeAs_ItemDurability(ICustomDataInput param1) {
         this._durabilityFunc(param1);
         this._durabilityMaxFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ItemDurability(param1);
    }

    public void deserializeAsyncAs_ItemDurability(FuncTree param1) {
         param1.addChild(this._durabilityFunc);
         param1.addChild(this._durabilityMaxFunc);
    }

    private void _durabilityFunc(ICustomDataInput param1) {
         this.durability = param1.readShort();
    }

    private void _durabilityMaxFunc(ICustomDataInput param1) {
         this.durabilityMax = param1.readShort();
    }

}