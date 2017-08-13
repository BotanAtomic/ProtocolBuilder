package package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TaxCollectorLootInformations extends TaxCollectorComplementaryInformations implements INetworkType {

    private int protocolId = 372;
    private Number kamas = 0;
    private Number experience = 0;
    private int pods = 0;
    private Number itemsValue = 0;


    public int getTypeId() {
         return 372;
    }

    public TaxCollectorLootInformations initTaxCollectorLootInformations(Number param1,Number  param2,int  param3,Number  param4) {
         this.kamas = param1;
         this.experience = param2;
         this.pods = param3;
         this.itemsValue = param4;
         return this;
    }

    public void reset() {
         this.kamas = 0;
         this.experience = 0;
         this.pods = 0;
         this.itemsValue = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorLootInformations(param1);
    }

    public void serializeAs_TaxCollectorLootInformations(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorComplementaryInformations(param1);
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorLootInformations(param1);
    }

    public void deserializeAs_TaxCollectorLootInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._kamasFunc(param1);
         this._experienceFunc(param1);
         this._podsFunc(param1);
         this._itemsValueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorLootInformations(param1);
    }

    public void deserializeAsyncAs_TaxCollectorLootInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._kamasFunc);
         param1.addChild(this._experienceFunc);
         param1.addChild(this._podsFunc);
         param1.addChild(this._itemsValueFunc);
    }

    private void _kamasFunc(ICustomDataInput param1) {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kamas + ") on element of TaxCollectorLootInformations.kamas.");
    }

    private void _experienceFunc(ICustomDataInput param1) {
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.experience + ") on element of TaxCollectorLootInformations.experience.");
    }

    private void _podsFunc(ICustomDataInput param1) {
         this.pods = param1.readVarUhInt();
         if(this.pods < 0)
            throw new Exception("Forbidden value (" + this.pods + ") on element of TaxCollectorLootInformations.pods.");
    }

    private void _itemsValueFunc(ICustomDataInput param1) {
         this.itemsValue = param1.readVarUhLong();
         if(this.itemsValue < 0 || this.itemsValue > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.itemsValue + ") on element of TaxCollectorLootInformations.itemsValue.");
    }

}