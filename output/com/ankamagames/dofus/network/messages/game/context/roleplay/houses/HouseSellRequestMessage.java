package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseSellRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int instanceId = 0;
  public Number amount = 0;
  public boolean forSale = false;
  public static final int protocolId = 5697;

  public void serialize(ICustomDataOutput param1) {
    if (this.instanceId < 0) {
      throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    if (this.amount < 0 || this.amount > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.amount + ") on element amount.");
    }
    param1.writeVarLong(this.amount);
    param1.writeBoolean(this.forSale);
  }

  public void deserialize(ICustomDataInput param1) {
    this.instanceId = param1.readInt();
    if (this.instanceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.instanceId
              + ") on element of HouseInstanceInformations.instanceId.");
    }

    this.amount = param1.readVarUhLong();
    if (this.amount < 0 || this.amount > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.amount + ") on element of HouseSellRequestMessage.amount.");
    }

    this.forSale = param1.readBoolean();
  }
}
