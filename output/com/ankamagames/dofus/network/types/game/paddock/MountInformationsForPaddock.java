package com.ankamagames.dofus.network.types.game.paddock;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountInformationsForPaddock extends Object implements INetworkType {

  public int modelId = 0;
  public String name = "";
  public String ownerName = "";
  public static final int protocolId = 184;

  public void serialize(ICustomDataOutput param1) {
    if (this.modelId < 0) {
      throw new Exception("Forbidden value (" + this.modelId + ") on element modelId.");
    }
    param1.writeVarShort(this.modelId);
    param1.writeUTF(this.name);
    param1.writeUTF(this.ownerName);
  }

  public void deserialize(ICustomDataInput param1) {
    this.modelId = param1.readVarUhShort();
    if (this.modelId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.modelId
              + ") on element of MountInformationsForPaddock.modelId.");
    }

    this.name = param1.readUTF();

    this.ownerName = param1.readUTF();
  }
}
