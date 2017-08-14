package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamLightInformations extends AbstractFightTeamInformations
    implements INetworkType {

  public int teamMembersCount = 0;
  public int meanLevel = 0;
  public boolean hasFriend = false;
  public boolean hasGuildMember = false;
  public boolean hasAllianceMember = false;
  public boolean hasGroupMember = false;
  public boolean hasMyTaxCollector = false;
  public static final int protocolId = 115;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.teamId);
    if (this.leaderId < -9.007199254740992E15 || this.leaderId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.leaderId + ") on element leaderId.");
    }
    param1.writeDouble(this.leaderId);
    param1.writeByte(this.teamSide);
    param1.writeByte(this.teamTypeId);
    if (this.nbWaves < 0) {
      throw new Error("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
    }
    param1.writeByte(this.nbWaves);

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.hasFriend);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.hasGuildMember);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.hasAllianceMember);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 3, this.hasGroupMember);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 4, this.hasMyTaxCollector);
    param1.writeByte(_loc2_);
    if (this.teamMembersCount < 0) {
      throw new Error(
          "Forbidden value (" + this.teamMembersCount + ") on element teamMembersCount.");
    }
    param1.writeByte(this.teamMembersCount);
    if (this.meanLevel < 0) {
      throw new Error("Forbidden value (" + this.meanLevel + ") on element meanLevel.");
    }
    param1.writeVarInt(this.meanLevel);
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

    this.teamMembersCount = param1.readByte();
    if (this.teamMembersCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.teamMembersCount
              + ") on element of FightTeamLightInformations.teamMembersCount.");
    }

    this.meanLevel = param1.readVarUhInt();
    if (this.meanLevel < 0) {
      throw new Error(
          "Forbidden value ("
              + this.meanLevel
              + ") on element of FightTeamLightInformations.meanLevel.");
    }
  }
}
