package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobExperience;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobExperienceMultiUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<JobExperience> experiencesUpdate;
  private FuncTree _experiencesUpdatetree;
  public static final int protocolId = 5809;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.experiencesUpdate.length);
    int _loc2_ = 0;
    while (_loc2_ < this.experiencesUpdate.length) {
      ((JobExperience) this.experiencesUpdate[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    JobExperience _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new JobExperience();
      _loc4_.deserialize(param1);
      this.experiencesUpdate.push(_loc4_);
      _loc3_++;
    }
  }
}
