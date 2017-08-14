package com.ankamagames.dofus.network.types.game.interactive.skill;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SkillActionDescription extends Object implements INetworkType {

  public int skillId = 0;
  public static final int protocolId = 102;

  public void serialize(ICustomDataOutput param1) {
    if (this.skillId < 0) {
      throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarShort(this.skillId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.skillId = param1.readVarUhShort();
    if (this.skillId < 0) {
      throw new Exception(
          "Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
    }
  }
}
