package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LockableStateUpdateStorageMessage extends LockableStateUpdateAbstractMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int mapId = 0;
  public int elementId = 0;
  public static final int protocolId = 5669;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.locked);

    param1.writeInt(this.mapId);
    if (this.elementId < 0) {
      throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
    }
    param1.writeVarInt(this.elementId);
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

    this.mapId = param1.readInt();

    this.elementId = param1.readInt();
    if (this.elementId < 0) {
      throw new Exception(
          "Forbidden value (" + this.elementId + ") on element of StatedElement.elementId.");
    }
  }
}
