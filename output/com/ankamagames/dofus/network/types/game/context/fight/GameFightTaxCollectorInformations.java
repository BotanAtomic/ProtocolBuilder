package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightTaxCollectorInformations extends GameFightAIInformations
    implements INetworkType {

  public int firstNameId = 0;
  public int lastNameId = 0;
  public int level = 0;
  public static final int protocolId = 48;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    param1.writeByte(this.teamId);
    if (this.wave < 0) {
      throw new Error("Forbidden value (" + this.wave + ") on element wave.");
    }
    param1.writeByte(this.wave);
    param1.writeBoolean(this.alive);
    param1.writeShort(this.stats.getTypeId());
    this.stats.serialize(param1);
    param1.writeShort(this.previousPositions.length);
    int _loc2_ = 0;
    while (_loc2_ < this.previousPositions.length) {
      if (this.previousPositions[_loc2_] < 0 || this.previousPositions[_loc2_] > 559) {
        throw new Error(
            "Forbidden value ("
                + this.previousPositions[_loc2_]
                + ") on element 5 (starting at 1) of previousPositions.");
      }
      param1.writeVarShort(this.previousPositions[_loc2_]);
      _loc2_++;
    }

    if (this.firstNameId < 0) {
      throw new Error("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
    }
    param1.writeVarShort(this.firstNameId);
    if (this.lastNameId < 0) {
      throw new Error("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
    }
    param1.writeVarShort(this.lastNameId);
    if (this.level < 0 || this.level > 255) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
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

    this.firstNameId = param1.readVarUhShort();
    if (this.firstNameId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.firstNameId
              + ") on element of TaxCollectorBasicInformations.firstNameId.");
    }

    this.lastNameId = param1.readVarUhShort();
    if (this.lastNameId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.lastNameId
              + ") on element of TaxCollectorInformations.lastNameId.");
    }

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }
  }
}
