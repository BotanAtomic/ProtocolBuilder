package com.ankamagames.dofus.network.types.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveElementSkill extends Object implements INetworkType {

  public int skillId = 0;
  public int skillInstanceUid = 0;
  public static final int protocolId = 219;

  public void serialize(ICustomDataOutput param1) {
    if (this.skillId < 0) {
      throw new Error("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarInt(this.skillId);
    if (this.skillInstanceUid < 0) {
      throw new Error(
          "Forbidden value (" + this.skillInstanceUid + ") on element skillInstanceUid.");
    }
    param1.writeInt(this.skillInstanceUid);
  }

  public void deserialize(ICustomDataInput param1) {
    this.skillId = param1.readVarUhShort();
    if (this.skillId < 0) {
      throw new Error(
          "Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
    }

    this.skillInstanceUid = param1.readInt();
    if (this.skillInstanceUid < 0) {
      throw new Error(
          "Forbidden value ("
              + this.skillInstanceUid
              + ") on element of InteractiveElementSkill.skillInstanceUid.");
    }
  }
}
