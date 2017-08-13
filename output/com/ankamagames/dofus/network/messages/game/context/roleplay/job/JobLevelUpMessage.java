package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobDescription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class JobLevelUpMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5656;
    private boolean _isInitialized = false;
    private int newLevel = 0;
    private JobDescription jobsDescription;
    private FuncTree _jobsDescriptiontree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5656;
    }

    public JobLevelUpMessage initJobLevelUpMessage(int param1,JobDescription  param2) {
         this.newLevel = param1;
         this.jobsDescription = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.newLevel = 0;
         this.jobsDescription = new JobDescription();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_JobLevelUpMessage(param1);
    }

    public void serializeAs_JobLevelUpMessage(ICustomDataOutput param1) {
         if(this.newLevel < 0 || this.newLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.newLevel + ") on element newLevel.");
         }
         param1.writeByte(this.newLevel);
         this.jobsDescription.serializeAs_JobDescription(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobLevelUpMessage(param1);
    }

    public void deserializeAs_JobLevelUpMessage(ICustomDataInput param1) {
         this._newLevelFunc(param1);
         this.jobsDescription = new JobDescription();
         this.jobsDescription.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobLevelUpMessage(param1);
    }

    public void deserializeAsyncAs_JobLevelUpMessage(FuncTree param1) {
         param1.addChild(this._newLevelFunc);
         this._jobsDescriptiontree = param1.addChild(this._jobsDescriptiontreeFunc);
    }

    private void _newLevelFunc(ICustomDataInput param1) {
         this.newLevel = param1.readUnsignedByte();
         if(this.newLevel < 0 || this.newLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.newLevel + ") on element of JobLevelUpMessage.newLevel.");
         }
    }

    private void _jobsDescriptiontreeFunc(ICustomDataInput param1) {
         this.jobsDescription = new JobDescription();
         this.jobsDescription.deserializeAsync(this._jobsDescriptiontree);
    }

}