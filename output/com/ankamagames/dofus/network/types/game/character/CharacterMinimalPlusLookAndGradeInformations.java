package package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterMinimalPlusLookAndGradeInformations extends CharacterMinimalPlusLookInformations implements INetworkType {

    private int protocolId = 193;
    private int grade = 0;


    public int getTypeId() {
         return 193;
    }

    public CharacterMinimalPlusLookAndGradeInformations initCharacterMinimalPlusLookAndGradeInformations(Number param1,String  param2,int  param3,EntityLook  param4,int  param5) {
         super.initCharacterMinimalPlusLookInformations(param1,param2,param3,param4);
         this.grade = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.grade = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterMinimalPlusLookAndGradeInformations(param1);
    }

    public void serializeAs_CharacterMinimalPlusLookAndGradeInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalPlusLookInformations(param1);
         if(this.grade < 0)
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalPlusLookAndGradeInformations(param1);
    }

    public void deserializeAs_CharacterMinimalPlusLookAndGradeInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._gradeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterMinimalPlusLookAndGradeInformations(param1);
    }

    public void deserializeAsyncAs_CharacterMinimalPlusLookAndGradeInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._gradeFunc);
    }

    private void _gradeFunc(ICustomDataInput param1) {
         this.grade = param1.readVarUhInt();
         if(this.grade < 0)
            throw new Exception("Forbidden value (" + this.grade + ") on element of CharacterMinimalPlusLookAndGradeInformations.grade.");
    }

}