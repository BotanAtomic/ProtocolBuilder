package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryListEntry extends Object implements INetworkType {

  public JobCrafterDirectoryEntryPlayerInfo playerInfo;
  public JobCrafterDirectoryEntryJobInfo jobInfo;
  private FuncTree _playerInfotree;
  private FuncTree _jobInfotree;
  public static final int protocolId = 196;

  public void serialize(ICustomDataOutput param1) {
    this.playerInfo.serializeAs_JobCrafterDirectoryEntryPlayerInfo(param1);
    this.jobInfo.serializeAs_JobCrafterDirectoryEntryJobInfo(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
    this.playerInfo.deserialize(param1);
    this.jobInfo = new JobCrafterDirectoryEntryJobInfo();
    this.jobInfo.deserialize(param1);
  }
}
