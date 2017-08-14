package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementRewardSuccessMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int achievementId = 0;
  public static final int protocolId = 6376;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.achievementId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.achievementId = param1.readShort();
  }
}
