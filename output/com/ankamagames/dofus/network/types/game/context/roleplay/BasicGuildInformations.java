package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicGuildInformations extends AbstractSocialGroupInfos implements INetworkType {

  public int guildId = 0;
  public String guildName = "";
  public int guildLevel = 0;
  public static final int protocolId = 365;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.guildId < 0) {
      throw new Error("Forbidden value (" + this.guildId + ") on element guildId.");
    }
    param1.writeVarInt(this.guildId);
    param1.writeUTF(this.guildName);
    if (this.guildLevel < 0 || this.guildLevel > 200) {
      throw new Error("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
    }
    param1.writeByte(this.guildLevel);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.guildId = param1.readVarUhInt();
    if (this.guildId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.guildId
              + ") on element of GuildVersatileInformations.guildId.");
    }

    this.guildName = param1.readUTF();

    this.guildLevel = param1.readUnsignedByte();
    if (this.guildLevel < 1 || this.guildLevel > 200) {
      throw new Error(
          "Forbidden value ("
              + this.guildLevel
              + ") on element of GuildVersatileInformations.guildLevel.");
    }
  }
}
