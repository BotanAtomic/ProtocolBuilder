package com.ankamagames.dofus.network.types.game.social;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInsiderFactSheetInformations extends GuildFactSheetInformations
    implements INetworkType {

  public String leaderName = "";
  public int nbConnectedMembers = 0;
  public int nbTaxCollectors = 0;
  public int lastActivity = 0;
  public static final int protocolId = 423;

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

    param1.writeUTF(this.leaderName);
    if (this.nbConnectedMembers < 0) {
      throw new Exception(
          "Forbidden value (" + this.nbConnectedMembers + ") on element nbConnectedMembers.");
    }
    param1.writeVarShort(this.nbConnectedMembers);
    if (this.nbTaxCollectors < 0) {
      throw new Exception(
          "Forbidden value (" + this.nbTaxCollectors + ") on element nbTaxCollectors.");
    }
    param1.writeByte(this.nbTaxCollectors);
    if (this.lastActivity < 0) {
      throw new Exception("Forbidden value (" + this.lastActivity + ") on element lastActivity.");
    }
    param1.writeInt(this.lastActivity);
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

    this.leaderName = param1.readUTF();

    this.nbConnectedMembers = param1.readVarUhShort();
    if (this.nbConnectedMembers < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbConnectedMembers
              + ") on element of GuildInsiderFactSheetInformations.nbConnectedMembers.");
    }

    this.nbTaxCollectors = param1.readByte();
    if (this.nbTaxCollectors < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbTaxCollectors
              + ") on element of GuildInsiderFactSheetInformations.nbTaxCollectors.");
    }

    this.lastActivity = param1.readInt();
    if (this.lastActivity < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.lastActivity
              + ") on element of GuildInsiderFactSheetInformations.lastActivity.");
    }
  }
}
