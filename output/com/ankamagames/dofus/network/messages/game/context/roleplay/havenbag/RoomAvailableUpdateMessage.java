package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class RoomAvailableUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int nbRoom = 0;
  public static final int protocolId = 6630;

  public void serialize(ICustomDataOutput param1) {
    if (this.nbRoom < 0 || this.nbRoom > 255) {
      throw new Exception("Forbidden value (" + this.nbRoom + ") on element nbRoom.");
    }
    param1.writeByte(this.nbRoom);
  }

  public void deserialize(ICustomDataInput param1) {
    this.nbRoom = param1.readByte();
  }
}
