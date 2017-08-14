package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTemporaryBoostEffect extends AbstractFightDispellableEffect
    implements INetworkType {

  public int delta = 0;
  public static final int protocolId = 209;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.uid < 0) {
      throw new Error("Forbidden value (" + this.uid + ") on element uid.");
    }
    param1.writeVarInt(this.uid);
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
    param1.writeShort(this.turnDuration);
    param1.writeByte(this.dispelable);
    if (this.spellId < 0) {
      throw new Error("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
    if (this.effectId < 0) {
      throw new Error("Forbidden value (" + this.effectId + ") on element effectId.");
    }
    param1.writeVarInt(this.effectId);
    if (this.parentBoostUid < 0) {
      throw new Error("Forbidden value (" + this.parentBoostUid + ") on element parentBoostUid.");
    }
    param1.writeVarInt(this.parentBoostUid);

    param1.writeShort(this.delta);
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

    this.delta = param1.readShort();
  }
}
