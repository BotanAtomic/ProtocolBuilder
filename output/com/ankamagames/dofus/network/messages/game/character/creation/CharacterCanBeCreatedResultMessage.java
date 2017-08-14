package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterCanBeCreatedResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean yesYouCan = false;
  public static final int protocolId = 6733;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.yesYouCan);
  }

  public void deserialize(ICustomDataInput param1) {
    this.yesYouCan = param1.readBoolean();
  }
}
