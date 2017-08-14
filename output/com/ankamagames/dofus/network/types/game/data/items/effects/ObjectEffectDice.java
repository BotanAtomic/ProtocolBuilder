package com.ankamagames.dofus.network.types.game.data.items.effects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectDice extends ObjectEffect implements INetworkType {

  public int diceNum = 0;
  public int diceSide = 0;
  public int diceConst = 0;
  public static final int protocolId = 73;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);

    if (this.diceNum < 0) {
      throw new Error("Forbidden value (" + this.diceNum + ") on element diceNum.");
    }
    param1.writeVarShort(this.diceNum);
    if (this.diceSide < 0) {
      throw new Error("Forbidden value (" + this.diceSide + ") on element diceSide.");
    }
    param1.writeVarShort(this.diceSide);
    if (this.diceConst < 0) {
      throw new Error("Forbidden value (" + this.diceConst + ") on element diceConst.");
    }
    param1.writeVarShort(this.diceConst);
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

    this.diceNum = param1.readVarUhShort();
    if (this.diceNum < 0) {
      throw new Error(
          "Forbidden value (" + this.diceNum + ") on element of ObjectEffectDice.diceNum.");
    }

    this.diceSide = param1.readVarUhShort();
    if (this.diceSide < 0) {
      throw new Error(
          "Forbidden value (" + this.diceSide + ") on element of ObjectEffectDice.diceSide.");
    }

    this.diceConst = param1.readVarUhShort();
    if (this.diceConst < 0) {
      throw new Error(
          "Forbidden value (" + this.diceConst + ") on element of ObjectEffectDice.diceConst.");
    }
  }
}
