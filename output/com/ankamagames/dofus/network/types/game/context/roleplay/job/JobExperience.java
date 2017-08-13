package com.ankamagames.dofus.network.types.game.context.roleplay.job;

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
import java.lang.Exception;
import java.lang.Exception;

public class JobExperience extends Object implements INetworkType {

    private int protocolId = 98;
    private int jobId = 0;
    private int jobLevel = 0;
    private Number jobXP = 0;
    private Number jobXpLevelFloor = 0;
    private Number jobXpNextLevelFloor = 0;


    public int getTypeId() {
         return 98;
    }

    public JobExperience initJobExperience(int param1,int  param2,Number  param3,Number  param4,Number  param5) {
         this.jobId = param1;
         this.jobLevel = param2;
         this.jobXP = param3;
         this.jobXpLevelFloor = param4;
         this.jobXpNextLevelFloor = param5;
         return this;
    }

    public void reset() {
         this.jobId = 0;
         this.jobLevel = 0;
         this.jobXP = 0;
         this.jobXpLevelFloor = 0;
         this.jobXpNextLevelFloor = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_JobExperience(param1);
    }

    public void serializeAs_JobExperience(ICustomDataOutput param1) {
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
         }
         param1.writeByte(this.jobId);
         if(this.jobLevel < 0 || this.jobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.jobLevel + ") on element jobLevel.");
         }
         param1.writeByte(this.jobLevel);
         if(this.jobXP < 0 || this.jobXP > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jobXP + ") on element jobXP.");
         }
         param1.writeVarLong(this.jobXP);
         if(this.jobXpLevelFloor < 0 || this.jobXpLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jobXpLevelFloor + ") on element jobXpLevelFloor.");
         }
         param1.writeVarLong(this.jobXpLevelFloor);
         if(this.jobXpNextLevelFloor < 0 || this.jobXpNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jobXpNextLevelFloor + ") on element jobXpNextLevelFloor.");
         }
         param1.writeVarLong(this.jobXpNextLevelFloor);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobExperience(param1);
    }

    public void deserializeAs_JobExperience(ICustomDataInput param1) {
         this._jobIdFunc(param1);
         this._jobLevelFunc(param1);
         this._jobXPFunc(param1);
         this._jobXpLevelFloorFunc(param1);
         this._jobXpNextLevelFloorFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobExperience(param1);
    }

    public void deserializeAsyncAs_JobExperience(FuncTree param1) {
         param1.addChild(this._jobIdFunc);
         param1.addChild(this._jobLevelFunc);
         param1.addChild(this._jobXPFunc);
         param1.addChild(this._jobXpLevelFloorFunc);
         param1.addChild(this._jobXpNextLevelFloorFunc);
    }

    private void _jobIdFunc(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element of JobExperience.jobId.");
         }
    }

    private void _jobLevelFunc(ICustomDataInput param1) {
         this.jobLevel = param1.readUnsignedByte();
         if(this.jobLevel < 0 || this.jobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.jobLevel + ") on element of JobExperience.jobLevel.");
         }
    }

    private void _jobXPFunc(ICustomDataInput param1) {
         this.jobXP = param1.readVarUhLong();
         if(this.jobXP < 0 || this.jobXP > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jobXP + ") on element of JobExperience.jobXP.");
         }
    }

    private void _jobXpLevelFloorFunc(ICustomDataInput param1) {
         this.jobXpLevelFloor = param1.readVarUhLong();
         if(this.jobXpLevelFloor < 0 || this.jobXpLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jobXpLevelFloor + ") on element of JobExperience.jobXpLevelFloor.");
         }
    }

    private void _jobXpNextLevelFloorFunc(ICustomDataInput param1) {
         this.jobXpNextLevelFloor = param1.readVarUhLong();
         if(this.jobXpNextLevelFloor < 0 || this.jobXpNextLevelFloor > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.jobXpNextLevelFloor + ") on element of JobExperience.jobXpNextLevelFloor.");
         }
    }

}