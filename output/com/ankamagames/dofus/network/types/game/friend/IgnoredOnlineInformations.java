package com.ankamagames.dofus.network.types.game.friend;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;

public class IgnoredOnlineInformations extends IgnoredInformations implements INetworkType {

  public Number playerId = 0;
  public String playerName = "";
  public int breed = 0;
  public boolean sex = false;
  public static final int protocolId = 105;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeUTF(this.accountName);

    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    param1.writeUTF(this.playerName);
    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);
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

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.playerName = param1.readUTF();

    this.breed = param1.readByte();

    this.sex = param1.readBoolean();
  }
}
