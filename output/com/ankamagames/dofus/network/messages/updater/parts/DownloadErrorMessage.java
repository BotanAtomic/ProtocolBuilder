package com.ankamagames.dofus.network.messages.updater.parts;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DownloadErrorMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int errorId = 0;
  public String message = "";
  public String helpUrl = "";
  public static final int protocolId = 1513;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.errorId);
    param1.writeUTF(this.message);
    param1.writeUTF(this.helpUrl);
  }

  public void deserialize(ICustomDataInput param1) {
    this.errorId = param1.readByte();
    if (this.errorId < 0) {
      throw new Error(
          "Forbidden value (" + this.errorId + ") on element of DownloadErrorMessage.errorId.");
    }

    this.message = param1.readUTF();

    this.helpUrl = param1.readUTF();
  }
}
