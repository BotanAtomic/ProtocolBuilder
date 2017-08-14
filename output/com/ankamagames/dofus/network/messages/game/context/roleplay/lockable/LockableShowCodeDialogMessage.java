package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LockableShowCodeDialogMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean changeOrUse = false;
  public int codeSize = 0;
  public static final int protocolId = 5740;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.changeOrUse);
    if (this.codeSize < 0) {
      throw new Error("Forbidden value (" + this.codeSize + ") on element codeSize.");
    }
    param1.writeByte(this.codeSize);
  }

  public void deserialize(ICustomDataInput param1) {
    this.changeOrUse = param1.readBoolean();

    this.codeSize = param1.readByte();
    if (this.codeSize < 0) {
      throw new Error(
          "Forbidden value ("
              + this.codeSize
              + ") on element of LockableShowCodeDialogMessage.codeSize.");
    }
  }
}
