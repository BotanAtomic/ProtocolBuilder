package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightEntityDispositionInformations extends EntityDispositionInformations
    implements INetworkType {

  public Number carryingCharacterId = 0;
  public static final int protocolId = 217;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.cellId < -1 || this.cellId > 559) {
      throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeShort(this.cellId);
    param1.writeByte(this.direction);

    if (this.carryingCharacterId < -9.007199254740992E15
        || this.carryingCharacterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.carryingCharacterId + ") on element carryingCharacterId.");
    }
    param1.writeDouble(this.carryingCharacterId);
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

    this.carryingCharacterId = param1.readDouble();
    if (this.carryingCharacterId < -9.007199254740992E15
        || this.carryingCharacterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.carryingCharacterId
              + ") on element of FightEntityDispositionInformations.carryingCharacterId.");
    }
  }
}
