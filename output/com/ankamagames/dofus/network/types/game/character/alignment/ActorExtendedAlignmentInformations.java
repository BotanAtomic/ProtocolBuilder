package com.ankamagames.dofus.network.types.game.character.alignment;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ActorExtendedAlignmentInformations extends ActorAlignmentInformations implements INetworkType {

    private int protocolId = 202;
    private int honor = 0;
    private int honorGradeFloor = 0;
    private int honorNextGradeFloor = 0;
    private int aggressable = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ActorAlignmentInformations(param1);
         if(this.honor < 0 || this.honor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honor + ") on element honor.");
         }
         param1.writeVarShort(this.honor);
         if(this.honorGradeFloor < 0 || this.honorGradeFloor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honorGradeFloor + ") on element honorGradeFloor.");
         }
         param1.writeVarShort(this.honorGradeFloor);
         if(this.honorNextGradeFloor < 0 || this.honorNextGradeFloor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honorNextGradeFloor + ") on element honorNextGradeFloor.");
         }
         param1.writeVarShort(this.honorNextGradeFloor);
         param1.writeByte(this.aggressable);
    }

    public void deserialize(ICustomDataInput param1) {
         this.alignmentSide = param1.readByte();
         this.alignmentValue = param1.readByte();
         if(this.alignmentValue < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentValue + ") on element of ActorAlignmentInformations.alignmentValue.");
         }
         this.alignmentGrade = param1.readByte();
         if(this.alignmentGrade < 0)
         {
            throw new Exception("Forbidden value (" + this.alignmentGrade + ") on element of ActorAlignmentInformations.alignmentGrade.");
         }
         this.characterPower = param1.readDouble();
         if(this.characterPower < -9.007199254740992E15 || this.characterPower > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterPower + ") on element of ActorAlignmentInformations.characterPower.");
         }
         this.honor = param1.readVarUhShort();
         if(this.honor < 0 || this.honor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honor + ") on element of ActorExtendedAlignmentInformations.honor.");
         }
         this.honorGradeFloor = param1.readVarUhShort();
         if(this.honorGradeFloor < 0 || this.honorGradeFloor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honorGradeFloor + ") on element of ActorExtendedAlignmentInformations.honorGradeFloor.");
         }
         this.honorNextGradeFloor = param1.readVarUhShort();
         if(this.honorNextGradeFloor < 0 || this.honorNextGradeFloor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honorNextGradeFloor + ") on element of ActorExtendedAlignmentInformations.honorNextGradeFloor.");
         }
         this.aggressable = param1.readByte();
         if(this.aggressable < 0)
         {
            throw new Exception("Forbidden value (" + this.aggressable + ") on element of ActorExtendedAlignmentInformations.aggressable.");
         }
    }

}