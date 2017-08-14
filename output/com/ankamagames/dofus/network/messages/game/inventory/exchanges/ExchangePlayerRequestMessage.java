package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangePlayerRequestMessage extends ExchangeRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number target = 0;
  public static final int protocolId = 5773;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.exchangeType);

    if (this.target < 0 || this.target > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.target + ") on element target.");
    }
    param1.writeVarLong(this.target);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.target = param1.readVarUhLong();
    if (this.target < 0 || this.target > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.target
              + ") on element of ExchangeRequestedTradeMessage.target.");
    }
  }
}
