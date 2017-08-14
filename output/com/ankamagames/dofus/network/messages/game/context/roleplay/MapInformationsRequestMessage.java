package com.ankamagames.dofus.network.messages.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapInformationsRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int mapId = 0;
  public static final int protocolId = 225;

  public void serialize(ICustomDataOutput param1) {
    if (this.mapId < 0) {
      throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
    }
    param1.writeInt(this.mapId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.mapId = param1.readInt();
  }
}
