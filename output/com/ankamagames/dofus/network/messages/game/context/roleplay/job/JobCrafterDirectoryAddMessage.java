package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryListEntry;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryAddMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public JobCrafterDirectoryListEntry listEntry;
  private FuncTree _listEntrytree;
  public static final int protocolId = 5651;

  public void serialize(ICustomDataOutput param1) {
    this.listEntry.serializeAs_JobCrafterDirectoryListEntry(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.listEntry = new JobCrafterDirectoryListEntry();
    this.listEntry.deserialize(param1);
  }
}
