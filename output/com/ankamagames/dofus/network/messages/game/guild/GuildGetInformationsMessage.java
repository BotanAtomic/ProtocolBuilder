package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildGetInformationsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int infoType = 0;
  public static final int protocolId = 5550;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.infoType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.infoType = param1.readByte();
    if (this.infoType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.infoType
              + ") on element of GuildGetInformationsMessage.infoType.");
    }
  }
}
