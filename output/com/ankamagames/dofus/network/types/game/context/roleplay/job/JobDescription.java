package package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.interactive.skill.SkillActionDescription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class JobDescription extends Object implements INetworkType {

    private int protocolId = 101;
    private int jobId = 0;
    private Vector.<SkillActionDescription> skills = ;
    private FuncTree _skillstree = ;
    private int _loc2_ = 0;
    private SkillActionDescription _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private SkillActionDescription _loc3_ = ProtocolTypeManager.getInstance(SkillActionDescription,_loc2_);


    public int getTypeId() {
         return 101;
    }

    public JobDescription initJobDescription(int param1,Vector.<SkillActionDescription>  param2) {
         this.jobId = param1;
         this.skills = param2;
         return this;
    }

    public void reset() {
         this.jobId = 0;
         this.skills = new Vector.<SkillActionDescription>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_JobDescription(param1);
    }

    public void serializeAs_JobDescription(ICustomDataOutput param1) {
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobDescription(param1);
    }

    public void deserializeAs_JobDescription(ICustomDataInput param1) {
         int _loc4_ = 0;
         SkillActionDescription _loc5_ = null;
         this._jobIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(SkillActionDescription,_loc4_);
            _loc5_.deserialize(param1);
            this.skills.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobDescription(param1);
    }

    public void deserializeAsyncAs_JobDescription(FuncTree param1) {
         param1.addChild(this._jobIdFunc);
         this._skillstree = param1.addChild(this._skillstreeFunc);
    }

    private void _jobIdFunc(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
            throw new Exception("Forbidden value (" + this.jobId + ") on element of JobDescription.jobId.");
    }

    private void _skillstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._skillstree.addChild(this._skillsFunc);
            _loc3_++;
    }

    private void _skillsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         SkillActionDescription _loc3_ = ProtocolTypeManager.getInstance(SkillActionDescription,_loc2_);
         _loc3_.deserialize(param1);
         this.skills.push(_loc3_);
    }

}