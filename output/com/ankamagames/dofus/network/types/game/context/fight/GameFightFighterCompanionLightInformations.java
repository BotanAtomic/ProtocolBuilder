package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightFighterCompanionLightInformations extends GameFightFighterLightInformations implements INetworkType {

    private int protocolId = 454;
    private int companionId = 0;
    private Number masterId = 0;


    public int getTypeId() {
         return 454;
    }

    public GameFightFighterCompanionLightInformations initGameFightFighterCompanionLightInformations(Number param1,int  param2,int  param3,int  param4,boolean  param5,boolean  param6,int  param7,Number  param8) {
         super.initGameFightFighterLightInformations(param1,param2,param3,param4,param5,param6);
         this.companionId = param7;
         this.masterId = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.companionId = 0;
         this.masterId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightFighterCompanionLightInformations(param1);
    }

    public void serializeAs_GameFightFighterCompanionLightInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterLightInformations(param1);
         if(this.companionId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionId + ") on element companionId.");
         }
         param1.writeByte(this.companionId);
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element masterId.");
         }
         param1.writeDouble(this.masterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterCompanionLightInformations(param1);
    }

    public void deserializeAs_GameFightFighterCompanionLightInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._companionIdFunc(param1);
         this._masterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightFighterCompanionLightInformations(param1);
    }

    public void deserializeAsyncAs_GameFightFighterCompanionLightInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._companionIdFunc);
         param1.addChild(this._masterIdFunc);
    }

    private void _companionIdFunc(ICustomDataInput param1) {
         this.companionId = param1.readByte();
         if(this.companionId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionId + ") on element of GameFightFighterCompanionLightInformations.companionId.");
         }
    }

    private void _masterIdFunc(ICustomDataInput param1) {
         this.masterId = param1.readDouble();
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element of GameFightFighterCompanionLightInformations.masterId.");
         }
    }

}