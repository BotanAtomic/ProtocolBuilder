package com.ankamagames.dofus.network.messages.game.startup;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StartupActionsAllAttributionMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number characterId = 0;
  public static final int protocolId = 6537;

  public void serialize(ICustomDataOutput param1) {
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.characterId + ") on element characterId.");
    }
    param1.writeVarLong(this.characterId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.characterId = param1.readVarUhLong();
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.characterId
              + ") on element of StartupActionsObjetAttributionMessage.characterId.");
    }
  }
}
