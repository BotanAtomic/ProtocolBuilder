package com.ankamagames.dofus.network.messages.game.chat.smiley;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LocalizedChatSmileyMessage extends ChatSmileyMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int cellId = 0;
  public static final int protocolId = 6185;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.entityId + ") on element entityId.");
    }
    param1.writeDouble(this.entityId);
    if (this.smileyId < 0) {
      throw new Error("Forbidden value (" + this.smileyId + ") on element smileyId.");
    }
    param1.writeVarShort(this.smileyId);
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);

    if (this.cellId < 0 || this.cellId > 559) {
      throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeVarShort(this.cellId);
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

    this.cellId = param1.readVarUhShort();
    if (this.cellId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.cellId
              + ") on element of HavenBagFurnitureInformation.cellId.");
    }
  }
}
