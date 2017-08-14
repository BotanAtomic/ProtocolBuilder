package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChallengeTargetUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int challengeId = 0;
  public Number targetId = 0;
  public static final int protocolId = 6123;

  public void serialize(ICustomDataOutput param1) {
    if (this.challengeId < 0) {
      throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
    }
    param1.writeVarShort(this.challengeId);
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.challengeId = param1.readVarUhShort();
    if (this.challengeId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.challengeId
              + ") on element of ChallengeTargetUpdateMessage.challengeId.");
    }

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }
  }
}
