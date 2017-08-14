package com.ankamagames.dofus.network.types.game.character;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterMinimalPlusLookAndGradeInformations
    extends CharacterMinimalPlusLookInformations implements INetworkType {

  public int grade = 0;
  public static final int protocolId = 193;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeUTF(this.name);

    if (this.level < 1 || this.level > 206) {
      throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);

    this.entityLook.serializeAs_EntityLook(param1);

    if (this.grade < 0) {
      throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
    }
    param1.writeVarInt(this.grade);
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

    this.grade = param1.readByte();
    if (this.grade < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.grade
              + ") on element of MonsterInGroupLightInformations.grade.");
    }
  }
}
