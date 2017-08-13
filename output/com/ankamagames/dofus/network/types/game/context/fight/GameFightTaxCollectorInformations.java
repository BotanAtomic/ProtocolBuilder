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

public class GameFightTaxCollectorInformations extends GameFightAIInformations implements INetworkType {

    private int protocolId = 48;
    private int firstNameId = 0;
    private int lastNameId = 0;
    private int level = 0;


    public int getTypeId() {
         return 48;
    }

    public GameFightTaxCollectorInformations initGameFightTaxCollectorInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector<uint>  param8,int  param9,int  param10,int  param11) {
         super.initGameFightAIInformations(param1,param2,param3,param4,param5,param6,param7,param8);
         this.firstNameId = param9;
         this.lastNameId = param10;
         this.level = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.firstNameId = 0;
         this.lastNameId = 0;
         this.level = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightTaxCollectorInformations(param1);
    }

    public void serializeAs_GameFightTaxCollectorInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightAIInformations(param1);
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
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightTaxCollectorInformations(param1);
    }

    public void deserializeAs_GameFightTaxCollectorInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._firstNameIdFunc(param1);
         this._lastNameIdFunc(param1);
         this._levelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightTaxCollectorInformations(param1);
    }

    public void deserializeAsyncAs_GameFightTaxCollectorInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._firstNameIdFunc);
         param1.addChild(this._lastNameIdFunc);
         param1.addChild(this._levelFunc);
    }

    private void _firstNameIdFunc(ICustomDataInput param1) {
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of GameFightTaxCollectorInformations.firstNameId.");
         }
    }

    private void _lastNameIdFunc(ICustomDataInput param1) {
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of GameFightTaxCollectorInformations.lastNameId.");
         }
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GameFightTaxCollectorInformations.level.");
         }
    }

}