package com.ankamagames.dofus.network.types.game.approach;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerSessionConstantLong extends ServerSessionConstant implements INetworkType {

  public Number value = 0;
  public static final int protocolId = 429;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);

    if (this.value < -9.007199254740992E15 || this.value > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.value + ") on element value.");
    }
    param1.writeDouble(this.value);
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

    this.value = param1.readInt();
  }
}
