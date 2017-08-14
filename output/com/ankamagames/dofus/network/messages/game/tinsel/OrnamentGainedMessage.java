package com.ankamagames.dofus.network.messages.game.tinsel;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class OrnamentGainedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int ornamentId = 0;
  public static final int protocolId = 6368;

  public void serialize(ICustomDataOutput param1) {
    if (this.ornamentId < 0) {
      throw new Error("Forbidden value (" + this.ornamentId + ") on element ornamentId.");
    }
    param1.writeShort(this.ornamentId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.ornamentId = param1.readVarUhShort();
    if (this.ornamentId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.ornamentId
              + ") on element of HumanOptionOrnament.ornamentId.");
    }
  }
}
