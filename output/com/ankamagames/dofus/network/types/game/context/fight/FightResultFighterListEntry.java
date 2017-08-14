package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightResultFighterListEntry extends FightResultListEntry implements INetworkType {

  public Number id = 0;
  public boolean alive = false;
  public static final int protocolId = 189;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeVarShort(this.outcome);
    if (this.wave < 0) {
      throw new Error("Forbidden value (" + this.wave + ") on element wave.");
    }
    param1.writeByte(this.wave);
    this.rewards.serializeAs_FightLoot(param1);

    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    param1.writeBoolean(this.alive);
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

    this.id = param1.readUTF();

    this.alive = param1.readBoolean();
  }
}
