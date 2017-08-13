package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightCompanionInformations extends GameFightFighterInformations implements INetworkType {

    private int protocolId = 450;
    private int companionGenericId = 0;
    private int level = 0;
    private Number masterId = 0;


    public int getTypeId() {
         return 450;
    }

    public GameFightCompanionInformations initGameFightCompanionInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector<uint>  param8,int  param9,int  param10,Number  param11) {
         super.initGameFightFighterInformations(param1,param2,param3,param4,param5,param6,param7,param8);
         this.companionGenericId = param9;
         this.level = param10;
         this.masterId = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.companionGenericId = 0;
         this.level = 0;
         this.masterId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightCompanionInformations(param1);
    }

    public void serializeAs_GameFightCompanionInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterInformations(param1);
         if(this.companionGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionGenericId + ") on element companionGenericId.");
         }
         param1.writeByte(this.companionGenericId);
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element masterId.");
         }
         param1.writeDouble(this.masterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightCompanionInformations(param1);
    }

    public void deserializeAs_GameFightCompanionInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._companionGenericIdFunc(param1);
         this._levelFunc(param1);
         this._masterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightCompanionInformations(param1);
    }

    public void deserializeAsyncAs_GameFightCompanionInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._companionGenericIdFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._masterIdFunc);
    }

    private void _companionGenericIdFunc(ICustomDataInput param1) {
         this.companionGenericId = param1.readByte();
         if(this.companionGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionGenericId + ") on element of GameFightCompanionInformations.companionGenericId.");
         }
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GameFightCompanionInformations.level.");
         }
    }

    private void _masterIdFunc(ICustomDataInput param1) {
         this.masterId = param1.readDouble();
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element of GameFightCompanionInformations.masterId.");
         }
    }

}