package com.ankamagames.dofus.network.types.game.data.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GoldItem extends Item implements INetworkType {

  public Number sum = 0;
  public static final int protocolId = 123;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.sum < 0 || this.sum > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.sum + ") on element sum.");
    }
    param1.writeVarLong(this.sum);
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

    this.sum = param1.readVarUhLong();
    if (this.sum < 0 || this.sum > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.sum + ") on element of GoldItem.sum.");
    }
  }
}
