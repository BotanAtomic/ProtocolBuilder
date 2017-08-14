package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ContactLookRequestByNameMessage extends ContactLookRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public String playerName = "";
  public static final int protocolId = 5933;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.requestId < 0 || this.requestId > 255) {
      throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
    }
    param1.writeByte(this.requestId);
    param1.writeByte(this.contactType);

    param1.writeUTF(this.playerName);
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

    this.playerName = param1.readUTF();
  }
}
