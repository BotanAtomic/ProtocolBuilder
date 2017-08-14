package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameCautiousMapMovementRequestMessage extends GameMapMovementRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6496;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.keyMovements.length);
    int _loc2_ = 0;
    while (_loc2_ < this.keyMovements.length) {
      if (this.keyMovements[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.keyMovements[_loc2_]
                + ") on element 1 (starting at 1) of keyMovements.");
      }
      param1.writeShort(this.keyMovements[_loc2_]);
      _loc2_++;
    }
    if (this.mapId < 0) {
      throw new Error("Forbidden value (" + this.mapId + ") on element mapId.");
    }
    param1.writeInt(this.mapId);
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
