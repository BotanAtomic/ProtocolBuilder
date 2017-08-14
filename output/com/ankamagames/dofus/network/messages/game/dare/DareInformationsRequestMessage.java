package com.ankamagames.dofus.network.messages.game.dare;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareInformationsRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number dareId = 0;
  public static final int protocolId = 6659;

  public void serialize(ICustomDataOutput param1) {
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
    }
    param1.writeDouble(this.dareId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.dareId = param1.readDouble();
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.dareId + ") on element of DareVersatileInformations.dareId.");
    }
  }
}
