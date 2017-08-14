package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlliancedGuildFactSheetInformations extends GuildInformations implements INetworkType {

  public BasicNamedAllianceInformations allianceInfos;
  private FuncTree _allianceInfostree;
  public static final int protocolId = 422;

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

    this.guildEmblem.serializeAs_GuildEmblem(param1);

    this.allianceInfos.serializeAs_BasicNamedAllianceInformations(param1);
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

    this.allianceInfos = new BasicNamedAllianceInformations();
    this.allianceInfos.deserialize(param1);
  }
}
