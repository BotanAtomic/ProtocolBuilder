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
import java.lang.Exception;

public class ActorExtendedAlignmentInformations extends ActorAlignmentInformations implements INetworkType {

    private int protocolId = 202;
    private int honor = 0;
    private int honorGradeFloor = 0;
    private int honorNextGradeFloor = 0;
    private int aggressable = 0;


    public int getTypeId() {
         return 202;
    }

    public ActorExtendedAlignmentInformations initActorExtendedAlignmentInformations(int param1,int  param2,int  param3,Number  param4,int  param5,int  param6,int  param7,int  param8) {
         super.initActorAlignmentInformations(param1,param2,param3,param4);
         this.honor = param5;
         this.honorGradeFloor = param6;
         this.honorNextGradeFloor = param7;
         this.aggressable = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.honor = 0;
         this.honorGradeFloor = 0;
         this.honorNextGradeFloor = 0;
         this.aggressable = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ActorExtendedAlignmentInformations(param1);
    }

    public void serializeAs_ActorExtendedAlignmentInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_ActorExtendedAlignmentInformations(param1);
    }

    public void deserializeAs_ActorExtendedAlignmentInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._honorFunc(param1);
         this._honorGradeFloorFunc(param1);
         this._honorNextGradeFloorFunc(param1);
         this._aggressableFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ActorExtendedAlignmentInformations(param1);
    }

    public void deserializeAsyncAs_ActorExtendedAlignmentInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._honorFunc);
         param1.addChild(this._honorGradeFloorFunc);
         param1.addChild(this._honorNextGradeFloorFunc);
         param1.addChild(this._aggressableFunc);
    }

    private void _honorFunc(ICustomDataInput param1) {
         this.honor = param1.readVarUhShort();
         if(this.honor < 0 || this.honor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honor + ") on element of ActorExtendedAlignmentInformations.honor.");
         }
    }

    private void _honorGradeFloorFunc(ICustomDataInput param1) {
         this.honorGradeFloor = param1.readVarUhShort();
         if(this.honorGradeFloor < 0 || this.honorGradeFloor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honorGradeFloor + ") on element of ActorExtendedAlignmentInformations.honorGradeFloor.");
         }
    }

    private void _honorNextGradeFloorFunc(ICustomDataInput param1) {
         this.honorNextGradeFloor = param1.readVarUhShort();
         if(this.honorNextGradeFloor < 0 || this.honorNextGradeFloor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honorNextGradeFloor + ") on element of ActorExtendedAlignmentInformations.honorNextGradeFloor.");
         }
    }

    private void _aggressableFunc(ICustomDataInput param1) {
         this.aggressable = param1.readByte();
         if(this.aggressable < 0)
         {
            throw new Exception("Forbidden value (" + this.aggressable + ") on element of ActorExtendedAlignmentInformations.aggressable.");
         }
    }

}