package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildPaddockTeleportRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int paddockId = 0;
  public static final int protocolId = 5957;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.paddockId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.paddockId = param1.readInt();
  }
}
