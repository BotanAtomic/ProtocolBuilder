package com.ankamagames.dofus.network.types.secure;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TrustCertificate extends Object implements INetworkType {

  public int id = 0;
  public String hash = "";
  public static final int protocolId = 377;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeInt(this.id);
    param1.writeUTF(this.hash);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.hash = param1.readUTF();
  }
}
