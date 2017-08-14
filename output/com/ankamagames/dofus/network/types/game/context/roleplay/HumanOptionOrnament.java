package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionOrnament extends HumanOption implements INetworkType {

  public int ornamentId = 0;
  public static final int protocolId = 411;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.ornamentId < 0) {
      throw new Error("Forbidden value (" + this.ornamentId + ") on element ornamentId.");
    }
    param1.writeVarShort(this.ornamentId);
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

    this.ornamentId = param1.readVarUhShort();
    if (this.ornamentId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.ornamentId
              + ") on element of HumanOptionOrnament.ornamentId.");
    }
  }
}
