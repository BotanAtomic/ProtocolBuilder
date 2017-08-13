package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobExperience;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobExperienceUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5654;
    private boolean _isInitialized = false;
    private JobExperience experiencesUpdate;
    private FuncTree _experiencesUpdatetree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5654;
    }

    public JobExperienceUpdateMessage initJobExperienceUpdateMessage(JobExperience param1) {
         this.experiencesUpdate = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.experiencesUpdate = new JobExperience();
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
         this.serializeAs_JobExperienceUpdateMessage(param1);
    }

    public void serializeAs_JobExperienceUpdateMessage(ICustomDataOutput param1) {
         this.experiencesUpdate.serializeAs_JobExperience(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobExperienceUpdateMessage(param1);
    }

    public void deserializeAs_JobExperienceUpdateMessage(ICustomDataInput param1) {
         this.experiencesUpdate = new JobExperience();
         this.experiencesUpdate.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobExperienceUpdateMessage(param1);
    }

    public void deserializeAsyncAs_JobExperienceUpdateMessage(FuncTree param1) {
         this._experiencesUpdatetree = param1.addChild(this._experiencesUpdatetreeFunc);
    }

    private void _experiencesUpdatetreeFunc(ICustomDataInput param1) {
         this.experiencesUpdate = new JobExperience();
         this.experiencesUpdate.deserializeAsync(this._experiencesUpdatetree);
    }

}