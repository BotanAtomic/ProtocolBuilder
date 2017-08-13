package package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class JobCrafterDirectoryEntryJobInfo extends Object implements INetworkType {

    private int protocolId = 195;
    private int jobId = 0;
    private int jobLevel = 0;
    private boolean free = false;
    private int minLevel = 0;


    public int getTypeId() {
         return 195;
    }

    public JobCrafterDirectoryEntryJobInfo initJobCrafterDirectoryEntryJobInfo(int param1,int  param2,boolean  param3,int  param4) {
         this.jobId = param1;
         this.jobLevel = param2;
         this.free = param3;
         this.minLevel = param4;
         return this;
    }

    public void reset() {
         this.jobId = 0;
         this.jobLevel = 0;
         this.free = false;
         this.minLevel = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_JobCrafterDirectoryEntryJobInfo(param1);
    }

    public void serializeAs_JobCrafterDirectoryEntryJobInfo(ICustomDataOutput param1) {
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectoryEntryJobInfo(param1);
    }

    public void deserializeAs_JobCrafterDirectoryEntryJobInfo(ICustomDataInput param1) {
         this._jobIdFunc(param1);
         this._jobLevelFunc(param1);
         this._freeFunc(param1);
         this._minLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectoryEntryJobInfo(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectoryEntryJobInfo(FuncTree param1) {
         param1.addChild(this._jobIdFunc);
         param1.addChild(this._jobLevelFunc);
         param1.addChild(this._freeFunc);
         param1.addChild(this._minLevelFunc);
    }

    private void _jobIdFunc(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element of JobCrafterDirectoryEntryJobInfo.jobId.");
    }

    private void _jobLevelFunc(ICustomDataInput param1) {
         this.jobLevel = param1.readUnsignedByte();
         if(this.jobLevel < 1 || this.jobLevel > 200)
            throw new Exception("Forbidden value (" + this.jobLevel + ") on element of JobCrafterDirectoryEntryJobInfo.jobLevel.");
    }

    private void _freeFunc(ICustomDataInput param1) {
         this.free = param1.readBoolean();
    }

    private void _minLevelFunc(ICustomDataInput param1) {
         this.minLevel = param1.readUnsignedByte();
         if(this.minLevel < 0 || this.minLevel > 255)
            throw new Exception("Forbidden value (" + this.minLevel + ") on element of JobCrafterDirectoryEntryJobInfo.minLevel.");
    }

}