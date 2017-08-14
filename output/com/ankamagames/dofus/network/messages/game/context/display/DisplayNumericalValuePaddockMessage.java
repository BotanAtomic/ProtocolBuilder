package com.ankamagames.dofus.network.messages.game.context.display;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DisplayNumericalValuePaddockMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int rideId = 0;
  public int value = 0;
  public int type = 0;
  public static final int protocolId = 6563;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.rideId);
    param1.writeInt(this.value);
    param1.writeByte(this.type);
  }

  public void deserialize(ICustomDataInput param1) {
    this.rideId = param1.readVarInt();

    this.value = param1.readInt();

    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Error("Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }
  }
}
