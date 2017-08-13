package package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobDescription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobDescriptionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5655;
    private boolean _isInitialized = false;
    private Vector.<JobDescription> jobsDescription = ;
    private FuncTree _jobsDescriptiontree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5655;
    }

    public JobDescriptionMessage initJobDescriptionMessage(Vector.<JobDescription> param1) {
         this.jobsDescription = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.jobsDescription = new Vector.<JobDescription>();
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
         this.serializeAs_JobDescriptionMessage(param1);
    }

    public void serializeAs_JobDescriptionMessage(ICustomDataOutput param1) {
         param1.writeShort(this.jobsDescription.length);
         int _loc2_ = 0;
         while(_loc2_ < this.jobsDescription.length)
            (this.jobsDescription[_loc2_] as JobDescription).serializeAs_JobDescription(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobDescriptionMessage(param1);
    }

    public void deserializeAs_JobDescriptionMessage(ICustomDataInput param1) {
         JobDescription _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new JobDescription();
            _loc4_.deserialize(param1);
            this.jobsDescription.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobDescriptionMessage(param1);
    }

    public void deserializeAsyncAs_JobDescriptionMessage(FuncTree param1) {
         this._jobsDescriptiontree = param1.addChild(this._jobsDescriptiontreeFunc);
    }

    private void _jobsDescriptiontreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._jobsDescriptiontree.addChild(this._jobsDescriptionFunc);
            _loc3_++;
    }

    private void _jobsDescriptionFunc(ICustomDataInput param1) {
         JobDescription _loc2_ = new JobDescription();
         _loc2_.deserialize(param1);
         this.jobsDescription.push(_loc2_);
    }

}