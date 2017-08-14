package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectUseOnCellMessage extends ObjectUseMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int cells = 0;
  public static final int protocolId = 3013;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.objectUID < 0) {
      throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);

    if (this.cells < 0 || this.cells > 559) {
      throw new Error("Forbidden value (" + this.cells + ") on element cells.");
    }
    param1.writeVarShort(this.cells);
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

    GameActionMarkedCell _loc2_ = new GameActionMarkedCell();
    _loc2_.deserialize(param1);
    this.cells.push(_loc2_);
  }
}
