package com.ankamagames.dofus.network.types.game.action.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.actions.fight.AbstractFightDispellableEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightDispellableEffectExtendedInformations extends Object implements INetworkType {

  public int actionId = 0;
  public Number sourceId = 0;
  public AbstractFightDispellableEffect effect;
  private FuncTree _effecttree;
  public static final int protocolId = 208;

  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeDouble(this.sourceId);
    param1.writeShort(this.effect.getTypeId());
    this.effect.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.actionId = param1.readVarUhShort();
    if (this.actionId < 0) {
      throw new Error(
          "Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
    }

    this.sourceId = param1.readDouble();
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.sourceId
              + ") on element of FightDispellableEffectExtendedInformations.sourceId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    this.effect = ProtocolTypeManager.getInstance(AbstractFightDispellableEffect, _loc2_);
    this.effect.deserialize(param1);
  }
}
