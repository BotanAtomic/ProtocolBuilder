package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamMemberTaxCollectorInformations extends FightTeamMemberInformations
    implements INetworkType {

  public int firstNameId = 0;
  public int lastNameId = 0;
  public int level = 0;
  public int guildId = 0;
  public int uid = 0;
  public static final int protocolId = 177;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);

    if (this.firstNameId < 0) {
      throw new Error("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
    }
    param1.writeVarShort(this.firstNameId);
    if (this.lastNameId < 0) {
      throw new Error("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
    }
    param1.writeVarShort(this.lastNameId);
    if (this.level < 1 || this.level > 200) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
    if (this.guildId < 0) {
      throw new Error("Forbidden value (" + this.guildId + ") on element guildId.");
    }
    param1.writeVarInt(this.guildId);
    if (this.uid < 0) {
      throw new Error("Forbidden value (" + this.uid + ") on element uid.");
    }
    param1.writeVarInt(this.uid);
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

    this.firstNameId = param1.readVarUhShort();
    if (this.firstNameId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.firstNameId
              + ") on element of TaxCollectorBasicInformations.firstNameId.");
    }

    this.lastNameId = param1.readVarUhShort();
    if (this.lastNameId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastNameId
              + ") on element of TaxCollectorInformations.lastNameId.");
    }

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.guildId = param1.readVarUhInt();
    if (this.guildId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.guildId
              + ") on element of GuildVersatileInformations.guildId.");
    }

    this.uid = param1.readUTF();
  }
}
