package package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobExperience;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobExperienceMultiUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5809;
    private boolean _isInitialized = false;
    private Vector.<JobExperience> experiencesUpdate = ;
    private FuncTree _experiencesUpdatetree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5809;
    }

    public JobExperienceMultiUpdateMessage initJobExperienceMultiUpdateMessage(Vector.<JobExperience> param1) {
         this.experiencesUpdate = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.experiencesUpdate = new Vector.<JobExperience>();
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
         this.serializeAs_JobExperienceMultiUpdateMessage(param1);
    }

    public void serializeAs_JobExperienceMultiUpdateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.experiencesUpdate.length);
         int _loc2_ = 0;
         while(_loc2_ < this.experiencesUpdate.length)
            (this.experiencesUpdate[_loc2_] as JobExperience).serializeAs_JobExperience(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobExperienceMultiUpdateMessage(param1);
    }

    public void deserializeAs_JobExperienceMultiUpdateMessage(ICustomDataInput param1) {
         JobExperience _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new JobExperience();
            _loc4_.deserialize(param1);
            this.experiencesUpdate.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobExperienceMultiUpdateMessage(param1);
    }

    public void deserializeAsyncAs_JobExperienceMultiUpdateMessage(FuncTree param1) {
         this._experiencesUpdatetree = param1.addChild(this._experiencesUpdatetreeFunc);
    }

    private void _experiencesUpdatetreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._experiencesUpdatetree.addChild(this._experiencesUpdateFunc);
            _loc3_++;
    }

    private void _experiencesUpdateFunc(ICustomDataInput param1) {
         JobExperience _loc2_ = new JobExperience();
         _loc2_.deserialize(param1);
         this.experiencesUpdate.push(_loc2_);
    }

}