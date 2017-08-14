package com.ankamagames.dofus.network.types.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatedElement extends Object implements INetworkType {

  public int elementId = 0;
  public int elementCellId = 0;
  public int elementState = 0;
  public boolean onCurrentMap = false;
  public static final int protocolId = 108;

  public void serialize(ICustomDataOutput param1) {
    if (this.elementId < 0) {
      throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
    }
    param1.writeInt(this.elementId);
    if (this.elementCellId < 0 || this.elementCellId > 559) {
      throw new Exception("Forbidden value (" + this.elementCellId + ") on element elementCellId.");
    }
    param1.writeVarShort(this.elementCellId);
    if (this.elementState < 0) {
      throw new Exception("Forbidden value (" + this.elementState + ") on element elementState.");
    }
    param1.writeVarInt(this.elementState);
    param1.writeBoolean(this.onCurrentMap);
  }

  public void deserialize(ICustomDataInput param1) {
    this.elementId = param1.readInt();
    if (this.elementId < 0) {
      throw new Exception(
          "Forbidden value (" + this.elementId + ") on element of StatedElement.elementId.");
    }

    this.elementCellId = param1.readVarUhShort();
    if (this.elementCellId < 0 || this.elementCellId > 559) {
      throw new Exception(
          "Forbidden value ("
              + this.elementCellId
              + ") on element of StatedElement.elementCellId.");
    }

    this.elementState = param1.readVarUhInt();
    if (this.elementState < 0) {
      throw new Exception(
          "Forbidden value (" + this.elementState + ") on element of StatedElement.elementState.");
    }

    this.onCurrentMap = param1.readBoolean();
  }
}
