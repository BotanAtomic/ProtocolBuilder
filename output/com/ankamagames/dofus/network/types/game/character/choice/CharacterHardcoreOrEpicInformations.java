package package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterHardcoreOrEpicInformations extends CharacterBaseInformations implements INetworkType {

    private int protocolId = 474;
    private int deathState = 0;
    private int deathCount = 0;
    private int deathMaxLevel = 0;


    public int getTypeId() {
         return 474;
    }

    public CharacterHardcoreOrEpicInformations initCharacterHardcoreOrEpicInformations(Number param1,String  param2,int  param3,EntityLook  param4,int  param5,boolean  param6,int  param7,int  param8,int  param9) {
         super.initCharacterBaseInformations(param1,param2,param3,param4,param5,param6);
         this.deathState = param7;
         this.deathCount = param8;
         this.deathMaxLevel = param9;
         return this;
    }

    public void reset() {
         super.reset();
         this.deathState = 0;
         this.deathCount = 0;
         this.deathMaxLevel = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterHardcoreOrEpicInformations(param1);
    }

    public void serializeAs_CharacterHardcoreOrEpicInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterBaseInformations(param1);
         param1.writeByte(this.deathState);
         if(this.deathCount < 0)
            throw new Exception("Forbidden value (" + this.deathCount + ") on element deathCount.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterHardcoreOrEpicInformations(param1);
    }

    public void deserializeAs_CharacterHardcoreOrEpicInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._deathStateFunc(param1);
         this._deathCountFunc(param1);
         this._deathMaxLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterHardcoreOrEpicInformations(param1);
    }

    public void deserializeAsyncAs_CharacterHardcoreOrEpicInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._deathStateFunc);
         param1.addChild(this._deathCountFunc);
         param1.addChild(this._deathMaxLevelFunc);
    }

    private void _deathStateFunc(ICustomDataInput param1) {
         this.deathState = param1.readByte();
         if(this.deathState < 0)
            throw new Exception("Forbidden value (" + this.deathState + ") on element of CharacterHardcoreOrEpicInformations.deathState.");
    }

    private void _deathCountFunc(ICustomDataInput param1) {
         this.deathCount = param1.readVarUhShort();
         if(this.deathCount < 0)
            throw new Exception("Forbidden value (" + this.deathCount + ") on element of CharacterHardcoreOrEpicInformations.deathCount.");
    }

    private void _deathMaxLevelFunc(ICustomDataInput param1) {
         this.deathMaxLevel = param1.readUnsignedByte();
         if(this.deathMaxLevel < 1 || this.deathMaxLevel > 206)
            throw new Exception("Forbidden value (" + this.deathMaxLevel + ") on element of CharacterHardcoreOrEpicInformations.deathMaxLevel.");
    }

}