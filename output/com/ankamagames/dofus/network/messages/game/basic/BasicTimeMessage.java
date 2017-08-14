package com.ankamagames.dofus.network.messages.game.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicTimeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number timestamp = 0;
  public int timezoneOffset = 0;
  public static final int protocolId = 175;

  public void serialize(ICustomDataOutput param1) {
    if (this.timestamp < 0 || this.timestamp > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.timestamp + ") on element timestamp.");
    }
    param1.writeDouble(this.timestamp);
    param1.writeShort(this.timezoneOffset);
  }

  public void deserialize(ICustomDataInput param1) {
    this.timestamp = param1.readDouble();
    if (this.timestamp < -9.007199254740992E15 || this.timestamp > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.timestamp
              + ") on element of SubscriptionUpdateMessage.timestamp.");
    }

    this.timezoneOffset = param1.readShort();
  }
}
