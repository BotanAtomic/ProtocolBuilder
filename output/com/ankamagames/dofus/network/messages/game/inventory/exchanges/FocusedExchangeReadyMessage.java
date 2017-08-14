package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FocusedExchangeReadyMessage extends ExchangeReadyMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int focusActionId = 0;
  public static final int protocolId = 6701;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.ready);
    if (this.step < 0) {
      throw new Error("Forbidden value (" + this.step + ") on element step.");
    }
    param1.writeVarShort(this.step);

    if (this.focusActionId < 0) {
      throw new Error("Forbidden value (" + this.focusActionId + ") on element focusActionId.");
    }
    param1.writeVarInt(this.focusActionId);
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

    this.focusActionId = param1.readVarUhInt();
    if (this.focusActionId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.focusActionId
              + ") on element of FocusedExchangeReadyMessage.focusActionId.");
    }
  }
}
