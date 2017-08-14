package com.ankamagames.dofus.network.messages.game.report;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterReportMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number reportedId = 0;
  public int reason = 0;
  public static final int protocolId = 6079;

  public void serialize(ICustomDataOutput param1) {
    if (this.reportedId < 0 || this.reportedId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.reportedId + ") on element reportedId.");
    }
    param1.writeVarLong(this.reportedId);
    if (this.reason < 0) {
      throw new Error("Forbidden value (" + this.reason + ") on element reason.");
    }
    param1.writeByte(this.reason);
  }

  public void deserialize(ICustomDataInput param1) {
    this.reportedId = param1.readVarUhLong();
    if (this.reportedId < 0 || this.reportedId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.reportedId
              + ") on element of CharacterReportMessage.reportedId.");
    }

    this.reason = param1.readByte();
    if (this.reason < 0) {
      throw new Error(
          "Forbidden value ("
              + this.reason
              + ") on element of KrosmasterInventoryErrorMessage.reason.");
    }
  }
}
