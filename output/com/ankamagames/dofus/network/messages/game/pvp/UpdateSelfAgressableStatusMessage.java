package com.ankamagames.dofus.network.messages.game.pvp;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class UpdateSelfAgressableStatusMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int status = 0;
  public int probationTime = 0;
  public static final int protocolId = 6456;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.status);
    if (this.probationTime < 0) {
      throw new Exception("Forbidden value (" + this.probationTime + ") on element probationTime.");
    }
    param1.writeInt(this.probationTime);
  }

  public void deserialize(ICustomDataInput param1) {
    this.status = param1.readByte();
    if (this.status < 0) {
      throw new Exception(
          "Forbidden value (" + this.status + ") on element of GameServerInformations.status.");
    }

    this.probationTime = param1.readInt();
    if (this.probationTime < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.probationTime
              + ") on element of CharacterCharacteristicsInformations.probationTime.");
    }
  }
}
