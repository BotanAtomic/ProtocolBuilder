package com.ankamagames.dofus.network.types.game.paddock;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockBuyableInformations extends Object implements INetworkType {

  public Number price = 0;
  public boolean locked = false;
  public static final int protocolId = 130;

  public void serialize(ICustomDataOutput param1) {
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.price + ") on element price.");
    }
    param1.writeVarLong(this.price);
    param1.writeBoolean(this.locked);
  }

  public void deserialize(ICustomDataInput param1) {
    this.price = param1.readVarUhLong();
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.price + ") on element of PaddockInformationsForSell.price.");
    }

    this.locked = param1.readBoolean();
  }
}
