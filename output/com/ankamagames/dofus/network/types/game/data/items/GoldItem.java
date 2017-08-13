package package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GoldItem extends Item implements INetworkType {

    private int protocolId = 123;
    private Number sum = 0;


    public int getTypeId() {
         return 123;
    }

    public GoldItem initGoldItem(Number param1) {
         this.sum = param1;
         return this;
    }

    public void reset() {
         this.sum = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GoldItem(param1);
    }

    public void serializeAs_GoldItem(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         if(this.sum < 0 || this.sum > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sum + ") on element sum.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GoldItem(param1);
    }

    public void deserializeAs_GoldItem(ICustomDataInput param1) {
         super.deserialize(param1);
         this._sumFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GoldItem(param1);
    }

    public void deserializeAsyncAs_GoldItem(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._sumFunc);
    }

    private void _sumFunc(ICustomDataInput param1) {
         this.sum = param1.readVarUhLong();
         if(this.sum < 0 || this.sum > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sum + ") on element of GoldItem.sum.");
    }

}