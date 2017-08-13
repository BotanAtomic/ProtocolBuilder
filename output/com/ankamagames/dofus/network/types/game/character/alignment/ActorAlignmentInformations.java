package com.ankamagames.dofus.network.types.game.character.alignment;

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

public class ActorAlignmentInformations extends Object implements INetworkType {

    private int protocolId = 201;
    private int alignmentSide = 0;
    private int alignmentValue = 0;
    private int alignmentGrade = 0;
    private Number characterPower = 0;


    public int getTypeId() {
         return 201;
    }

    public ActorAlignmentInformations initActorAlignmentInformations(int param1,int  param2,int  param3,Number  param4) {
         this.alignmentSide = param1;
         this.alignmentValue = param2;
         this.alignmentGrade = param3;
         this.characterPower = param4;
         return this;
    }

    public void reset() {
         this.alignmentSide = 0;
         this.alignmentValue = 0;
         this.alignmentGrade = 0;
         this.characterPower = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ActorAlignmentInformations(param1);
    }

    public void serializeAs_ActorAlignmentInformations(ICustomDataOutput param1) {
         param1.writeByte(this.alignmentSide);
         if(this.alignmentValue < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentValue + ") on element alignmentValue.");
         }
         param1.writeByte(this.alignmentValue);
         if(this.alignmentGrade < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentGrade + ") on element alignmentGrade.");
         }
         param1.writeByte(this.alignmentGrade);
         if(this.characterPower < -9.007199254740992E15 || this.characterPower > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterPower + ") on element characterPower.");
         }
         param1.writeDouble(this.characterPower);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ActorAlignmentInformations(param1);
    }

    public void deserializeAs_ActorAlignmentInformations(ICustomDataInput param1) {
         this._alignmentSideFunc(param1);
         this._alignmentValueFunc(param1);
         this._alignmentGradeFunc(param1);
         this._characterPowerFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ActorAlignmentInformations(param1);
    }

    public void deserializeAsyncAs_ActorAlignmentInformations(FuncTree param1) {
         param1.addChild(this._alignmentSideFunc);
         param1.addChild(this._alignmentValueFunc);
         param1.addChild(this._alignmentGradeFunc);
         param1.addChild(this._characterPowerFunc);
    }

    private void _alignmentSideFunc(ICustomDataInput param1) {
         this.alignmentSide = param1.readByte();
    }

    private void _alignmentValueFunc(ICustomDataInput param1) {
         this.alignmentValue = param1.readByte();
         if(this.alignmentValue < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentValue + ") on element of ActorAlignmentInformations.alignmentValue.");
         }
    }

    private void _alignmentGradeFunc(ICustomDataInput param1) {
         this.alignmentGrade = param1.readByte();
         if(this.alignmentGrade < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentGrade + ") on element of ActorAlignmentInformations.alignmentGrade.");
         }
    }

    private void _characterPowerFunc(ICustomDataInput param1) {
         this.characterPower = param1.readDouble();
         if(this.characterPower < -9.007199254740992E15 || this.characterPower > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterPower + ") on element of ActorAlignmentInformations.characterPower.");
         }
    }

}