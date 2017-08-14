package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildModificationNameValidMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String guildName = "";
  public static final int protocolId = 6327;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.guildName);
  }

  public void deserialize(ICustomDataInput param1) {
    this.guildName = param1.readUTF();
  }
}
