package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceModificationEmblemValidMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public GuildEmblem Alliancemblem;
  private FuncTree _Alliancemblemtree;
  public static final int protocolId = 6447;

  public void serialize(ICustomDataOutput param1) {
    this.Alliancemblem.serializeAs_GuildEmblem(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.Alliancemblem = new GuildEmblem();
    this.Alliancemblem.deserialize(param1);
  }
}
