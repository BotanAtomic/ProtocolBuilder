package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobCrafterDirectorySettings;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectorySettingsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<JobCrafterDirectorySettings> craftersSettings;
  private FuncTree _craftersSettingstree;
  public static final int protocolId = 5652;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.craftersSettings.length);
    int _loc2_ = 0;
    while (_loc2_ < this.craftersSettings.length) {
      ((JobCrafterDirectorySettings) this.craftersSettings[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    JobCrafterDirectorySettings _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new JobCrafterDirectorySettings();
      _loc4_.deserialize(param1);
      this.craftersSettings.push(_loc4_);
      _loc3_++;
    }
  }
}
