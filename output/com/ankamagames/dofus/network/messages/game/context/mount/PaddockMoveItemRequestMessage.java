package com.ankamagames.dofus.network.messages.game.context.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockMoveItemRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int oldCellId = 0;
  public int newCellId = 0;
  public static final int protocolId = 6052;

  public void serialize(ICustomDataOutput param1) {
    if (this.oldCellId < 0 || this.oldCellId > 559) {
      throw new Error("Forbidden value (" + this.oldCellId + ") on element oldCellId.");
    }
    param1.writeVarShort(this.oldCellId);
    if (this.newCellId < 0 || this.newCellId > 559) {
      throw new Error("Forbidden value (" + this.newCellId + ") on element newCellId.");
    }
    param1.writeVarShort(this.newCellId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.oldCellId = param1.readVarUhShort();
    if (this.oldCellId < 0 || this.oldCellId > 559) {
      throw new Error(
          "Forbidden value ("
              + this.oldCellId
              + ") on element of PaddockMoveItemRequestMessage.oldCellId.");
    }

    this.newCellId = param1.readVarUhShort();
    if (this.newCellId < 0 || this.newCellId > 559) {
      throw new Error(
          "Forbidden value ("
              + this.newCellId
              + ") on element of PaddockMoveItemRequestMessage.newCellId.");
    }
  }
}
