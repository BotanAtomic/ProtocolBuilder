package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamMemberCompanionInformations extends FightTeamMemberInformations
    implements INetworkType {

  public int companionId = 0;
  public int level = 0;
  public Number masterId = 0;
  public static final int protocolId = 451;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);

    if (this.companionId < 0) {
      throw new Error("Forbidden value (" + this.companionId + ") on element companionId.");
    }
    param1.writeByte(this.companionId);
    if (this.level < 1 || this.level > 200) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
    if (this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.masterId + ") on element masterId.");
    }
    param1.writeDouble(this.masterId);
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

    this.companionId = param1.readByte();
    if (this.companionId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.companionId
              + ") on element of GameFightFighterCompanionLightInformations.companionId.");
    }

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.masterId = param1.readDouble();
    if (this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.masterId
              + ") on element of GameFightFighterCompanionLightInformations.masterId.");
    }
  }
}
