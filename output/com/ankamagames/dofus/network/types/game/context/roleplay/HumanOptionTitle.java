package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionTitle extends HumanOption implements INetworkType {

  public int titleId = 0;
  public String titleParam = "";
  public static final int protocolId = 408;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.titleId < 0) {
      throw new Error("Forbidden value (" + this.titleId + ") on element titleId.");
    }
    param1.writeVarShort(this.titleId);
    param1.writeUTF(this.titleParam);
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

    this.titleId = param1.readVarUhShort();
    if (this.titleId < 0) {
      throw new Error(
          "Forbidden value (" + this.titleId + ") on element of HumanOptionTitle.titleId.");
    }

    this.titleParam = param1.readUTF();
  }
}
