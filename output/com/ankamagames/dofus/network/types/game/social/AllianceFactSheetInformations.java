package com.ankamagames.dofus.network.types.game.social;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceFactSheetInformations extends AllianceInformations implements INetworkType {

  public int creationDate = 0;
  public static final int protocolId = 421;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.allianceId < 0) {
      throw new Error("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);
    param1.writeUTF(this.allianceTag);

    param1.writeUTF(this.allianceName);

    this.allianceEmblem.serializeAs_GuildEmblem(param1);

    if (this.creationDate < 0) {
      throw new Error("Forbidden value (" + this.creationDate + ") on element creationDate.");
    }
    param1.writeInt(this.creationDate);
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

    this.creationDate = param1.readInt();
    if (this.creationDate < 0) {
      throw new Error(
          "Forbidden value ("
              + this.creationDate
              + ") on element of AllianceFactSheetInformations.creationDate.");
    }
  }
}
