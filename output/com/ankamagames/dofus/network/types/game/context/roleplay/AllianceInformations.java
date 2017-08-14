package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceInformations extends BasicNamedAllianceInformations implements INetworkType {

  public GuildEmblem allianceEmblem;
  private FuncTree _allianceEmblemtree;
  public static final int protocolId = 417;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.allianceId < 0) {
      throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);
    param1.writeUTF(this.allianceTag);

    param1.writeUTF(this.allianceName);

    this.allianceEmblem.serializeAs_GuildEmblem(param1);
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

    this.allianceEmblem = new GuildEmblem();
    this.allianceEmblem.deserialize(param1);
  }
}
