package com.ankamagames.dofus.network.messages.game.moderation;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PopupWarningMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int lockDuration = 0;
  public String author = "";
  public String content = "";
  public static final int protocolId = 6134;

  public void serialize(ICustomDataOutput param1) {
    if (this.lockDuration < 0 || this.lockDuration > 255) {
      throw new Error("Forbidden value (" + this.lockDuration + ") on element lockDuration.");
    }
    param1.writeByte(this.lockDuration);
    param1.writeUTF(this.author);
    param1.writeUTF(this.content);
  }

  public void deserialize(ICustomDataInput param1) {
    this.lockDuration = param1.readUnsignedByte();
    if (this.lockDuration < 0 || this.lockDuration > 255) {
      throw new Error(
          "Forbidden value ("
              + this.lockDuration
              + ") on element of PopupWarningMessage.lockDuration.");
    }

    this.author = param1.readUTF();

    this.content = param1.readUTF();
  }
}
