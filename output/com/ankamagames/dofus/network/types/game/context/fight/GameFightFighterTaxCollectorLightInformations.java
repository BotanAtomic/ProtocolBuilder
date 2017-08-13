package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightFighterTaxCollectorLightInformations extends GameFightFighterLightInformations implements INetworkType {

    private int protocolId = 457;
    private int firstNameId = 0;
    private int lastNameId = 0;


    public int getTypeId() {
         return 457;
    }

    public GameFightFighterTaxCollectorLightInformations initGameFightFighterTaxCollectorLightInformations(Number param1,int  param2,int  param3,int  param4,boolean  param5,boolean  param6,int  param7,int  param8) {
         super.initGameFightFighterLightInformations(param1,param2,param3,param4,param5,param6);
         this.firstNameId = param7;
         this.lastNameId = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.firstNameId = 0;
         this.lastNameId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightFighterTaxCollectorLightInformations(param1);
    }

    public void serializeAs_GameFightFighterTaxCollectorLightInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterLightInformations(param1);
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
         }
         param1.writeVarShort(this.firstNameId);
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
         }
         param1.writeVarShort(this.lastNameId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterTaxCollectorLightInformations(param1);
    }

    public void deserializeAs_GameFightFighterTaxCollectorLightInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._firstNameIdFunc(param1);
         this._lastNameIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightFighterTaxCollectorLightInformations(param1);
    }

    public void deserializeAsyncAs_GameFightFighterTaxCollectorLightInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._firstNameIdFunc);
         param1.addChild(this._lastNameIdFunc);
    }

    private void _firstNameIdFunc(ICustomDataInput param1) {
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of GameFightFighterTaxCollectorLightInformations.firstNameId.");
         }
    }

    private void _lastNameIdFunc(ICustomDataInput param1) {
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of GameFightFighterTaxCollectorLightInformations.lastNameId.");
         }
    }

}