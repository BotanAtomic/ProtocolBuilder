package package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockBuyableInformations extends Object implements INetworkType {

    private int protocolId = 130;
    private Number price = 0;
    private boolean locked = false;


    public int getTypeId() {
         return 130;
    }

    public PaddockBuyableInformations initPaddockBuyableInformations(Number param1,boolean  param2) {
         this.price = param1;
         this.locked = param2;
         return this;
    }

    public void reset() {
         this.price = 0;
         this.locked = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PaddockBuyableInformations(param1);
    }

    public void serializeAs_PaddockBuyableInformations(ICustomDataOutput param1) {
         if(this.price < 0 || this.price > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockBuyableInformations(param1);
    }

    public void deserializeAs_PaddockBuyableInformations(ICustomDataInput param1) {
         this._priceFunc(param1);
         this._lockedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockBuyableInformations(param1);
    }

    public void deserializeAsyncAs_PaddockBuyableInformations(FuncTree param1) {
         param1.addChild(this._priceFunc);
         param1.addChild(this._lockedFunc);
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.price + ") on element of PaddockBuyableInformations.price.");
    }

    private void _lockedFunc(ICustomDataInput param1) {
         this.locked = param1.readBoolean();
    }

}