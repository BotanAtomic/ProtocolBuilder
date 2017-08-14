package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterNameSuggestionSuccessMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public String suggestion = "";
  public static final int protocolId = 5544;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.suggestion);
  }

  public void deserialize(ICustomDataInput param1) {
    this.suggestion = param1.readUTF();
  }
}
