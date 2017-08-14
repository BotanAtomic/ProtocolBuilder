package com.ankamagames.dofus.network.types.web.krosmaster;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterFigure extends Object implements INetworkType {

  public String uid = "";
  public int figure = 0;
  public int pedestal = 0;
  public boolean bound = false;
  public static final int protocolId = 397;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.uid);
    if (this.figure < 0) {
      throw new Exception("Forbidden value (" + this.figure + ") on element figure.");
    }
    param1.writeVarShort(this.figure);
    if (this.pedestal < 0) {
      throw new Exception("Forbidden value (" + this.pedestal + ") on element pedestal.");
    }
    param1.writeVarShort(this.pedestal);
    param1.writeBoolean(this.bound);
  }

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
  }
}
