package com.ankamagames.dofus.network.types.game.character.choice;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterHardcoreOrEpicInformations extends CharacterBaseInformations
    implements INetworkType {

  public int deathState = 0;
  public int deathCount = 0;
  public int deathMaxLevel = 0;
  public static final int protocolId = 474;

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

    this.entityLook.serializeAs_EntityLook(param1);

    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);

    param1.writeByte(this.deathState);
    if (this.deathCount < 0) {
      throw new Error("Forbidden value (" + this.deathCount + ") on element deathCount.");
    }
    param1.writeVarShort(this.deathCount);
    if (this.deathMaxLevel < 1 || this.deathMaxLevel > 206) {
      throw new Error("Forbidden value (" + this.deathMaxLevel + ") on element deathMaxLevel.");
    }
    param1.writeByte(this.deathMaxLevel);
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

    this.deathState = param1.readByte();
    if (this.deathState < 0) {
      throw new Error(
          "Forbidden value ("
              + this.deathState
              + ") on element of CharacterHardcoreOrEpicInformations.deathState.");
    }

    this.deathCount = param1.readVarUhShort();
    if (this.deathCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.deathCount
              + ") on element of CharacterHardcoreOrEpicInformations.deathCount.");
    }

    this.deathMaxLevel = param1.readUnsignedByte();
    if (this.deathMaxLevel < 1 || this.deathMaxLevel > 206) {
      throw new Error(
          "Forbidden value ("
              + this.deathMaxLevel
              + ") on element of CharacterHardcoreOrEpicInformations.deathMaxLevel.");
    }
  }
}
