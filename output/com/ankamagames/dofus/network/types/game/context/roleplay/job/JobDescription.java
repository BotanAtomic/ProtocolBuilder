package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.interactive.skill.SkillActionDescription;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobDescription extends Object implements INetworkType {

  public int jobId = 0;
  public Vector<SkillActionDescription> skills;
  private FuncTree _skillstree;
  public static final int protocolId = 101;

  public void serialize(ICustomDataOutput param1) {
    if (this.jobId < 0) {
      throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }
    param1.writeByte(this.jobId);
    param1.writeShort(this.skills.length);
    int _loc2_ = 0;
    while (_loc2_ < this.skills.length) {
      param1.writeShort(((SkillActionDescription) (this.skills[_loc2_])).getTypeId());
      ((SkillActionDescription) this.skills[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    SkillActionDescription _loc5_ = null;
    this.jobId = param1.readByte();
    if (this.jobId < 0) {
      throw new Exception(
          "Forbidden value (" + this.jobId + ") on element of JobExperience.jobId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(SkillActionDescription, _loc4_);
      _loc5_.deserialize(param1);
      this.skills.push(_loc5_);
      _loc3_++;
    }
  }
}
