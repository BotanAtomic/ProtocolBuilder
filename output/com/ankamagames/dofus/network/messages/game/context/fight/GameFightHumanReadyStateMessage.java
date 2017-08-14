package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightHumanReadyStateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number characterId = 0;
  public boolean isReady = false;
  public static final int protocolId = 740;

  public void serialize(ICustomDataOutput param1) {
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
    }
    param1.writeVarLong(this.characterId);
    param1.writeBoolean(this.isReady);
  }

  public void deserialize(ICustomDataInput param1) {
    this.characterId = param1.readVarUhLong();
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.characterId
              + ") on element of StartupActionsObjetAttributionMessage.characterId.");
    }

    this.isReady = param1.readBoolean();
  }
}
