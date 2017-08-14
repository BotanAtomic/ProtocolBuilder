package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightLeaveMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number charId = 0;
  public static final int protocolId = 721;

  public void serialize(ICustomDataOutput param1) {
    if (this.charId < -9.007199254740992E15 || this.charId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.charId + ") on element charId.");
    }
    param1.writeDouble(this.charId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.charId = param1.readDouble();
    if (this.charId < -9.007199254740992E15 || this.charId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.charId
              + ") on element of GameFightRemoveTeamMemberMessage.charId.");
    }
  }
}
