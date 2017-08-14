package com.ankamagames.dofus.network.messages.updater.parts;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DownloadCurrentSpeedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int downloadSpeed = 0;
  public static final int protocolId = 1511;

  public void serialize(ICustomDataOutput param1) {
    if (this.downloadSpeed < 1 || this.downloadSpeed > 10) {
      throw new Exception("Forbidden value (" + this.downloadSpeed + ") on element downloadSpeed.");
    }
    param1.writeByte(this.downloadSpeed);
  }

  public void deserialize(ICustomDataInput param1) {
    this.downloadSpeed = param1.readByte();
    if (this.downloadSpeed < 1 || this.downloadSpeed > 10) {
      throw new Exception(
          "Forbidden value ("
              + this.downloadSpeed
              + ") on element of DownloadSetSpeedRequestMessage.downloadSpeed.");
    }
  }
}
