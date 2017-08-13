package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AdditionalTaxCollectorInformations extends Object implements INetworkType {

    private int protocolId = 165;
    private String collectorCallerName = "";
    private int date = 0;


    public int getTypeId() {
         return 165;
    }

    public AdditionalTaxCollectorInformations initAdditionalTaxCollectorInformations(String param1,int  param2) {
         this.collectorCallerName = param1;
         this.date = param2;
         return this;
    }

    public void reset() {
         this.collectorCallerName = "";
         this.date = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AdditionalTaxCollectorInformations(param1);
    }

    public void serializeAs_AdditionalTaxCollectorInformations(ICustomDataOutput param1) {
         param1.writeUTF(this.collectorCallerName);
         if(this.date < 0)
         {
            throw new Exception("Forbidden value (" + this.date + ") on element date.");
         }
         param1.writeInt(this.date);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AdditionalTaxCollectorInformations(param1);
    }

    public void deserializeAs_AdditionalTaxCollectorInformations(ICustomDataInput param1) {
         this._collectorCallerNameFunc(param1);
         this._dateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AdditionalTaxCollectorInformations(param1);
    }

    public void deserializeAsyncAs_AdditionalTaxCollectorInformations(FuncTree param1) {
         param1.addChild(this._collectorCallerNameFunc);
         param1.addChild(this._dateFunc);
    }

    private void _collectorCallerNameFunc(ICustomDataInput param1) {
         this.collectorCallerName = param1.readUTF();
    }

    private void _dateFunc(ICustomDataInput param1) {
         this.date = param1.readInt();
         if(this.date < 0)
         {
            throw new Exception("Forbidden value (" + this.date + ") on element of AdditionalTaxCollectorInformations.date.");
         }
    }

}