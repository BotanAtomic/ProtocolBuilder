package com.ankamagames.dofus.network.messages.game.chat.smiley;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MoodSmileyRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int smileyId = 0;
  public static final int protocolId = 6192;

  public void serialize(ICustomDataOutput param1) {
    if (this.smileyId < 0) {
      throw new Exception("Forbidden value (" + this.smileyId + ") on element smileyId.");
    }
    param1.writeVarShort(this.smileyId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.smileyId = param1.readVarUhShort();
    if (this.smileyId < 0) {
      throw new Exception(
          "Forbidden value (" + this.smileyId + ") on element of ShortcutSmiley.smileyId.");
    }
  }
}
