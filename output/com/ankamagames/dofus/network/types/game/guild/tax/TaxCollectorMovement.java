package com.ankamagames.dofus.network.types.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorMovement extends Object implements INetworkType {

  public int movementType = 0;
  public TaxCollectorBasicInformations basicInfos;
  public Number playerId = 0;
  public String playerName = "";
  private FuncTree _basicInfostree;
  public static final int protocolId = 493;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.movementType);
    this.basicInfos.serializeAs_TaxCollectorBasicInformations(param1);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    param1.writeUTF(this.playerName);
  }

  public void deserialize(ICustomDataInput param1) {
    this.movementType = param1.readByte();
    if (this.movementType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.movementType
              + ") on element of TaxCollectorMovement.movementType.");
    }

    this.basicInfos = new TaxCollectorBasicInformations();
    this.basicInfos.deserialize(param1);
    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.playerName = param1.readUTF();
  }
}
