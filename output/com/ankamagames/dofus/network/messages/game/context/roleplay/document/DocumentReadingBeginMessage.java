package com.ankamagames.dofus.network.messages.game.context.roleplay.document;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DocumentReadingBeginMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int documentId = 0;
  public static final int protocolId = 5675;

  public void serialize(ICustomDataOutput param1) {
    if (this.documentId < 0) {
      throw new Error("Forbidden value (" + this.documentId + ") on element documentId.");
    }
    param1.writeVarShort(this.documentId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.documentId = param1.readVarUhShort();
    if (this.documentId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.documentId
              + ") on element of DocumentReadingBeginMessage.documentId.");
    }
  }
}
