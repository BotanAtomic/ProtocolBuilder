package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildFightJoinRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int taxCollectorId = 0;
  public static final int protocolId = 5717;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.taxCollectorId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.taxCollectorId = param1.readInt();
  }
}
