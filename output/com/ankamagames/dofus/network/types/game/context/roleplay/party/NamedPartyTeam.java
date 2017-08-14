package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NamedPartyTeam extends Object implements INetworkType {

  public int teamId = 2;
  public String partyName = "";
  public static final int protocolId = 469;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.teamId);
    param1.writeUTF(this.partyName);
  }

  public void deserialize(ICustomDataInput param1) {
    this.teamId = param1.readByte();
    if (this.teamId < 0) {
      throw new Exception(
          "Forbidden value (" + this.teamId + ") on element of NamedPartyTeam.teamId.");
    }

    this.partyName = param1.readUTF();
  }
}
