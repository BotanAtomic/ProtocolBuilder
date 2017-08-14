package com.ankamagames.dofus.network.types.game.social;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceVersatileInformations extends Object implements INetworkType {

  public int allianceId = 0;
  public int nbGuilds = 0;
  public int nbMembers = 0;
  public int nbSubarea = 0;
  public static final int protocolId = 432;

  public void serialize(ICustomDataOutput param1) {
    if (this.allianceId < 0) {
      throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);
    if (this.nbGuilds < 0) {
      throw new Exception("Forbidden value (" + this.nbGuilds + ") on element nbGuilds.");
    }
    param1.writeVarShort(this.nbGuilds);
    if (this.nbMembers < 0) {
      throw new Exception("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
    }
    param1.writeVarShort(this.nbMembers);
    if (this.nbSubarea < 0) {
      throw new Exception("Forbidden value (" + this.nbSubarea + ") on element nbSubarea.");
    }
    param1.writeVarShort(this.nbSubarea);
  }

  public void deserialize(ICustomDataInput param1) {
    this.allianceId = param1.readVarUhInt();
    if (this.allianceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.allianceId
              + ") on element of GuildInAllianceVersatileInformations.allianceId.");
    }

    this.nbGuilds = param1.readVarUhShort();
    if (this.nbGuilds < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbGuilds
              + ") on element of AllianceVersatileInformations.nbGuilds.");
    }

    this.nbMembers = param1.readUnsignedByte();
    if (this.nbMembers < 1 || this.nbMembers > 240) {
      throw new Exception(
          "Forbidden value ("
              + this.nbMembers
              + ") on element of GuildVersatileInformations.nbMembers.");
    }

    this.nbSubarea = param1.readVarUhShort();
    if (this.nbSubarea < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbSubarea
              + ") on element of AllianceVersatileInformations.nbSubarea.");
    }
  }
}
