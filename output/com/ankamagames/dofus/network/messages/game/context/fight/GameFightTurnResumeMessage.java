package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightTurnResumeMessage extends GameFightTurnStartMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int remainingTime = 0;
  public static final int protocolId = 6307;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    if (this.waitTime < 0) {
      throw new Exception("Forbidden value (" + this.waitTime + ") on element waitTime.");
    }
    param1.writeVarInt(this.waitTime);

    if (this.remainingTime < 0) {
      throw new Exception("Forbidden value (" + this.remainingTime + ") on element remainingTime.");
    }
    param1.writeVarInt(this.remainingTime);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.remainingTime = param1.readVarUhInt();
    if (this.remainingTime < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.remainingTime
              + ") on element of GameFightTurnResumeMessage.remainingTime.");
    }
  }
}
