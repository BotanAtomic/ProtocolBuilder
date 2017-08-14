package com.ankamagames.dofus.network.types.game.friend;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FriendSpouseInformations extends Object implements INetworkType {

  public int spouseAccountId = 0;
  public Number spouseId = 0;
  public String spouseName = "";
  public int spouseLevel = 0;
  public int breed = 0;
  public int sex = 0;
  public EntityLook spouseEntityLook;
  public GuildInformations guildInfo;
  public int alignmentSide = 0;
  private FuncTree _spouseEntityLooktree;
  private FuncTree _guildInfotree;
  public static final int protocolId = 77;

  public void serialize(ICustomDataOutput param1) {
    if (this.spouseAccountId < 0) {
      throw new Error("Forbidden value (" + this.spouseAccountId + ") on element spouseAccountId.");
    }
    param1.writeInt(this.spouseAccountId);
    if (this.spouseId < 0 || this.spouseId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.spouseId + ") on element spouseId.");
    }
    param1.writeVarLong(this.spouseId);
    param1.writeUTF(this.spouseName);
    if (this.spouseLevel < 1 || this.spouseLevel > 206) {
      throw new Error("Forbidden value (" + this.spouseLevel + ") on element spouseLevel.");
    }
    param1.writeByte(this.spouseLevel);
    param1.writeByte(this.breed);
    param1.writeByte(this.sex);
    this.spouseEntityLook.serializeAs_EntityLook(param1);
    this.guildInfo.serializeAs_GuildInformations(param1);
    param1.writeByte(this.alignmentSide);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spouseAccountId = param1.readInt();
    if (this.spouseAccountId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.spouseAccountId
              + ") on element of FriendSpouseInformations.spouseAccountId.");
    }

    this.spouseId = param1.readVarUhLong();
    if (this.spouseId < 0 || this.spouseId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.spouseId
              + ") on element of FriendSpouseInformations.spouseId.");
    }

    this.spouseName = param1.readUTF();

    this.spouseLevel = param1.readUnsignedByte();
    if (this.spouseLevel < 1 || this.spouseLevel > 206) {
      throw new Error(
          "Forbidden value ("
              + this.spouseLevel
              + ") on element of FriendSpouseInformations.spouseLevel.");
    }

    this.breed = param1.readByte();

    this.sex = param1.readBoolean();

    this.spouseEntityLook = new EntityLook();
    this.spouseEntityLook.deserialize(param1);
    this.guildInfo = new GuildInformations();
    this.guildInfo.deserialize(param1);
    this.alignmentSide = param1.readByte();
  }
}
