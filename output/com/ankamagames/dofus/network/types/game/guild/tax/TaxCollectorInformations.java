package package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TaxCollectorInformations extends Object implements INetworkType {

    private int protocolId = 167;
    private int uniqueId = 0;
    private int firtNameId = 0;
    private int lastNameId = 0;
    private AdditionalTaxCollectorInformations additionalInfos = ;
    private int worldX = 0;
    private int worldY = 0;
    private int subAreaId = 0;
    private int state = 0;
    private EntityLook look = ;
    private Vector.<TaxCollectorComplementaryInformations> complements = ;
    private FuncTree _additionalInfostree = ;
    private FuncTree _looktree = ;
    private FuncTree _complementstree = ;
    private int _loc2_ = 0;
    private TaxCollectorComplementaryInformations _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private TaxCollectorComplementaryInformations _loc3_ = ProtocolTypeManager.getInstance(TaxCollectorComplementaryInformations,_loc2_);


    public int getTypeId() {
         return 167;
    }

    public TaxCollectorInformations initTaxCollectorInformations(int param1,int  param2,int  param3,AdditionalTaxCollectorInformations  param4,int  param5,int  param6,int  param7,int  param8,EntityLook  param9,Vector.<TaxCollectorComplementaryInformations>  param10) {
         this.uniqueId = param1;
         this.firtNameId = param2;
         this.lastNameId = param3;
         this.additionalInfos = param4;
         this.worldX = param5;
         this.worldY = param6;
         this.subAreaId = param7;
         this.state = param8;
         this.look = param9;
         this.complements = param10;
         return this;
    }

    public void reset() {
         this.uniqueId = 0;
         this.firtNameId = 0;
         this.lastNameId = 0;
         this.additionalInfos = new AdditionalTaxCollectorInformations();
         this.worldY = 0;
         this.subAreaId = 0;
         this.state = 0;
         this.look = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorInformations(param1);
    }

    public void serializeAs_TaxCollectorInformations(ICustomDataOutput param1) {
         param1.writeInt(this.uniqueId);
         if(this.firtNameId < 0)
            throw new Exception("Forbidden value (" + this.firtNameId + ") on element firtNameId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorInformations(param1);
    }

    public void deserializeAs_TaxCollectorInformations(ICustomDataInput param1) {
         int _loc4_ = 0;
         TaxCollectorComplementaryInformations _loc5_ = null;
         this._uniqueIdFunc(param1);
         this._firtNameIdFunc(param1);
         this._lastNameIdFunc(param1);
         this.additionalInfos = new AdditionalTaxCollectorInformations();
         this.additionalInfos.deserialize(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._subAreaIdFunc(param1);
         this._stateFunc(param1);
         this.look = new EntityLook();
         this.look.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(TaxCollectorComplementaryInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.complements.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorInformations(param1);
    }

    public void deserializeAsyncAs_TaxCollectorInformations(FuncTree param1) {
         param1.addChild(this._uniqueIdFunc);
         param1.addChild(this._firtNameIdFunc);
         param1.addChild(this._lastNameIdFunc);
         this._additionalInfostree = param1.addChild(this._additionalInfostreeFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._subAreaIdFunc);
         param1.addChild(this._stateFunc);
         this._looktree = param1.addChild(this._looktreeFunc);
         this._complementstree = param1.addChild(this._complementstreeFunc);
    }

    private void _uniqueIdFunc(ICustomDataInput param1) {
         this.uniqueId = param1.readInt();
    }

    private void _firtNameIdFunc(ICustomDataInput param1) {
         this.firtNameId = param1.readVarUhShort();
         if(this.firtNameId < 0)
            throw new Exception("Forbidden value (" + this.firtNameId + ") on element of TaxCollectorInformations.firtNameId.");
    }

    private void _lastNameIdFunc(ICustomDataInput param1) {
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of TaxCollectorInformations.lastNameId.");
    }

    private void _additionalInfostreeFunc(ICustomDataInput param1) {
         this.additionalInfos = new AdditionalTaxCollectorInformations();
         this.additionalInfos.deserializeAsync(this._additionalInfostree);
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of TaxCollectorInformations.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of TaxCollectorInformations.worldY.");
    }

    private void _subAreaIdFunc(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of TaxCollectorInformations.subAreaId.");
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readByte();
         if(this.state < 0)
            throw new Exception("Forbidden value (" + this.state + ") on element of TaxCollectorInformations.state.");
    }

    private void _looktreeFunc(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserializeAsync(this._looktree);
    }

    private void _complementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._complementstree.addChild(this._complementsFunc);
            _loc3_++;
    }

    private void _complementsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         TaxCollectorComplementaryInformations _loc3_ = ProtocolTypeManager.getInstance(TaxCollectorComplementaryInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.complements.push(_loc3_);
    }

}