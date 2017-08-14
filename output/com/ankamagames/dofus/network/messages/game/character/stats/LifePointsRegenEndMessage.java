package com.ankamagames.dofus.network.messages.game.character.stats;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LifePointsRegenEndMessage extends UpdateLifePointsMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int lifePointsGained = 0;
  public static final int protocolId = 5686;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.lifePoints < 0) {
      throw new Error("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
    }
    param1.writeVarInt(this.lifePoints);
    if (this.maxLifePoints < 0) {
      throw new Error("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
    }
    param1.writeVarInt(this.maxLifePoints);

    if (this.lifePointsGained < 0) {
      throw new Error(
          "Forbidden value (" + this.lifePointsGained + ") on element lifePointsGained.");
    }
    param1.writeVarInt(this.lifePointsGained);
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

    this.lifePointsGained = param1.readVarUhInt();
    if (this.lifePointsGained < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lifePointsGained
              + ") on element of LifePointsRegenEndMessage.lifePointsGained.");
    }
  }
}
