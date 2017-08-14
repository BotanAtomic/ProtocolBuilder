package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockSellBuyDialogMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean bsell = false;
  public int ownerId = 0;
  public Number price = 0;
  public static final int protocolId = 6018;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.bsell);
    if (this.ownerId < 0) {
      throw new Error("Forbidden value (" + this.ownerId + ") on element ownerId.");
    }
    param1.writeVarInt(this.ownerId);
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.price + ") on element price.");
    }
    param1.writeVarLong(this.price);
  }

  public void deserialize(ICustomDataInput param1) {
    this.bsell = param1.readBoolean();

    this.ownerId = param1.readInt();
    if (this.ownerId < 0) {
      throw new Error(
          "Forbidden value (" + this.ownerId + ") on element of MountClientData.ownerId.");
    }

    this.price = param1.readVarUhLong();
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.price + ") on element of PaddockInformationsForSell.price.");
    }
  }
}
