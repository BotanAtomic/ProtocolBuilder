package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInformations extends BasicGuildInformations implements INetworkType {

  public GuildEmblem guildEmblem;
  private FuncTree _guildEmblemtree;
  public static final int protocolId = 127;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.guildId < 0) {
      throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
    }
    param1.writeVarInt(this.guildId);
    param1.writeUTF(this.guildName);
    if (this.guildLevel < 0 || this.guildLevel > 200) {
      throw new Exception("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
    }
    param1.writeByte(this.guildLevel);

    this.guildEmblem.serializeAs_GuildEmblem(param1);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.guildEmblem = new GuildEmblem();
    this.guildEmblem.deserialize(param1);
  }
}
