package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseSellFromInsideRequestMessage extends HouseSellRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 5884;

  @Override
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

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();
  }
}
