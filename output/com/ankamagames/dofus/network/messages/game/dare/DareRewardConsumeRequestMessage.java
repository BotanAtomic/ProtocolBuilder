package com.ankamagames.dofus.network.messages.game.dare;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareRewardConsumeRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number dareId = 0;
  public int type = 0;
  public static final int protocolId = 6676;

  public void serialize(ICustomDataOutput param1) {
    if (this.dareId < -9.007199254740992E15 || this.dareId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.dareId + ") on element dareId.");
    }
    param1.writeDouble(this.dareId);
    param1.writeByte(this.type);
  }

  public void deserialize(ICustomDataInput param1) {
    this.dareId = param1.readDouble();
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.dareId + ") on element of DareVersatileInformations.dareId.");
    }

    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Error("Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }
  }
}
