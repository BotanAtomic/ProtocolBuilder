package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.prism.PrismSubareaEmptyInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismsListUpdateMessage extends PrismsListMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6438;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.prisms.length);
    int _loc2_ = 0;
    while (_loc2_ < this.prisms.length) {
      param1.writeShort(((PrismSubareaEmptyInfo) (this.prisms[_loc2_])).getTypeId());
      ((PrismSubareaEmptyInfo) this.prisms[_loc2_]).serialize(param1);
      _loc2_++;
    }
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
