package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectGroundRemovedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int cell = 0;
  public static final int protocolId = 3014;

  public void serialize(ICustomDataOutput param1) {
    if (this.cell < 0 || this.cell > 559) {
      throw new Error("Forbidden value (" + this.cell + ") on element cell.");
    }
    param1.writeVarShort(this.cell);
  }

  public void deserialize(ICustomDataInput param1) {
    this.cell = param1.readVarUhShort();
    if (this.cell < 0 || this.cell > 559) {
      throw new Error(
          "Forbidden value (" + this.cell + ") on element of ObjectGroundRemovedMessage.cell.");
    }
  }
}
