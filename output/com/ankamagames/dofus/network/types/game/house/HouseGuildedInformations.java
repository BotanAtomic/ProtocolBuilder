package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseGuildedInformations extends HouseInstanceInformations implements INetworkType {

  public GuildInformations guildInfo;
  private FuncTree _guildInfotree;
  public static final int protocolId = 512;

  @Override
  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.secondHand);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.isLocked);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.isSaleLocked);
    param1.writeByte(_loc2_);
    if (this.instanceId < 0) {
      throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    param1.writeUTF(this.ownerName);
    if (this.price < -9.007199254740992E15 || this.price > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.price + ") on element price.");
    }
    param1.writeVarLong(this.price);

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

    this.guildInfo = new GuildInformations();
    this.guildInfo.deserialize(param1);
  }
}
