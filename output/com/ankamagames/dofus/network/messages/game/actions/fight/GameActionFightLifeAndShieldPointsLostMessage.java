package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightLifeAndShieldPointsLostMessage
    extends GameActionFightLifePointsLostMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int shieldLoss = 0;
  public static final int protocolId = 6310;

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
    if (this.loss < 0) {
      throw new Exception("Forbidden value (" + this.loss + ") on element loss.");
    }
    param1.writeVarInt(this.loss);
    if (this.permanentDamages < 0) {
      throw new Exception(
          "Forbidden value (" + this.permanentDamages + ") on element permanentDamages.");
    }
    param1.writeVarInt(this.permanentDamages);

    if (this.shieldLoss < 0) {
      throw new Exception("Forbidden value (" + this.shieldLoss + ") on element shieldLoss.");
    }
    param1.writeVarShort(this.shieldLoss);
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

    this.shieldLoss = param1.readVarUhShort();
    if (this.shieldLoss < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.shieldLoss
              + ") on element of GameActionFightLifeAndShieldPointsLostMessage.shieldLoss.");
    }
  }
}
