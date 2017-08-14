package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class QuestStartRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int questId = 0;
  public static final int protocolId = 5643;

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
