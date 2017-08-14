package com.ankamagames.dofus.network.messages.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationFailedBannedMessage extends IdentificationFailedMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number banEndDate = 0;
  public static final int protocolId = 6174;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.reason);

    if (this.banEndDate < 0 || this.banEndDate > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.banEndDate + ") on element banEndDate.");
    }
    param1.writeDouble(this.banEndDate);
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

    this.banEndDate = param1.readDouble();
    if (this.banEndDate < 0 || this.banEndDate > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.banEndDate
              + ") on element of IdentificationFailedBannedMessage.banEndDate.");
    }
  }
}
