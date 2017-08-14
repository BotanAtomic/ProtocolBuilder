package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseBuyResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int uid = 0;
  public boolean bought = false;
  public static final int protocolId = 6272;

  public void serialize(ICustomDataOutput param1) {
    if (this.uid < 0) {
      throw new Error("Forbidden value (" + this.uid + ") on element uid.");
    }
    param1.writeVarInt(this.uid);
    param1.writeBoolean(this.bought);
  }

  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.bought = param1.readBoolean();
  }
}
