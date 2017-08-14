package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntDigRequestAnswerFailedMessage extends TreasureHuntDigRequestAnswerMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int wrongFlagCount = 0;
  public static final int protocolId = 6509;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.questType);
    param1.writeByte(this.result);

    if (this.wrongFlagCount < 0) {
      throw new Error("Forbidden value (" + this.wrongFlagCount + ") on element wrongFlagCount.");
    }
    param1.writeByte(this.wrongFlagCount);
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

    this.wrongFlagCount = param1.readByte();
    if (this.wrongFlagCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.wrongFlagCount
              + ") on element of TreasureHuntDigRequestAnswerFailedMessage.wrongFlagCount.");
    }
  }
}
