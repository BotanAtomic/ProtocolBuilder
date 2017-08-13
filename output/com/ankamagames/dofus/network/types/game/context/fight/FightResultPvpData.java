package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightResultPvpData extends FightResultAdditionalData implements INetworkType {

    private int protocolId = 190;
    private int grade = 0;
    private int minHonorForGrade = 0;
    private int maxHonorForGrade = 0;
    private int honor = 0;
    private int honorDelta = 0;


    public void serialize(ICustomDataOutput param1) {
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
         this.grade = param1.readUnsignedByte();
         if(this.grade < 0 || this.grade > 255)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element of FightResultPvpData.grade.");
         }
         this.minHonorForGrade = param1.readVarUhShort();
         if(this.minHonorForGrade < 0 || this.minHonorForGrade > 20000)
         {
            throw new Exception("Forbidden value (" + this.minHonorForGrade + ") on element of FightResultPvpData.minHonorForGrade.");
         }
         this.maxHonorForGrade = param1.readVarUhShort();
         if(this.maxHonorForGrade < 0 || this.maxHonorForGrade > 20000)
         {
            throw new Exception("Forbidden value (" + this.maxHonorForGrade + ") on element of FightResultPvpData.maxHonorForGrade.");
         }
         this.honor = param1.readVarUhShort();
         if(this.honor < 0 || this.honor > 20000)
         {
            throw new Exception("Forbidden value (" + this.honor + ") on element of FightResultPvpData.honor.");
         }
         this.honorDelta = param1.readVarShort();
    }

}