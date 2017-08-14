package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceModificationValidMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String allianceName = "";
  public String allianceTag = "";
  public GuildEmblem Alliancemblem;
  private FuncTree _Alliancemblemtree;
  public static final int protocolId = 6450;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.allianceName);
    param1.writeUTF(this.allianceTag);
    this.Alliancemblem.serializeAs_GuildEmblem(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.allianceName = param1.readUTF();

    this.allianceTag = param1.readUTF();

    this.Alliancemblem = new GuildEmblem();
    this.Alliancemblem.deserialize(param1);
  }
}
