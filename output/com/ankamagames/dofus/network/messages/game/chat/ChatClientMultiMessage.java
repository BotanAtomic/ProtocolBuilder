package com.ankamagames.dofus.network.messages.game.chat;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatClientMultiMessage extends ChatAbstractClientMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int channel = 0;
  public static final int protocolId = 861;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.content);

    param1.writeByte(this.channel);
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

    this.channel = param1.readByte();
    if (this.channel < 0) {
      throw new Exception(
          "Forbidden value (" + this.channel + ") on element of ChatMessageReportMessage.channel.");
    }
  }
}
