package package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemToSellInBid extends ObjectItemToSell implements INetworkType {

    private int protocolId = 164;
    private int unsoldDelay = 0;


    public int getTypeId() {
         return 164;
    }

    public ObjectItemToSellInBid initObjectItemToSellInBid(int param1,Vector.<ObjectEffect>  param2,int  param3,int  param4,Number  param5,int  param6) {
         super.initObjectItemToSell(param1,param2,param3,param4,param5);
         this.unsoldDelay = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.unsoldDelay = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemToSellInBid(param1);
    }

    public void serializeAs_ObjectItemToSellInBid(ICustomDataOutput param1) {
         super.serializeAs_ObjectItemToSell(param1);
         if(this.unsoldDelay < 0)
            throw new Exception("Forbidden value (" + this.unsoldDelay + ") on element unsoldDelay.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemToSellInBid(param1);
    }

    public void deserializeAs_ObjectItemToSellInBid(ICustomDataInput param1) {
         super.deserialize(param1);
         this._unsoldDelayFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemToSellInBid(param1);
    }

    public void deserializeAsyncAs_ObjectItemToSellInBid(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._unsoldDelayFunc);
    }

    private void _unsoldDelayFunc(ICustomDataInput param1) {
         this.unsoldDelay = param1.readInt();
         if(this.unsoldDelay < 0)
            throw new Exception("Forbidden value (" + this.unsoldDelay + ") on element of ObjectItemToSellInBid.unsoldDelay.");
    }

}