package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectoryListEntry;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectoryListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<JobCrafterDirectoryListEntry> listEntries;
  private FuncTree _listEntriestree;
  public static final int protocolId = 6046;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.listEntries.length);
    int _loc2_ = 0;
    while (_loc2_ < this.listEntries.length) {
      ((JobCrafterDirectoryListEntry) this.listEntries[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    JobCrafterDirectoryListEntry _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new JobCrafterDirectoryListEntry();
      _loc4_.deserialize(param1);
      this.listEntries.push(_loc4_);
      _loc3_++;
    }
  }
}
