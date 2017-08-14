package com.ankamagames.dofus.network.types.game.data.items.effects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectMinMax extends ObjectEffect implements INetworkType {

  public int min = 0;
  public int max = 0;
  public static final int protocolId = 82;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);

    if (this.min < 0) {
      throw new Error("Forbidden value (" + this.min + ") on element min.");
    }
    param1.writeVarInt(this.min);
    if (this.max < 0) {
      throw new Error("Forbidden value (" + this.max + ") on element max.");
    }
    param1.writeVarInt(this.max);
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

    this.min = param1.readVarUhShort();
    if (this.min < 0) {
      throw new Error(
          "Forbidden value (" + this.min + ") on element of SkillActionDescriptionCollect.min.");
    }

    this.max = param1.readVarUhShort();
    if (this.max < 0) {
      throw new Error(
          "Forbidden value (" + this.max + ") on element of SkillActionDescriptionCollect.max.");
    }
  }
}
