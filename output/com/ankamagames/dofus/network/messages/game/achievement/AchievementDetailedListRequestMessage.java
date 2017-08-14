package com.ankamagames.dofus.network.messages.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementDetailedListRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int categoryId = 0;
  public static final int protocolId = 6357;

  public void serialize(ICustomDataOutput param1) {
    if (this.categoryId < 0) {
      throw new Error("Forbidden value (" + this.categoryId + ") on element categoryId.");
    }
    param1.writeVarShort(this.categoryId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.categoryId = param1.readVarUhShort();
    if (this.categoryId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.categoryId
              + ") on element of AchievementDetailedListRequestMessage.categoryId.");
    }
  }
}
