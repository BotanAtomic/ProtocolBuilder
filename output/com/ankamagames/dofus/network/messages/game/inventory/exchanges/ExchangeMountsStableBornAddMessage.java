package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMountsStableBornAddMessage extends ExchangeMountsStableAddMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6557;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.mountDescription.length);
    int _loc2_ = 0;
    while (_loc2_ < this.mountDescription.length) {
      ((MountClientData) this.mountDescription[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
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
  }
}
