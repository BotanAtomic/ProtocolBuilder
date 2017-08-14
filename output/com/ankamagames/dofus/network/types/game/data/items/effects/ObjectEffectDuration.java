package com.ankamagames.dofus.network.types.game.data.items.effects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectDuration extends ObjectEffect implements INetworkType {

  public int days = 0;
  public int hours = 0;
  public int minutes = 0;
  public static final int protocolId = 75;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);

    if (this.days < 0) {
      throw new Error("Forbidden value (" + this.days + ") on element days.");
    }
    param1.writeVarShort(this.days);
    if (this.hours < 0) {
      throw new Error("Forbidden value (" + this.hours + ") on element hours.");
    }
    param1.writeByte(this.hours);
    if (this.minutes < 0) {
      throw new Error("Forbidden value (" + this.minutes + ") on element minutes.");
    }
    param1.writeByte(this.minutes);
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

    this.days = param1.readVarUhShort();
    if (this.days < 0) {
      throw new Error(
          "Forbidden value (" + this.days + ") on element of ObjectEffectDuration.days.");
    }

    this.hours = param1.readByte();
    if (this.hours < 0) {
      throw new Error(
          "Forbidden value (" + this.hours + ") on element of ObjectEffectDuration.hours.");
    }

    this.minutes = param1.readByte();
    if (this.minutes < 0) {
      throw new Error(
          "Forbidden value (" + this.minutes + ") on element of ObjectEffectDuration.minutes.");
    }
  }
}
