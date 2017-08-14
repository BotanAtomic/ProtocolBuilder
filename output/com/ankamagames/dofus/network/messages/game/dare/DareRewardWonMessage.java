package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareReward;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareRewardWonMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public DareReward reward;
  private FuncTree _rewardtree;
  public static final int protocolId = 6678;

  public void serialize(ICustomDataOutput param1) {
    this.reward.serializeAs_DareReward(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.reward = new DareReward();
    this.reward.deserialize(param1);
  }
}
