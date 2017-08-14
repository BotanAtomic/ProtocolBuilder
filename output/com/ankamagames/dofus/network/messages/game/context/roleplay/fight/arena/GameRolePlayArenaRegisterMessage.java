package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaRegisterMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int battleMode = 3;
  public static final int protocolId = 6280;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.battleMode);
  }

  public void deserialize(ICustomDataInput param1) {
    this.battleMode = param1.readInt();
    if (this.battleMode < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.battleMode
              + ") on element of GameRolePlayArenaRegistrationStatusMessage.battleMode.");
    }
  }
}
