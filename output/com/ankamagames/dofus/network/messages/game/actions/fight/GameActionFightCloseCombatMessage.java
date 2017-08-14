package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightCloseCombatMessage extends AbstractGameActionFightTargetedAbilityMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int weaponGenericId = 0;
  public static final int protocolId = 6116;

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

    if (this.weaponGenericId < 0) {
      throw new Error("Forbidden value (" + this.weaponGenericId + ") on element weaponGenericId.");
    }
    param1.writeVarShort(this.weaponGenericId);
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

    this.weaponGenericId = param1.readVarUhShort();
    if (this.weaponGenericId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.weaponGenericId
              + ") on element of GameActionFightCloseCombatMessage.weaponGenericId.");
    }
  }
}
