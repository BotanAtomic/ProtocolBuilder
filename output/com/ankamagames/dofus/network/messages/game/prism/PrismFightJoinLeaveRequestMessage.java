package com.ankamagames.dofus.network.messages.game.prism;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismFightJoinLeaveRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int subAreaId = 0;
  public boolean join = false;
  public static final int protocolId = 5843;

  public void serialize(ICustomDataOutput param1) {
    if (this.subAreaId < 0) {
      throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
    param1.writeBoolean(this.join);
  }

  public void deserialize(ICustomDataInput param1) {
    this.subAreaId = param1.readVarUhShort();
    if (this.subAreaId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.subAreaId
              + ") on element of PrismSubareaEmptyInfo.subAreaId.");
    }

    this.join = param1.readBoolean();
  }
}
