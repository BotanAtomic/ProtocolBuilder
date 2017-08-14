package com.ankamagames.dofus.network.messages.game.tinsel;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TitleLostMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int titleId = 0;
  public static final int protocolId = 6371;

  public void serialize(ICustomDataOutput param1) {
    if (this.titleId < 0) {
      throw new Exception("Forbidden value (" + this.titleId + ") on element titleId.");
    }
    param1.writeVarShort(this.titleId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.titleId = param1.readVarUhShort();
    if (this.titleId < 0) {
      throw new Exception(
          "Forbidden value (" + this.titleId + ") on element of HumanOptionTitle.titleId.");
    }
  }
}
