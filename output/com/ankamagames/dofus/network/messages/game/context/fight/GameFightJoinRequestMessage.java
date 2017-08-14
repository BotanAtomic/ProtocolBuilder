package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightJoinRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number fighterId = 0;
  public int fightId = 0;
  public static final int protocolId = 701;

  public void serialize(ICustomDataOutput param1) {
    if (this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.fighterId + ") on element fighterId.");
    }
    param1.writeDouble(this.fighterId);
    param1.writeInt(this.fightId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fighterId = param1.readDouble();
    if (this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.fighterId
              + ") on element of RefreshCharacterStatsMessage.fighterId.");
    }

    this.fightId = param1.readInt();
  }
}
