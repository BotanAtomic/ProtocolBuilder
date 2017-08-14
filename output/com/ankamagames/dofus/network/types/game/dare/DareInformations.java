package com.ankamagames.dofus.network.types.game.dare;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.CharacterBasicMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareInformations extends Object implements INetworkType {

  public Number dareId = 0;
  public CharacterBasicMinimalInformations creator;
  public Number subscriptionFee = 0;
  public Number jackpot = 0;
  public int maxCountWinners = 0;
  public Number endDate = 0;
  public boolean isPrivate = false;
  public int guildId = 0;
  public int allianceId = 0;
  public Vector<DareCriteria> criterions;
  public Number startDate = 0;
  private FuncTree _creatortree;
  private FuncTree _criterionstree;
  public static final int protocolId = 502;

  public void serialize(ICustomDataOutput param1) {
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
    }
    param1.writeDouble(this.dareId);
    this.creator.serializeAs_CharacterBasicMinimalInformations(param1);
    if (this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.subscriptionFee + ") on element subscriptionFee.");
    }
    param1.writeVarLong(this.subscriptionFee);
    if (this.jackpot < 0 || this.jackpot > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.jackpot + ") on element jackpot.");
    }
    param1.writeVarLong(this.jackpot);
    if (this.maxCountWinners < 0 || this.maxCountWinners > 65535) {
      throw new Exception(
          "Forbidden value (" + this.maxCountWinners + ") on element maxCountWinners.");
    }
    param1.writeShort(this.maxCountWinners);
    if (this.endDate < 0 || this.endDate > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.endDate + ") on element endDate.");
    }
    param1.writeDouble(this.endDate);
    param1.writeBoolean(this.isPrivate);
    if (this.guildId < 0) {
      throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
    }
    param1.writeVarInt(this.guildId);
    if (this.allianceId < 0) {
      throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);
    param1.writeShort(this.criterions.length);
    int _loc2_ = 0;
    while (_loc2_ < this.criterions.length) {
      ((DareCriteria) this.criterions[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    if (this.startDate < 0 || this.startDate > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.startDate + ") on element startDate.");
    }
    param1.writeDouble(this.startDate);
  }

  public void deserialize(ICustomDataInput param1) {
    DareCriteria _loc4_ = null;
    this.dareId = param1.readDouble();
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.dareId + ") on element of DareVersatileInformations.dareId.");
    }

    this.creator = new CharacterBasicMinimalInformations();
    this.creator.deserialize(param1);
    this.subscriptionFee = param1.readVarUhLong();
    if (this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.subscriptionFee
              + ") on element of DareInformations.subscriptionFee.");
    }

    this.jackpot = param1.readVarUhLong();
    if (this.jackpot < 0 || this.jackpot > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.jackpot + ") on element of DareInformations.jackpot.");
    }

    this.maxCountWinners = param1.readUnsignedShort();
    if (this.maxCountWinners < 0 || this.maxCountWinners > 65535) {
      throw new Exception(
          "Forbidden value ("
              + this.maxCountWinners
              + ") on element of DareInformations.maxCountWinners.");
    }

    this.endDate = param1.readDouble();
    if (this.endDate < 0 || this.endDate > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.endDate + ") on element of DareInformations.endDate.");
    }

    this.isPrivate = param1.readBoolean();

    this.guildId = param1.readVarUhInt();
    if (this.guildId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.guildId
              + ") on element of GuildVersatileInformations.guildId.");
    }

    this.allianceId = param1.readVarUhInt();
    if (this.allianceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.allianceId
              + ") on element of GuildInAllianceVersatileInformations.allianceId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new DareCriteria();
      _loc4_.deserialize(param1);
      this.criterions.push(_loc4_);
      _loc3_++;
    }
    this.startDate = param1.readDouble();
    if (this.startDate < 0 || this.startDate > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.startDate + ") on element of DareInformations.startDate.");
    }
  }
}
