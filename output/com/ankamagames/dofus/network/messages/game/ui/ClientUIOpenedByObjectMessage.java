package com.ankamagames.dofus.network.messages.game.ui;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ClientUIOpenedByObjectMessage extends ClientUIOpenedMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int uid = 0;
  public static final int protocolId = 6463;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.type);

    if (this.uid < 0) {
      throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
    }
    param1.writeVarInt(this.uid);
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

    this.uid = param1.readUTF();
  }
}
