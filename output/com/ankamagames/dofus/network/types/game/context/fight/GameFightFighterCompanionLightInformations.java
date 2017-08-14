package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightFighterCompanionLightInformations extends GameFightFighterLightInformations
    implements INetworkType {

  public int companionId = 0;
  public Number masterId = 0;
  public static final int protocolId = 454;

  @Override
  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.sex);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.alive);
    param1.writeByte(_loc2_);
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    if (this.wave < 0) {
      throw new Error("Forbidden value (" + this.wave + ") on element wave.");
    }
    param1.writeByte(this.wave);
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeVarShort(this.level);
    param1.writeByte(this.breed);

    if (this.companionId < 0) {
      throw new Error("Forbidden value (" + this.companionId + ") on element companionId.");
    }
    param1.writeByte(this.companionId);
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

    this.masterId = param1.readDouble();
    if (this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.masterId
              + ") on element of GameFightFighterCompanionLightInformations.masterId.");
    }
  }
}
