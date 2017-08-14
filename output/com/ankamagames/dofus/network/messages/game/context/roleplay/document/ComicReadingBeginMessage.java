package com.ankamagames.dofus.network.messages.game.context.roleplay.document;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ComicReadingBeginMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int comicId = 0;
  public static final int protocolId = 6536;

  public void serialize(ICustomDataOutput param1) {
    if (this.comicId < 0) {
      throw new Error("Forbidden value (" + this.comicId + ") on element comicId.");
    }
    param1.writeVarShort(this.comicId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.comicId = param1.readVarUhShort();
    if (this.comicId < 0) {
      throw new Error(
          "Forbidden value (" + this.comicId + ") on element of ComicReadingBeginMessage.comicId.");
    }
  }
}
