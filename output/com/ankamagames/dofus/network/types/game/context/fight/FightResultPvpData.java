package com.ankamagames.dofus.network.types.game.context.fight;

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
import java.lang.Exception;

public class FightResultPvpData extends FightResultAdditionalData implements INetworkType {

    private int protocolId = 190;
    private int grade = 0;
    private int minHonorForGrade = 0;
    private int maxHonorForGrade = 0;
    private int honor = 0;
    private int honorDelta = 0;


    public int getTypeId() {
         return 190;
    }

    public FightResultPvpData initFightResultPvpData(int param1,int  param2,int  param3,int  param4,int  param5) {
         this.grade = param1;
         this.minHonorForGrade = param2;
         this.maxHonorForGrade = param3;
         this.honor = param4;
         this.honorDelta = param5;
         return this;
    }

    public void reset() {
         this.grade = 0;
         this.minHonorForGrade = 0;
         this.maxHonorForGrade = 0;
         this.honor = 0;
         this.honorDelta = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightResultPvpData(param1);
    }

    public void serializeAs_FightResultPvpData(ICustomDataOutput param1) {
         super.serializeAs_FightResultAdditionalData(param1);
         if(this.grade < 0 || this.grade > 255)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
         }
         param1.writeByte(this.grade);
         if(this.minHonorForGrade < 0 || this.minHonorForGrade > 20000)
         {
            throw new Exception("Forbidden value (" + this.minHonorForGrade + ") on element minHonorForGrade.");
         }
         param1.writeVarShort(this.minHonorForGrade);
         if(this.maxHonorForGrade < 0 || this.maxHonorForGrade > 20000)
         {
            throw new Exception("Forbidden value (" + this.maxHonorForGrade + ") on element maxHonorForGrade.");
         }
         param1.writeVarShort(this.maxHonorForGrade);
         if(this.honor < 0 || this.honor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honor + ") on element honor.");
         }
         param1.writeVarShort(this.honor);
         param1.writeVarShort(this.honorDelta);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultPvpData(param1);
    }

    public void deserializeAs_FightResultPvpData(ICustomDataInput param1) {
         super.deserialize(param1);
         this._gradeFunc(param1);
         this._minHonorForGradeFunc(param1);
         this._maxHonorForGradeFunc(param1);
         this._honorFunc(param1);
         this._honorDeltaFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightResultPvpData(param1);
    }

    public void deserializeAsyncAs_FightResultPvpData(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._gradeFunc);
         param1.addChild(this._minHonorForGradeFunc);
         param1.addChild(this._maxHonorForGradeFunc);
         param1.addChild(this._honorFunc);
         param1.addChild(this._honorDeltaFunc);
    }

    private void _gradeFunc(ICustomDataInput param1) {
         this.grade = param1.readUnsignedByte();
         if(this.grade < 0 || this.grade > 255)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element of FightResultPvpData.grade.");
         }
    }

    private void _minHonorForGradeFunc(ICustomDataInput param1) {
         this.minHonorForGrade = param1.readVarUhShort();
         if(this.minHonorForGrade < 0 || this.minHonorForGrade > 20000)
         {
            throw new Exception("Forbidden value (" + this.minHonorForGrade + ") on element of FightResultPvpData.minHonorForGrade.");
         }
    }

    private void _maxHonorForGradeFunc(ICustomDataInput param1) {
         this.maxHonorForGrade = param1.readVarUhShort();
         if(this.maxHonorForGrade < 0 || this.maxHonorForGrade > 20000)
         {
            throw new Exception("Forbidden value (" + this.maxHonorForGrade + ") on element of FightResultPvpData.maxHonorForGrade.");
         }
    }

    private void _honorFunc(ICustomDataInput param1) {
         this.honor = param1.readVarUhShort();
         if(this.honor < 0 || this.honor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honor + ") on element of FightResultPvpData.honor.");
         }
    }

    private void _honorDeltaFunc(ICustomDataInput param1) {
         this.honorDelta = param1.readVarShort();
    }

}