package com.ankamagames.dofus.network.types.game.guild;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildMember extends CharacterMinimalInformations implements INetworkType {

  public int breed = 0;
  public boolean sex = false;
  public int rank = 0;
  public Number givenExperience = 0;
  public int experienceGivenPercent = 0;
  public int rights = 0;
  public int connected = 99;
  public int alignmentSide = 0;
  public int hoursSinceLastConnection = 0;
  public int moodSmileyId = 0;
  public int accountId = 0;
  public int achievementPoints = 0;
  public PlayerStatus status;
  public boolean havenBagShared = false;
  private FuncTree _statustree;
  public static final int protocolId = 88;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeUTF(this.name);

    if (this.level < 1 || this.level > 206) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.sex);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.havenBagShared);
    param1.writeByte(_loc2_);
    param1.writeByte(this.breed);
    if (this.rank < 0) {
      throw new Error("Forbidden value (" + this.rank + ") on element rank.");
    }
    param1.writeVarShort(this.rank);
    if (this.givenExperience < 0 || this.givenExperience > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.givenExperience + ") on element givenExperience.");
    }
    param1.writeVarLong(this.givenExperience);
    if (this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100) {
      throw new Error(
          "Forbidden value ("
              + this.experienceGivenPercent
              + ") on element experienceGivenPercent.");
    }
    param1.writeByte(this.experienceGivenPercent);
    if (this.rights < 0) {
      throw new Error("Forbidden value (" + this.rights + ") on element rights.");
    }
    param1.writeVarInt(this.rights);
    param1.writeByte(this.connected);
    param1.writeByte(this.alignmentSide);
    if (this.hoursSinceLastConnection < 0 || this.hoursSinceLastConnection > 65535) {
      throw new Error(
          "Forbidden value ("
              + this.hoursSinceLastConnection
              + ") on element hoursSinceLastConnection.");
    }
    param1.writeShort(this.hoursSinceLastConnection);
    if (this.moodSmileyId < 0) {
      throw new Error("Forbidden value (" + this.moodSmileyId + ") on element moodSmileyId.");
    }
    param1.writeVarShort(this.moodSmileyId);
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeInt(this.achievementPoints);
    param1.writeShort(this.status.getTypeId());
    this.status.serialize(param1);
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

    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.breed = param1.readByte();

    this.rank = param1.readVarUhShort();
    if (this.rank < 0) {
      throw new Error("Forbidden value (" + this.rank + ") on element of GuildMember.rank.");
    }

    this.givenExperience = param1.readVarUhLong();
    if (this.givenExperience < 0 || this.givenExperience > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.givenExperience
              + ") on element of GuildMember.givenExperience.");
    }

    this.experienceGivenPercent = param1.readByte();
    if (this.experienceGivenPercent < 0 || this.experienceGivenPercent > 100) {
      throw new Error(
          "Forbidden value ("
              + this.experienceGivenPercent
              + ") on element of GuildMember.experienceGivenPercent.");
    }

    this.rights = param1.readVarUhInt();
    if (this.rights < 0) {
      throw new Error("Forbidden value (" + this.rights + ") on element of GuildMember.rights.");
    }

    this.connected = param1.readByte();
    if (this.connected < 0) {
      throw new Error(
          "Forbidden value (" + this.connected + ") on element of GuildMember.connected.");
    }

    this.alignmentSide = param1.readByte();

    this.hoursSinceLastConnection = param1.readUnsignedShort();
    if (this.hoursSinceLastConnection < 0 || this.hoursSinceLastConnection > 65535) {
      throw new Error(
          "Forbidden value ("
              + this.hoursSinceLastConnection
              + ") on element of GuildMember.hoursSinceLastConnection.");
    }

    this.moodSmileyId = param1.readVarUhShort();
    if (this.moodSmileyId < 0) {
      throw new Error(
          "Forbidden value (" + this.moodSmileyId + ") on element of GuildMember.moodSmileyId.");
    }

    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Error(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }

    this.achievementPoints = param1.readInt();

    int _loc2_ = param1.readUnsignedShort();
    this.status = ProtocolTypeManager.getInstance(PlayerStatus, _loc2_);
    this.status.deserialize(param1);
  }
}
