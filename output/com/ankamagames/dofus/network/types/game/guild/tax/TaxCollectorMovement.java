package package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class TaxCollectorMovement extends Object implements INetworkType {

    private int protocolId = 493;
    private int movementType = 0;
    private TaxCollectorBasicInformations basicInfos = ;
    private Number playerId = 0;
    private String playerName = "";
    private FuncTree _basicInfostree = ;


    public int getTypeId() {
         return 493;
    }

    public TaxCollectorMovement initTaxCollectorMovement(int param1,TaxCollectorBasicInformations  param2,Number  param3,String  param4) {
         this.movementType = param1;
         this.basicInfos = param2;
         this.playerId = param3;
         this.playerName = param4;
         return this;
    }

    public void reset() {
         this.movementType = 0;
         this.basicInfos = new TaxCollectorBasicInformations();
         this.playerName = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorMovement(param1);
    }

    public void serializeAs_TaxCollectorMovement(ICustomDataOutput param1) {
         param1.writeByte(this.movementType);
         this.basicInfos.serializeAs_TaxCollectorBasicInformations(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorMovement(param1);
    }

    public void deserializeAs_TaxCollectorMovement(ICustomDataInput param1) {
         this._movementTypeFunc(param1);
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserialize(param1);
         this._playerIdFunc(param1);
         this._playerNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorMovement(param1);
    }

    public void deserializeAsyncAs_TaxCollectorMovement(FuncTree param1) {
         param1.addChild(this._movementTypeFunc);
         this._basicInfostree = param1.addChild(this._basicInfostreeFunc);
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._playerNameFunc);
    }

    private void _movementTypeFunc(ICustomDataInput param1) {
         this.movementType = param1.readByte();
         if(this.movementType < 0)
            throw new Exception("Forbidden value (" + this.movementType + ") on element of TaxCollectorMovement.movementType.");
    }

    private void _basicInfostreeFunc(ICustomDataInput param1) {
         this.basicInfos = new TaxCollectorBasicInformations();
         this.basicInfos.deserializeAsync(this._basicInfostree);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

}