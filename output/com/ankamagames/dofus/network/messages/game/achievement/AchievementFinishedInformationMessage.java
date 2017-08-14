package com.ankamagames.dofus.network.messages.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementFinishedInformationMessage extends AchievementFinishedMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public String name = "";
  public Number playerId = 0;
  public static final int protocolId = 6381;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    if (this.finishedlevel < 0 || this.finishedlevel > 206) {
      throw new Exception("Forbidden value (" + this.finishedlevel + ") on element finishedlevel.");
    }
    param1.writeByte(this.finishedlevel);

    param1.writeUTF(this.name);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
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

    this.name = param1.readUTF();

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }
  }
}
