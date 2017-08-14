package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;

public class DungeonPartyFinderPlayer extends Object implements INetworkType {

  public Number playerId = 0;
  public String playerName = "";
  public int breed = 0;
  public boolean sex = false;
  public int level = 0;
  public static final int protocolId = 373;

  public void serialize(ICustomDataOutput param1) {
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    param1.writeUTF(this.playerName);
    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);
    if (this.level < 0 || this.level > 255) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
  }

  public void deserialize(ICustomDataInput param1) {
    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.playerName = param1.readUTF();

    this.breed = param1.readByte();

    this.sex = param1.readBoolean();

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }
  }
}
