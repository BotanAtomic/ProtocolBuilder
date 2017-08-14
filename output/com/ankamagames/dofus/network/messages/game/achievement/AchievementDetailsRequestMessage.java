package com.ankamagames.dofus.network.messages.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementDetailsRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int achievementId = 0;
  public static final int protocolId = 6380;

  public void serialize(ICustomDataOutput param1) {
    if (this.achievementId < 0) {
      throw new Exception("Forbidden value (" + this.achievementId + ") on element achievementId.");
    }
    param1.writeVarShort(this.achievementId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.achievementId = param1.readShort();
  }
}
