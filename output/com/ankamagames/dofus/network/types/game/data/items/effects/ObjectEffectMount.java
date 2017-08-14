package com.ankamagames.dofus.network.types.game.data.items.effects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectMount extends ObjectEffect implements INetworkType {

  public int mountId = 0;
  public Number date = 0;
  public int modelId = 0;
  public static final int protocolId = 179;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);

    if (this.mountId < 0) {
      throw new Error("Forbidden value (" + this.mountId + ") on element mountId.");
    }
    param1.writeInt(this.mountId);
    if (this.date < -9.007199254740992E15 || this.date > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.date + ") on element date.");
    }
    param1.writeDouble(this.date);
    if (this.modelId < 0) {
      throw new Error("Forbidden value (" + this.modelId + ") on element modelId.");
    }
    param1.writeVarShort(this.modelId);
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

    this.mountId = param1.readInt();
    if (this.mountId < 0) {
      throw new Error(
          "Forbidden value (" + this.mountId + ") on element of ObjectEffectMount.mountId.");
    }

    this.date = param1.readInt();
    if (this.date < 0) {
      throw new Error(
          "Forbidden value ("
              + this.date
              + ") on element of AdditionalTaxCollectorInformations.date.");
    }

    this.modelId = param1.readVarUhShort();
    if (this.modelId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.modelId
              + ") on element of MountInformationsForPaddock.modelId.");
    }
  }
}
