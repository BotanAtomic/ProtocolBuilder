package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObtainedItemWithBonusMessage extends ObtainedItemMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int bonusQuantity = 0;
  public static final int protocolId = 6520;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.genericId < 0) {
      throw new Error("Forbidden value (" + this.genericId + ") on element genericId.");
    }
    param1.writeVarShort(this.genericId);
    if (this.baseQuantity < 0) {
      throw new Error("Forbidden value (" + this.baseQuantity + ") on element baseQuantity.");
    }
    param1.writeVarInt(this.baseQuantity);

    if (this.bonusQuantity < 0) {
      throw new Error("Forbidden value (" + this.bonusQuantity + ") on element bonusQuantity.");
    }
    param1.writeVarInt(this.bonusQuantity);
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

    this.bonusQuantity = param1.readVarUhInt();
    if (this.bonusQuantity < 0) {
      throw new Error(
          "Forbidden value ("
              + this.bonusQuantity
              + ") on element of ObtainedItemWithBonusMessage.bonusQuantity.");
    }
  }
}
