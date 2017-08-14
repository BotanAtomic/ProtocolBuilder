package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockGuildedInformations extends PaddockBuyableInformations implements INetworkType {

  public boolean deserted = false;
  public GuildInformations guildInfo;
  private FuncTree _guildInfotree;
  public static final int protocolId = 508;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.price < 0 || this.price > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.price + ") on element price.");
    }
    param1.writeVarLong(this.price);
    param1.writeBoolean(this.locked);

    param1.writeBoolean(this.deserted);
    this.guildInfo.serializeAs_GuildInformations(param1);
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

    this.deserted = param1.readBoolean();

    this.guildInfo = new GuildInformations();
    this.guildInfo.deserialize(param1);
  }
}
