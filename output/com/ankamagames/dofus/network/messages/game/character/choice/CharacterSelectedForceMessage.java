package com.ankamagames.dofus.network.messages.game.character.choice;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterSelectedForceMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int id = 0;
  public static final int protocolId = 6068;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 1 || this.id > 2147483647) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeInt(this.id);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();
  }
}
