package package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryListEntry extends Object implements INetworkType {

    private int protocolId = 196;
    private JobCrafterDirectoryEntryPlayerInfo playerInfo = ;
    private JobCrafterDirectoryEntryJobInfo jobInfo = ;
    private FuncTree _playerInfotree = ;
    private FuncTree _jobInfotree = ;


    public int getTypeId() {
         return 196;
    }

    public JobCrafterDirectoryListEntry initJobCrafterDirectoryListEntry(JobCrafterDirectoryEntryPlayerInfo param1,JobCrafterDirectoryEntryJobInfo  param2) {
         this.playerInfo = param1;
         this.jobInfo = param2;
         return this;
    }

    public void reset() {
         this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_JobCrafterDirectoryListEntry(param1);
    }

    public void serializeAs_JobCrafterDirectoryListEntry(ICustomDataOutput param1) {
         this.playerInfo.serializeAs_JobCrafterDirectoryEntryPlayerInfo(param1);
         this.jobInfo.serializeAs_JobCrafterDirectoryEntryJobInfo(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_JobCrafterDirectoryListEntry(param1);
    }

    public void deserializeAs_JobCrafterDirectoryListEntry(ICustomDataInput param1) {
         this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
         this.playerInfo.deserialize(param1);
         this.jobInfo = new JobCrafterDirectoryEntryJobInfo();
         this.jobInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_JobCrafterDirectoryListEntry(param1);
    }

    public void deserializeAsyncAs_JobCrafterDirectoryListEntry(FuncTree param1) {
         this._playerInfotree = param1.addChild(this._playerInfotreeFunc);
         this._jobInfotree = param1.addChild(this._jobInfotreeFunc);
    }

    private void _playerInfotreeFunc(ICustomDataInput param1) {
         this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
         this.playerInfo.deserializeAsync(this._playerInfotree);
    }

    private void _jobInfotreeFunc(ICustomDataInput param1) {
         this.jobInfo = new JobCrafterDirectoryEntryJobInfo();
         this.jobInfo.deserializeAsync(this._jobInfotree);
    }

}