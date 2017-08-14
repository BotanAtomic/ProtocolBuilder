package com.ankamagames.dofus.network.messages.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapFightCountMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightCount = 0;
  public static final int protocolId = 210;

  public void serialize(ICustomDataOutput param1) {
    if (this.fightCount < 0) {
      throw new Error("Forbidden value (" + this.fightCount + ") on element fightCount.");
    }
    param1.writeVarShort(this.fightCount);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightCount = param1.readVarUhShort();
    if (this.fightCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.fightCount
              + ") on element of MapFightCountMessage.fightCount.");
    }
  }
}
