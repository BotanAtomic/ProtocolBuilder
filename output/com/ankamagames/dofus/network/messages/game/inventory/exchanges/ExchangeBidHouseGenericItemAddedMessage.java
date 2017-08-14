package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseGenericItemAddedMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objGenericId = 0;
  public static final int protocolId = 5947;

  public void serialize(ICustomDataOutput param1) {
    if (this.objGenericId < 0) {
      throw new Error("Forbidden value (" + this.objGenericId + ") on element objGenericId.");
    }
    param1.writeVarShort(this.objGenericId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objGenericId = param1.readInt();
  }
}
