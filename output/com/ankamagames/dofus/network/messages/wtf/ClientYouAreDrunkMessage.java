package com.ankamagames.dofus.network.messages.wtf;

import com.ankamagames.dofus.network.messages.debug.DebugInClientMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ClientYouAreDrunkMessage extends DebugInClientMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6594;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.level);
    param1.writeUTF(this.message);
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
