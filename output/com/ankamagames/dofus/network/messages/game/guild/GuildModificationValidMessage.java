package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildModificationValidMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String guildName = "";
  public GuildEmblem guildEmblem;
  private FuncTree _guildEmblemtree;
  public static final int protocolId = 6323;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.guildName);
    this.guildEmblem.serializeAs_GuildEmblem(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.guildName = param1.readUTF();

    this.guildEmblem = new GuildEmblem();
    this.guildEmblem.deserialize(param1);
  }
}
