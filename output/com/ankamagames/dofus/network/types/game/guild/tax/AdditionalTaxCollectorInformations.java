package com.ankamagames.dofus.network.types.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AdditionalTaxCollectorInformations extends Object implements INetworkType {

  public String collectorCallerName = "";
  public int date = 0;
  public static final int protocolId = 165;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.collectorCallerName);
    if (this.date < 0) {
      throw new Exception("Forbidden value (" + this.date + ") on element date.");
    }
    param1.writeInt(this.date);
  }

  public void deserialize(ICustomDataInput param1) {
    this.collectorCallerName = param1.readUTF();

    this.date = param1.readInt();
    if (this.date < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.date
              + ") on element of AdditionalTaxCollectorInformations.date.");
    }
  }
}
