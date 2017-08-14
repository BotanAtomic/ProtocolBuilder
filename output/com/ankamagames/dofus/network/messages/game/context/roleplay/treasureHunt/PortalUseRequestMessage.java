package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PortalUseRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int portalId = 0;
  public static final int protocolId = 6492;

  public void serialize(ICustomDataOutput param1) {
    if (this.portalId < 0) {
      throw new Error("Forbidden value (" + this.portalId + ") on element portalId.");
    }
    param1.writeVarInt(this.portalId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.portalId = param1.readInt();
  }
}
