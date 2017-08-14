package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightStartingMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightType = 0;
  public Number attackerId = 0;
  public Number defenderId = 0;
  public static final int protocolId = 700;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.fightType);
    if (this.attackerId < -9.007199254740992E15 || this.attackerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.attackerId + ") on element attackerId.");
    }
    param1.writeDouble(this.attackerId);
    if (this.defenderId < -9.007199254740992E15 || this.defenderId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.defenderId + ") on element defenderId.");
    }
    param1.writeDouble(this.defenderId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightType = param1.readByte();
    if (this.fightType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.fightType
              + ") on element of FightExternalInformations.fightType.");
    }

    this.attackerId = param1.readVarUhLong();
    if (this.attackerId < 0 || this.attackerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.attackerId
              + ") on element of GameRolePlayAggressionMessage.attackerId.");
    }

    this.defenderId = param1.readVarUhLong();
    if (this.defenderId < 0 || this.defenderId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.defenderId
              + ") on element of GameRolePlayAggressionMessage.defenderId.");
    }
  }
}
