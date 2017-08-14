package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockToSellListRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int pageIndex = 0;
  public static final int protocolId = 6141;

  public void serialize(ICustomDataOutput param1) {
    if (this.pageIndex < 0) {
      throw new Error("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
    }
    param1.writeVarShort(this.pageIndex);
  }

  public void deserialize(ICustomDataInput param1) {
    this.pageIndex = param1.readVarUhShort();
    if (this.pageIndex < 0) {
      throw new Error(
          "Forbidden value ("
              + this.pageIndex
              + ") on element of PaddockToSellListRequestMessage.pageIndex.");
    }
  }
}
