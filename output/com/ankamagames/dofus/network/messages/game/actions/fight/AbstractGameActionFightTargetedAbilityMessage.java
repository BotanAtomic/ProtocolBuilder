package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class AbstractGameActionFightTargetedAbilityMessage extends AbstractGameActionMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number targetId = 0;
  public int destinationCellId = 0;
  public int critical = 1;
  public boolean silentCast = false;
  public boolean verboseCast = false;
  public static final int protocolId = 6118;

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

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.silentCast);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.verboseCast);
    param1.writeByte(_loc2_);
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
    if (this.destinationCellId < -1 || this.destinationCellId > 559) {
      throw new Error(
          "Forbidden value (" + this.destinationCellId + ") on element destinationCellId.");
    }
    param1.writeShort(this.destinationCellId);
    param1.writeByte(this.critical);
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

    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.targetId = param1.readDouble();
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.targetId
              + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    this.destinationCellId = param1.readShort();
    if (this.destinationCellId < -1 || this.destinationCellId > 559) {
      throw new Error(
          "Forbidden value ("
              + this.destinationCellId
              + ") on element of AbstractGameActionFightTargetedAbilityMessage.destinationCellId.");
    }

    this.critical = param1.readByte();
    if (this.critical < 0) {
      throw new Error(
          "Forbidden value ("
              + this.critical
              + ") on element of AbstractGameActionFightTargetedAbilityMessage.critical.");
    }
  }
}
