package com.ankamagames.dofus.network.messages.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextRemoveElementWithEventMessage extends GameContextRemoveElementMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int elementEventId = 0;
  public static final int protocolId = 6412;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);

    if (this.elementEventId < 0) {
      throw new Exception(
          "Forbidden value (" + this.elementEventId + ") on element elementEventId.");
    }
    param1.writeByte(this.elementEventId);
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

    this.elementEventId = param1.readByte();
    if (this.elementEventId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.elementEventId
              + ") on element of GameContextRemoveElementWithEventMessage.elementEventId.");
    }
  }
}
