package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class JobCrafterDirectorySettings extends Object implements INetworkType {

    private int protocolId = 97;
    private int jobId = 0;
    private int minLevel = 0;
    private boolean free = false;


    public int getTypeId() {
         return 97;
    }

    public JobCrafterDirectorySettings initJobCrafterDirectorySettings(int param1,int  param2,boolean  param3) {
         this.jobId = param1;
         this.minLevel = param2;
         this.free = param3;
         return this;
    }

    public void reset() {
         this.jobId = 0;
         this.minLevel = 0;
         this.free = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_JobCrafterDirectorySettings(param1);
    }

    public void serializeAs_JobCrafterDirectorySettings(ICustomDataOutput param1) {
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
         }
         param1.writeByte(this.jobId);
         if(this.minLevel < 0 || this.minLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.minLevel + ") on element minLevel.");
         }
         param1.writeByte(this.minLevel);
         param1.writeBoolean(this.free);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectorySettings(param1);
    }

    public void deserializeAs_JobCrafterDirectorySettings(ICustomDataInput param1) {
         this._jobIdFunc(param1);
         this._minLevelFunc(param1);
         this._freeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectorySettings(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectorySettings(FuncTree param1) {
         param1.addChild(this._jobIdFunc);
         param1.addChild(this._minLevelFunc);
         param1.addChild(this._freeFunc);
    }

    private void _jobIdFunc(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element of JobCrafterDirectorySettings.jobId.");
         }
    }

    private void _minLevelFunc(ICustomDataInput param1) {
         this.minLevel = param1.readUnsignedByte();
         if(this.minLevel < 0 || this.minLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.minLevel + ") on element of JobCrafterDirectorySettings.minLevel.");
         }
    }

    private void _freeFunc(ICustomDataInput param1) {
         this.free = param1.readBoolean();
    }

}