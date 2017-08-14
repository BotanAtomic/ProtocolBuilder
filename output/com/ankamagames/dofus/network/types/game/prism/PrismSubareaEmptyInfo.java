package com.ankamagames.dofus.network.types.game.prism;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismSubareaEmptyInfo extends Object implements INetworkType {

  public int subAreaId = 0;
  public int allianceId = 0;
  public static final int protocolId = 438;

  public void serialize(ICustomDataOutput param1) {
    if (this.subAreaId < 0) {
      throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
    }
    param1.writeVarShort(this.subAreaId);
    if (this.allianceId < 0) {
      throw new Error("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.subAreaId = param1.readVarUhShort();
    if (this.subAreaId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.subAreaId
              + ") on element of PrismSubareaEmptyInfo.subAreaId.");
    }

    this.allianceId = param1.readVarUhInt();
    if (this.allianceId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.allianceId
              + ") on element of GuildInAllianceVersatileInformations.allianceId.");
    }
  }
}
