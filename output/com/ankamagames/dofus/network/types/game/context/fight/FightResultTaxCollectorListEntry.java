package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightResultTaxCollectorListEntry extends FightResultFighterListEntry
    implements INetworkType {

  public int level = 0;
  public BasicGuildInformations guildInfo;
  public int experienceForGuild = 0;
  private FuncTree _guildInfotree;
  public static final int protocolId = 84;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeVarShort(this.outcome);
    if (this.wave < 0) {
      throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
    }
    param1.writeByte(this.wave);
    this.rewards.serializeAs_FightLoot(param1);

    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    param1.writeBoolean(this.alive);

    if (this.level < 1 || this.level > 200) {
      throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
    this.guildInfo.serializeAs_BasicGuildInformations(param1);
    param1.writeInt(this.experienceForGuild);
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

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Exception(
          "Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.guildInfo = new BasicGuildInformations();
    this.guildInfo.deserialize(param1);
    this.experienceForGuild = param1.readInt();
  }
}
