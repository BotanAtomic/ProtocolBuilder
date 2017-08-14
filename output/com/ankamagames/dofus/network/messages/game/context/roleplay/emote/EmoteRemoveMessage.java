package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EmoteRemoveMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int emoteId = 0;
  public static final int protocolId = 5687;

  public void serialize(ICustomDataOutput param1) {
    if (this.emoteId < 0 || this.emoteId > 255) {
      throw new Exception("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }
    param1.writeByte(this.emoteId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.emoteId = param1.readUnsignedByte();
    if (this.emoteId < 0 || this.emoteId > 255) {
      throw new Exception(
          "Forbidden value (" + this.emoteId + ") on element of ShortcutEmote.emoteId.");
    }
  }
}
