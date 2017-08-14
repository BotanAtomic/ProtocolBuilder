package com.ankamagames.dofus.network.types.game.character.choice;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterToRemodelInformations extends CharacterRemodelingInformation
    implements INetworkType {

  public int possibleChangeMask = 0;
  public int mandatoryChangeMask = 0;
  public static final int protocolId = 477;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeUTF(this.name);
    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);
    if (this.cosmeticId < 0) {
      throw new Error("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
    }
    param1.writeVarShort(this.cosmeticId);
    param1.writeShort(this.colors.length);
    int _loc2_ = 0;
    while (_loc2_ < this.colors.length) {
      param1.writeInt(this.colors[_loc2_]);
      _loc2_++;
    }

    if (this.possibleChangeMask < 0) {
      throw new Error(
          "Forbidden value (" + this.possibleChangeMask + ") on element possibleChangeMask.");
    }
    param1.writeByte(this.possibleChangeMask);
    if (this.mandatoryChangeMask < 0) {
      throw new Error(
          "Forbidden value (" + this.mandatoryChangeMask + ") on element mandatoryChangeMask.");
    }
    param1.writeByte(this.mandatoryChangeMask);
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

    this.possibleChangeMask = param1.readByte();
    if (this.possibleChangeMask < 0) {
      throw new Error(
          "Forbidden value ("
              + this.possibleChangeMask
              + ") on element of CharacterToRemodelInformations.possibleChangeMask.");
    }

    this.mandatoryChangeMask = param1.readByte();
    if (this.mandatoryChangeMask < 0) {
      throw new Error(
          "Forbidden value ("
              + this.mandatoryChangeMask
              + ") on element of CharacterToRemodelInformations.mandatoryChangeMask.");
    }
  }
}
