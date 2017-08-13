package package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterToRemodelInformations extends CharacterRemodelingInformation implements INetworkType {

    private int protocolId = 477;
    private int possibleChangeMask = 0;
    private int mandatoryChangeMask = 0;


    public int getTypeId() {
         return 477;
    }

    public CharacterToRemodelInformations initCharacterToRemodelInformations(Number param1,String  param2,int  param3,boolean  param4,int  param5,Vector.<int>  param6,int  param7,int  param8) {
         super.initCharacterRemodelingInformation(param1,param2,param3,param4,param5,param6);
         this.possibleChangeMask = param7;
         this.mandatoryChangeMask = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.possibleChangeMask = 0;
         this.mandatoryChangeMask = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterToRemodelInformations(param1);
    }

    public void serializeAs_CharacterToRemodelInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterRemodelingInformation(param1);
         if(this.possibleChangeMask < 0)
            throw new Exception("Forbidden value (" + this.possibleChangeMask + ") on element possibleChangeMask.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterToRemodelInformations(param1);
    }

    public void deserializeAs_CharacterToRemodelInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._possibleChangeMaskFunc(param1);
         this._mandatoryChangeMaskFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterToRemodelInformations(param1);
    }

    public void deserializeAsyncAs_CharacterToRemodelInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._possibleChangeMaskFunc);
         param1.addChild(this._mandatoryChangeMaskFunc);
    }

    private void _possibleChangeMaskFunc(ICustomDataInput param1) {
         this.possibleChangeMask = param1.readByte();
         if(this.possibleChangeMask < 0)
            throw new Exception("Forbidden value (" + this.possibleChangeMask + ") on element of CharacterToRemodelInformations.possibleChangeMask.");
    }

    private void _mandatoryChangeMaskFunc(ICustomDataInput param1) {
         this.mandatoryChangeMask = param1.readByte();
         if(this.mandatoryChangeMask < 0)
            throw new Exception("Forbidden value (" + this.mandatoryChangeMask + ") on element of CharacterToRemodelInformations.mandatoryChangeMask.");
    }

}