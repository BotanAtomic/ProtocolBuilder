package com.ankamagames.dofus.network.messages.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildChangeMemberParametersMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number memberId = 0;
  public int rank = 0;
  public int experienceGivenPercent = 0;
  public int rights = 0;
  public static final int protocolId = 5549;

  public void serialize(ICustomDataOutput param1) {
    if (this.memberId < 0 || this.memberId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
    }
    param1.writeVarLong(this.memberId);
    if (this.rank < 0) {
      throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
    }
    param1.writeVarShort(this.rank);
    if (this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100) {
      throw new Exception(
          "Forbidden value ("
              + this.experienceGivenPercent
              + ") on element experienceGivenPercent.");
    }
    param1.writeByte(this.experienceGivenPercent);
    if (this.rights < 0) {
      throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
    }
    param1.writeVarInt(this.rights);
  }

  public void deserialize(ICustomDataInput param1) {
    this.memberId = param1.readInt();
    if (this.memberId < 0) {
      throw new Exception(
          "Forbidden value (" + this.memberId + ") on element of PartyMemberGeoPosition.memberId.");
    }

    this.rank = param1.readVarUhShort();
    if (this.rank < 0) {
      throw new Exception("Forbidden value (" + this.rank + ") on element of GuildMember.rank.");
    }

    this.experienceGivenPercent = param1.readByte();
    if (this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100) {
      throw new Exception(
          "Forbidden value ("
              + this.experienceGivenPercent
              + ") on element of GuildMember.experienceGivenPercent.");
    }

    this.rights = param1.readVarUhInt();
    if (this.rights < 0) {
      throw new Exception(
          "Forbidden value (" + this.rights + ") on element of GuildMember.rights.");
    }
  }
}
