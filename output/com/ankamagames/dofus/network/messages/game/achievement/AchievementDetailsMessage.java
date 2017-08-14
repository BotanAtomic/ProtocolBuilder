package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.achievement.Achievement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementDetailsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Achievement achievement;
  private FuncTree _achievementtree;
  public static final int protocolId = 6378;

  public void serialize(ICustomDataOutput param1) {
    this.achievement.serializeAs_Achievement(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.achievement = new Achievement();
    this.achievement.deserialize(param1);
  }
}
