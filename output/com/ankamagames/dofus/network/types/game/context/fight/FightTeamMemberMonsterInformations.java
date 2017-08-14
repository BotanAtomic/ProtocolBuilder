package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamMemberMonsterInformations extends FightTeamMemberInformations
    implements INetworkType {

  public int monsterId = 0;
  public int grade = 0;
  public static final int protocolId = 6;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);

    param1.writeInt(this.monsterId);
    if (this.grade < 0) {
      throw new Error("Forbidden value (" + this.grade + ") on element grade.");
    }
    param1.writeByte(this.grade);
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

    this.monsterId = param1.readVarUhShort();
    if (this.monsterId < 0) {
      throw new Error(
          "Forbidden value (" + this.monsterId + ") on element of DareReward.monsterId.");
    }

    this.grade = param1.readByte();
    if (this.grade < 0) {
      throw new Error(
          "Forbidden value ("
              + this.grade
              + ") on element of MonsterInGroupLightInformations.grade.");
    }
  }
}
