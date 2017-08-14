package com.ankamagames.dofus.network.messages.game.prism;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismsListRegisterMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int listen = 0;
  public static final int protocolId = 6441;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.listen);
  }

  public void deserialize(ICustomDataInput param1) {
    this.listen = param1.readByte();
    if (this.listen < 0) {
      throw new Exception(
          "Forbidden value (" + this.listen + ") on element of PrismsListRegisterMessage.listen.");
    }
  }
}
