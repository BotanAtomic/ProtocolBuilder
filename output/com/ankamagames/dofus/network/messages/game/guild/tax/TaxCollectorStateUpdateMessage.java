package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorStateUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int uniqueId = 0;
  public int state = 0;
  public static final int protocolId = 6455;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.uniqueId);
    param1.writeByte(this.state);
  }

  public void deserialize(ICustomDataInput param1) {
    this.uniqueId = param1.readInt();

    this.state = param1.readByte();
    if (this.state < 0) {
      throw new Error("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }
  }
}
