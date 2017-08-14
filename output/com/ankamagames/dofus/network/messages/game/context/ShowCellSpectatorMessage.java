package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShowCellSpectatorMessage extends ShowCellMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String playerName = "";
  public static final int protocolId = 6158;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeDouble(this.sourceId);
    if (this.cellId < 0 || this.cellId > 559) {
      throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeVarShort(this.cellId);

    param1.writeUTF(this.playerName);
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

    this.playerName = param1.readUTF();
  }
}
