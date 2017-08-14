package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightReduceDamagesMessage extends AbstractGameActionMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number targetId = 0;
  public int amount = 0;
  public static final int protocolId = 5526;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeDouble(this.sourceId);

    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
    if (this.amount < 0) {
      throw new Error("Forbidden value (" + this.amount + ") on element amount.");
    }
    param1.writeVarInt(this.amount);
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

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    this.amount = param1.readVarUhLong();
    if (this.amount < 0 || this.amount > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.amount + ") on element of HouseSellRequestMessage.amount.");
    }
  }
}
