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
import java.lang.Exception;

public class TaxCollectorBasicInformations extends Object implements INetworkType {

    private int protocolId = 96;
    private int firstNameId = 0;
    private int lastNameId = 0;
    private int worldX = 0;
    private int worldY = 0;
    private int mapId = 0;
    private int subAreaId = 0;


    public int getTypeId() {
         return 96;
    }

    public TaxCollectorBasicInformations initTaxCollectorBasicInformations(int param1,int  param2,int  param3,int  param4,int  param5,int  param6) {
         this.firstNameId = param1;
         this.lastNameId = param2;
         this.worldX = param3;
         this.worldY = param4;
         this.mapId = param5;
         this.subAreaId = param6;
         return this;
    }

    public void reset() {
         this.firstNameId = 0;
         this.lastNameId = 0;
         this.worldX = 0;
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorBasicInformations(param1);
    }

    public void serializeAs_TaxCollectorBasicInformations(ICustomDataOutput param1) {
         if(this.firstNameId < 0)
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorBasicInformations(param1);
    }

    public void deserializeAs_TaxCollectorBasicInformations(ICustomDataInput param1) {
         this._firstNameIdFunc(param1);
         this._lastNameIdFunc(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorBasicInformations(param1);
    }

    public void deserializeAsyncAs_TaxCollectorBasicInformations(FuncTree param1) {
         param1.addChild(this._firstNameIdFunc);
         param1.addChild(this._lastNameIdFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
    }

    private void _firstNameIdFunc(ICustomDataInput param1) {
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of TaxCollectorBasicInformations.firstNameId.");
    }

    private void _lastNameIdFunc(ICustomDataInput param1) {
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of TaxCollectorBasicInformations.lastNameId.");
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of TaxCollectorBasicInformations.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of TaxCollectorBasicInformations.worldY.");
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of TaxCollectorBasicInformations.subAreaId.");
    }

}