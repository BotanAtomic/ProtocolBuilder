package com.ankamagames.dofus.network.types.game.context.roleplay.quest;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class QuestActiveInformations extends Object implements INetworkType {

  public int questId = 0;
  public static final int protocolId = 381;

  public void serialize(ICustomDataOutput param1) {
    if (this.questId < 0) {
      throw new Error("Forbidden value (" + this.questId + ") on element questId.");
    }
    param1.writeVarShort(this.questId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.questId = param1.readVarUhShort();
    if (this.questId < 0) {
      throw new Error(
          "Forbidden value (" + this.questId + ") on element of QuestActiveInformations.questId.");
    }
  }
}
