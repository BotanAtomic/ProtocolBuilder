package com.ankamagames.dofus.network.types.game.friend;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;

public class FriendOnlineInformations extends FriendInformations implements INetworkType {

  public Number playerId = 0;
  public String playerName = "";
  public int level = 0;
  public int alignmentSide = 0;
  public int breed = 0;
  public boolean sex = false;
  public GuildInformations guildInfo;
  public int moodSmileyId = 0;
  public PlayerStatus status;
  public boolean havenBagShared = false;
  private FuncTree _guildInfotree;
  private FuncTree _statustree;
  public static final int protocolId = 92;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.accountId < 0) {
      throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeUTF(this.accountName);

    param1.writeByte(this.playerState);
    if (this.lastConnection < 0) {
      throw new Exception(
          "Forbidden value (" + this.lastConnection + ") on element lastConnection.");
    }
    param1.writeVarShort(this.lastConnection);
    param1.writeInt(this.achievementPoints);

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.sex);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.havenBagShared);
    param1.writeByte(_loc2_);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    param1.writeUTF(this.playerName);
    if (this.level < 0 || this.level > 206) {
      throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
    param1.writeByte(this.alignmentSide);
    param1.writeByte(this.breed);
    this.guildInfo.serializeAs_GuildInformations(param1);
    if (this.moodSmileyId < 0) {
      throw new Exception("Forbidden value (" + this.moodSmileyId + ") on element moodSmileyId.");
    }
    param1.writeVarShort(this.moodSmileyId);
    param1.writeShort(this.status.getTypeId());
    this.status.serialize(param1);
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

    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.playerName = param1.readUTF();

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Exception(
          "Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.alignmentSide = param1.readByte();

    this.breed = param1.readByte();

    this.guildInfo = new GuildInformations();
    this.guildInfo.deserialize(param1);
    this.moodSmileyId = param1.readVarUhShort();
    if (this.moodSmileyId < 0) {
      throw new Exception(
          "Forbidden value (" + this.moodSmileyId + ") on element of GuildMember.moodSmileyId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    this.status = ProtocolTypeManager.getInstance(PlayerStatus, _loc2_);
    this.status.deserialize(param1);
  }
}
