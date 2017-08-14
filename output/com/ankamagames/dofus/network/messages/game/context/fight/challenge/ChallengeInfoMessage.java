package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChallengeInfoMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int challengeId = 0;
  public Number targetId = 0;
  public int xpBonus = 0;
  public int dropBonus = 0;
  public static final int protocolId = 6022;

  public void serialize(ICustomDataOutput param1) {
    if (this.challengeId < 0) {
      throw new Error("Forbidden value (" + this.challengeId + ") on element challengeId.");
    }
    param1.writeVarShort(this.challengeId);
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
    if (this.xpBonus < 0) {
      throw new Error("Forbidden value (" + this.xpBonus + ") on element xpBonus.");
    }
    param1.writeVarInt(this.xpBonus);
    if (this.dropBonus < 0) {
      throw new Error("Forbidden value (" + this.dropBonus + ") on element dropBonus.");
    }
    param1.writeVarInt(this.dropBonus);
  }

  public void deserialize(ICustomDataInput param1) {
    this.challengeId = param1.readVarUhShort();
    if (this.challengeId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.challengeId
              + ") on element of ChallengeTargetUpdateMessage.challengeId.");
    }

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    this.xpBonus = param1.readVarUhInt();
    if (this.xpBonus < 0) {
      throw new Error(
          "Forbidden value (" + this.xpBonus + ") on element of ChallengeInfoMessage.xpBonus.");
    }

    this.dropBonus = param1.readVarUhInt();
    if (this.dropBonus < 0) {
      throw new Error(
          "Forbidden value (" + this.dropBonus + ") on element of ChallengeInfoMessage.dropBonus.");
    }
  }
}
