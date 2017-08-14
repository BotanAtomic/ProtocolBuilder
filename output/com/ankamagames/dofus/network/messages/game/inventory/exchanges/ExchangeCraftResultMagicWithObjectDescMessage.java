package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemNotInContainer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftResultMagicWithObjectDescMessage
    extends ExchangeCraftResultWithObjectDescMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int magicPoolStatus = 0;
  public static final int protocolId = 6188;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.craftResult);

    this.objectInfo.serializeAs_ObjectItemNotInContainer(param1);

    param1.writeByte(this.magicPoolStatus);
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

    this.magicPoolStatus = param1.readByte();
  }
}
