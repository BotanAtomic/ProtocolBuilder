package com.ankamagames.dofus.network.messages.game.almanach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlmanachCalendarDateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int date = 0;
  public static final int protocolId = 6341;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.date);
  }

  public void deserialize(ICustomDataInput param1) {
    this.date = param1.readInt();
    if (this.date < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.date
              + ") on element of AdditionalTaxCollectorInformations.date.");
    }
  }
}
