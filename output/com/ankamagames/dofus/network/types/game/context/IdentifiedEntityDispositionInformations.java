package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentifiedEntityDispositionInformations extends EntityDispositionInformations
    implements INetworkType {

  public Number id = 0;
  public static final int protocolId = 107;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.cellId < -1 || this.cellId > 559) {
      throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeShort(this.cellId);
    param1.writeByte(this.direction);

    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
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

    this.id = param1.readUTF();
  }
}
