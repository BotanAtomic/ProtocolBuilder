package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryEntryPlayerInfo;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryEntryJobInfo;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryEntryMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6044;
    private boolean _isInitialized = false;
    private JobCrafterDirectoryEntryPlayerInfo playerInfo;
    private Vector<JobCrafterDirectoryEntryJobInfo> jobInfoList;
    private EntityLook playerLook;
    private FuncTree _playerInfotree;
    private FuncTree _jobInfoListtree;
    private FuncTree _playerLooktree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6044;
    }

    public JobCrafterDirectoryEntryMessage initJobCrafterDirectoryEntryMessage(JobCrafterDirectoryEntryPlayerInfo param1,Vector<JobCrafterDirectoryEntryJobInfo>  param2,EntityLook  param3) {
         this.playerInfo = param1;
         this.jobInfoList = param2;
         this.playerLook = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
         this.playerLook = new EntityLook();
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
         this.serializeAs_JobCrafterDirectoryEntryMessage(param1);
    }

    public void serializeAs_JobCrafterDirectoryEntryMessage(ICustomDataOutput param1) {
         this.playerInfo.serializeAs_JobCrafterDirectoryEntryPlayerInfo(param1);
         param1.writeShort(this.jobInfoList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.jobInfoList.length)
         {
            (this.jobInfoList[_loc2_] as JobCrafterDirectoryEntryJobInfo).serializeAs_JobCrafterDirectoryEntryJobInfo(param1);
            _loc2_++;
         }
         this.playerLook.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectoryEntryMessage(param1);
    }

    public void deserializeAs_JobCrafterDirectoryEntryMessage(ICustomDataInput param1) {
         JobCrafterDirectoryEntryJobInfo _loc4_ = null;
         this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
         this.playerInfo.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new JobCrafterDirectoryEntryJobInfo();
            _loc4_.deserialize(param1);
            this.jobInfoList.push(_loc4_);
            _loc3_++;
         }
         this.playerLook = new EntityLook();
         this.playerLook.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectoryEntryMessage(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectoryEntryMessage(FuncTree param1) {
         this._playerInfotree = param1.addChild(this._playerInfotreeFunc);
         this._jobInfoListtree = param1.addChild(this._jobInfoListtreeFunc);
         this._playerLooktree = param1.addChild(this._playerLooktreeFunc);
    }

    private void _playerInfotreeFunc(ICustomDataInput param1) {
         this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
         this.playerInfo.deserializeAsync(this._playerInfotree);
    }

    private void _jobInfoListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._jobInfoListtree.addChild(this._jobInfoListFunc);
            _loc3_++;
         }
    }

    private void _jobInfoListFunc(ICustomDataInput param1) {
         JobCrafterDirectoryEntryJobInfo _loc2_ = new JobCrafterDirectoryEntryJobInfo();
         _loc2_.deserialize(param1);
         this.jobInfoList.push(_loc2_);
    }

    private void _playerLooktreeFunc(ICustomDataInput param1) {
         this.playerLook = new EntityLook();
         this.playerLook.deserializeAsync(this._playerLooktree);
    }

}