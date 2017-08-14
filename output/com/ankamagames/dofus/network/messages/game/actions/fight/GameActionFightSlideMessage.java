package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightSlideMessage extends AbstractGameActionMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number targetId = 0;
  public int startCellId = 0;
  public int endCellId = 0;
  public static final int protocolId = 5525;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeDouble(this.sourceId);

    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
    if (this.startCellId < -1 || this.startCellId > 559) {
      throw new Exception("Forbidden value (" + this.startCellId + ") on element startCellId.");
    }
    param1.writeShort(this.startCellId);
    if (this.endCellId < -1 || this.endCellId > 559) {
      throw new Exception("Forbidden value (" + this.endCellId + ") on element endCellId.");
    }
    param1.writeShort(this.endCellId);
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

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    this.startCellId = param1.readShort();
    if (this.startCellId < -1 || this.startCellId > 559) {
      throw new Exception(
          "Forbidden value ("
              + this.startCellId
              + ") on element of GameActionFightSlideMessage.startCellId.");
    }

    this.endCellId = param1.readShort();
    if (this.endCellId < -1 || this.endCellId > 559) {
      throw new Exception(
          "Forbidden value ("
              + this.endCellId
              + ") on element of GameActionFightSlideMessage.endCellId.");
    }
  }
}
