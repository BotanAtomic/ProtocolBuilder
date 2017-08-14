package com.ankamagames.dofus.network.messages.game.script;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CinematicMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int cinematicId = 0;
  public static final int protocolId = 6053;

  public void serialize(ICustomDataOutput param1) {
    if (this.cinematicId < 0) {
      throw new Exception("Forbidden value (" + this.cinematicId + ") on element cinematicId.");
    }
    param1.writeVarShort(this.cinematicId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.cinematicId = param1.readVarUhShort();
    if (this.cinematicId < 0) {
      throw new Exception(
          "Forbidden value (" + this.cinematicId + ") on element of CinematicMessage.cinematicId.");
    }
  }
}
