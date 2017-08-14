package com.ankamagames.dofus.network.types.game.data.items.effects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectCreature extends ObjectEffect implements INetworkType {

  public int monsterFamilyId = 0;
  public static final int protocolId = 71;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);

    if (this.monsterFamilyId < 0) {
      throw new Error("Forbidden value (" + this.monsterFamilyId + ") on element monsterFamilyId.");
    }
    param1.writeVarShort(this.monsterFamilyId);
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

    this.monsterFamilyId = param1.readVarUhShort();
    if (this.monsterFamilyId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.monsterFamilyId
              + ") on element of ObjectEffectCreature.monsterFamilyId.");
    }
  }
}
