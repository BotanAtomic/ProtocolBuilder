package com.ankamagames.dofus.network.types.game.social;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildFactSheetInformations extends GuildInformations implements INetworkType {

  public Number leaderId = 0;
  public int nbMembers = 0;
  public static final int protocolId = 424;

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

    if (this.leaderId < 0 || this.leaderId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
    }
    param1.writeVarLong(this.leaderId);
    if (this.nbMembers < 0) {
      throw new Exception("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
    }
    param1.writeVarShort(this.nbMembers);
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

    this.leaderId = param1.readVarUhLong();
    if (this.leaderId < 0 || this.leaderId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.leaderId
              + ") on element of GuildVersatileInformations.leaderId.");
    }

    this.nbMembers = param1.readUnsignedByte();
    if (this.nbMembers < 1 || this.nbMembers > 240) {
      throw new Exception(
          "Forbidden value ("
              + this.nbMembers
              + ") on element of GuildVersatileInformations.nbMembers.");
    }
  }
}
