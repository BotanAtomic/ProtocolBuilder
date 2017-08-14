package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChangeHavenBagRoomRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int roomId = 0;
  public static final int protocolId = 6638;

  public void serialize(ICustomDataOutput param1) {
    if (this.roomId < 0) {
      throw new Exception("Forbidden value (" + this.roomId + ") on element roomId.");
    }
    param1.writeByte(this.roomId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.roomId = param1.readByte();
    if (this.roomId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.roomId
              + ") on element of MapComplementaryInformationsDataInHavenBagMessage.roomId.");
    }
  }
}
