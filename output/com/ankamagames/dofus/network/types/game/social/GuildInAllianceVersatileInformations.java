package com.ankamagames.dofus.network.types.game.social;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInAllianceVersatileInformations extends GuildVersatileInformations
    implements INetworkType {

  public int allianceId = 0;
  public static final int protocolId = 437;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.guildId < 0) {
      throw new Error("Forbidden value (" + this.guildId + ") on element guildId.");
    }
    param1.writeVarInt(this.guildId);
    if (this.leaderId < 0 || this.leaderId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.leaderId + ") on element leaderId.");
    }
    param1.writeVarLong(this.leaderId);
    if (this.guildLevel < 1 || this.guildLevel > 200) {
      throw new Error("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
    }
    param1.writeByte(this.guildLevel);
    if (this.nbMembers < 1 || this.nbMembers > 240) {
      throw new Error("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
    }
    param1.writeByte(this.nbMembers);

    if (this.allianceId < 0) {
      throw new Error("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);
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

    this.allianceId = param1.readVarUhInt();
    if (this.allianceId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.allianceId
              + ") on element of GuildInAllianceVersatileInformations.allianceId.");
    }
  }
}
