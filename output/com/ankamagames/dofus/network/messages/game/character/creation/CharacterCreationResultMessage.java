package com.ankamagames.dofus.network.messages.game.character.creation;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterCreationResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int result = 1;
  public static final int protocolId = 161;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.result);
  }

  public void deserialize(ICustomDataInput param1) {
    this.result = param1.readByte();
    if (this.result < 0) {
      throw new Exception(
          "Forbidden value (" + this.result + ") on element of GuildCreationResultMessage.result.");
    }
  }
}
