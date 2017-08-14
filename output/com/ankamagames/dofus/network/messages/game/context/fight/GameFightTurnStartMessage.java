package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightTurnStartMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number id = 0;
  public int waitTime = 0;
  public static final int protocolId = 714;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    if (this.waitTime < 0) {
      throw new Exception("Forbidden value (" + this.waitTime + ") on element waitTime.");
    }
    param1.writeVarInt(this.waitTime);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.waitTime = param1.readVarUhInt();
    if (this.waitTime < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.waitTime
              + ") on element of GameFightTurnStartMessage.waitTime.");
    }
  }
}
